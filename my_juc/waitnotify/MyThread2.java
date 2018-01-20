package my_juc.waitnotify;

/**
 * @author gongxb
 *
 * 2018Äê1ÔÂ20ÈÕ
 */
public class MyThread2 implements Runnable{
	private Object lock;
	public MyThread2 (Object lock) {
		this.lock=lock;
	}
	
	public void run() {
		synchronized (lock) {
			System.out.println("notify start now is "+System.currentTimeMillis());
			lock.notify();
			System.out.println("notify end now is "+System.currentTimeMillis());
		}
	}
	
}
