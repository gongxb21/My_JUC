package my_juc.productercustomer.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author gongxb
 *
 * 2018��1��20��
 */
public class QueueProductCustomer {
	final  BlockingQueue<String> bq=new ArrayBlockingQueue<String>(10);
	
	Runnable runnable1=new Runnable() {
		int i=0;
		public void run() {
			try {
				while (true) {
					System.out.println("����һ�� now is" + ++i);
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
					System.out.println("������һ�� " + bq.take());
					Thread.sleep(3000);//���Ӧ�ñ������ߵ�ʱ�䳤
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
