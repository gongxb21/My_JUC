package my_juc.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author gongxb
 *
 * 2018��1��21��
 */
public class RecursiveTaskTest {
	
	/**
	 * @author gongxb
	 * Recursice �ݹ�
	 *
	 * 2018��1��21��
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
     	ForkJoinTask��jdk1.7����Fork/Join�������fork+�ϲ�join���������д��������
		     ˼��:������ö��CPU�Ѽ����ֳɶ�������񣬲��м��㣬���CPU�����ʴ���������ʱ�䡣�е���MapReduce˼·�о�����һ����
		     jdk7���Ѿ��ṩ������Ľӿڣ����㲻��Ҫ̫��ʱ����Ĳ���ʱ�̵߳�ͨ�ţ��������⣬�߳�ͬ�������������ṩ�Ľӿڣ�
		     RecursiveAction �޷���ֵ����
		     RecursiveTask�з���ֵ���͡�
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
     * ForkJoinPool�ṩ��һϵ�е�submit��������������
     * ForkJoinPoolĬ�ϵ��߳���ͨ��Runtime.availableProcessors()��ã�
     * ��Ϊ�ڼ����ܼ��͵������У���ö��ڴ����Ժ��������̲߳����ܻ�ø�������������
     * �÷���Ҳ���Դ���ǰ��Runnable, Callback�Ľӿ�ʵ�֣��ײ�Ὣ���װ��ForkJoinTask����
     */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//�õ�cpu����
		System.out.println("cpu count"+Runtime.getRuntime().availableProcessors());
		Demo demo=new Demo(1,25);
		ForkJoinPool fjp=new ForkJoinPool();
		Future<Integer> res=fjp.submit(demo);
		System.out.println(res.get()+"");
	}
	
}
