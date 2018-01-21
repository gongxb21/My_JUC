package my_juc.countdownlunch;

import java.util.concurrent.CountDownLatch;

/**
 * @author gongxb
 *
 * 2018Äê1ÔÂ21ÈÕ
 */
public class AwaitThread extends Thread {
	private CountDownLatch cdl;
	public AwaitThread(CountDownLatch cdl) {
		this.cdl=cdl;
	}
	
	public void run() {
		System.out.println("await thread 2 start run ,now is "+System.currentTimeMillis());
		try {
			cdl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("await thread 2 end run ,now is "+System.currentTimeMillis());
	}
}
