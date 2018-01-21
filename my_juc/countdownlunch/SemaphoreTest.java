package my_juc.countdownlunch;

import java.util.concurrent.Semaphore;

/**
 * @author gongxb
 *
 * 2018��1��21��
 */
public class SemaphoreTest {
	public static void main(String[] args) {
		test1();
	}
	/**
	 * 1����ֵ��Semaphore������ź���ֻ��1�������ź���ֻ�ܱ�1����ֻ�ܱ�һ���߳�����ã���ζ�Ų����Ĵ���ֻ�ܱ�һ���߳����У�����൱����һ����������
	 * 2����ֵ��Semaphore������ź�������1������Ҫ���ڿ��Ʋ�����
	 * 
	 * void
	 */
	public static  void test1() {
		final Semaphore sph=new Semaphore(4);
		
		Runnable runnable=new Runnable() {
			public void run() {
				try {
					sph.acquire();
					System.out.println(Thread.currentThread().getName() + "������ź���,ʱ��Ϊ" + System.currentTimeMillis());
	                Thread.sleep(2000);
	                System.out.println(Thread.currentThread().getName() + "�ͷ����ź���,ʱ��Ϊ" + System.currentTimeMillis());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					sph.release();
				}
			}
		} ;
		
		Thread[] threads = new Thread[10];
	    for (int i = 0; i < threads.length; i++)
	        threads[i] = new Thread(runnable);
	    for (int i = 0; i < threads.length; i++)
	        threads[i].start();
	}
}
