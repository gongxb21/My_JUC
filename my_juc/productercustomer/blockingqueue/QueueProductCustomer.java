package my_juc.productercustomer.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author gongxb
 *
 * 2018年1月20日
 */
public class QueueProductCustomer {
	final  BlockingQueue<String> bq=new ArrayBlockingQueue<String>(10);
	
	Runnable runnable1=new Runnable() {
		int i=0;
		public void run() {
			try {
				while (true) {
					System.out.println("生产一个 now is" + ++i);
					bq.put(i + "");
					Thread.sleep(1000);;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};
	
	Runnable runnable2 = new Runnable() {
		public void run() {
			try {
				 while (true) {
					System.out.println("消费了一个 " + bq.take());
					Thread.sleep(3000);//这个应该比生产者的时间长
				} 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};
	
	public static void main(String[] args) {
		QueueProductCustomer qpc=new QueueProductCustomer();
		Thread producerThread = new Thread(qpc.runnable1);
	    Thread customerThread = new Thread(qpc.runnable2);
	    producerThread.start();
	    customerThread.start();
	}
}
