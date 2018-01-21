package my_juc.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author gongxb
 *
 * 2018年1月21日
 */
public class RecursiveTaskTest {
	
	/**
	 * @author gongxb
	 * Recursice 递归
	 *
	 * 2018年1月21日
	 */
	private static class Demo extends RecursiveTask<Integer>{
		private int start;
		private int end;
		
		private Demo() {}
		public Demo(int start,int end) {
			this.start=start;
			this.end=end;
		}
		/**
     	ForkJoinTask是jdk1.7整合Fork/Join，即拆分fork+合并join，性能上有大大提升。
		     思想:充分利用多核CPU把计算拆分成多个子任务，并行计算，提高CPU利用率大大减少运算时间。有点像，MapReduce思路感觉大致一样。
		     jdk7中已经提供了最简洁的接口，让你不需要太多时间关心并行时线程的通信，死锁问题，线程同步，下面是它提供的接口：
		     RecursiveAction 无返回值任务。
		     RecursiveTask有返回值类型。
		*/
		@Override
		protected Integer compute() {
			if(end-start<0) {
				try {
					throw new Exception();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			int sum=0;
			if(end-start<20) {
				for(int i=start;i<end;i++){
					sum+=i;
				}
			}else {
				int middle =(start+end)/2;
				Demo left=new Demo(start ,middle);
				Demo right=new Demo(middle ,end);
				left.fork();
				right.fork();
				sum=left.join()+left.join();
			}
			return sum;
		}
		
	}
	
	/**
     * ForkJoinPool提供了一系列的submit方法，计算任务。
     * ForkJoinPool默认的线程数通过Runtime.availableProcessors()获得，
     * 因为在计算密集型的任务中，获得多于处理性核心数的线程并不能获得更多性能提升，
     * 该方法也可以传以前的Runnable, Callback的接口实现（底层会将其封装成ForkJoinTask对象）
     */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//得到cpu数量
		System.out.println("cpu count"+Runtime.getRuntime().availableProcessors());
		Demo demo=new Demo(1,25);
		ForkJoinPool fjp=new ForkJoinPool();
		Future<Integer> res=fjp.submit(demo);
		System.out.println(res.get()+"");
	}
	
}
