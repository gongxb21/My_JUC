package my_juc.threadfactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author gongxb
 *
 * 2018Äê1ÔÂ21ÈÕ
 */
public class MyThreadFactoryTest {
	
	public static class WorkThread extends Thread  {
		private Runnable runnable;
		private AtomicInteger count;
		
		/**
		 * @param runnable
		 * @param count
		 */
		public WorkThread(Runnable runnable, AtomicInteger count) {
			super();
			this.runnable = runnable;
			this.count = count;
		}
		
		public void run() {
			runnable.run();
		}
	}
	
	public static class MyThread implements Runnable{
		public void run() {
			System.out.println("my thread run mthod");
		}
	}
	
	public static void main(String[] args) {
		ExecutorService executorService=Executors.newCachedThreadPool(new ThreadFactory() {
			private AtomicInteger count=new AtomicInteger();
			@Override
			public Thread newThread(Runnable r) {
				int c=count.getAndIncrement();
				System.out.println("create no." + c + " Threads");
                return new WorkThread(r,count);
			}
		});
		  	executorService.execute(new MyThread());
	        executorService.execute(new MyThread());
	        executorService.execute(new MyThread());
	        executorService.execute(new MyThread());
	        executorService.execute(new MyThread());
	        executorService.execute(new MyThread()); 

	        executorService.shutdown();

	        try {
	            executorService.awaitTermination(1200, TimeUnit.SECONDS);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	       }
        }
}
