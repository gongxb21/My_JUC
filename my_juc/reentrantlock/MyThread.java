package my_juc.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gongxb
 *
 * 2018��1��20��
 */
public class MyThread extends Thread{
	
	/**
	 * �������֤��ReentrantLock ��һ��������
	 */
	//private static ReentrantLock lock =new ReentrantLock();
	
	private ReentrantLock lock=new ReentrantLock();
	
	public void run() {
		try {
			lock.lock();
			for (int i = 0; i < 2; i++) {
				System.out.println(Thread.currentThread().getName() + "run method" + i);
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			System.out.println("catch a exception " + e.getMessage());
		} finally {
			lock.unlock();
		}
	}
	
	
}
