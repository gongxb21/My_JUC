package my_juc.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gongxb
 *
 * 2018年1月20日
 */
public class MyThread extends Thread{
	
	/**
	 * 这个可以证明ReentrantLock 是一个对象锁
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
