package my_juc.waitnotify;

/**
 * @author gongxb
 *
 * 2018Äê1ÔÂ20ÈÕ
 */
public class Thread1  implements Runnable{
	public Object lock;
	public Thread1(Object lock) {
		this.lock=lock;
	}
	public Thread1() {
		
	}
	
	
	@Override
	public void run() {
		synchronized (lock) {
			try {
				System.out.println("start wait now is "+System.currentTimeMillis());
				lock.wait();
				System.out.println("end wait now is "+System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
