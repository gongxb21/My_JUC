package my_juc.countdownlunch;

import java.util.concurrent.Semaphore;

/**
 * @author gongxb
 *
 * 2018年1月21日
 */
public class SemaphoreTest {
	public static void main(String[] args) {
		test1();
	}
	/**
	 * 1、单值的Semaphore管理的信号量只有1个，该信号量只能被1个，只能被一个线程所获得，意味着并发的代码只能被一个线程运行，这就相当于是一个互斥锁了
	 * 2、多值的Semaphore管理的信号量多余1个，主要用于控制并发数
	 * 
	 * void
	 */
	public static  void test1() {
		final Semaphore sph=new Semaphore(4);
		
		Runnable runnable=new Runnable() {
			public void run() {
				try {
					sph.acquire();
					System.out.println(Thread.currentThread().getName() + "获得了信号量,时间为" + System.currentTimeMillis());
	                Thread.sleep(2000);
	                System.out.println(Thread.currentThread().getName() + "释放了信号量,时间为" + System.currentTimeMillis());
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
