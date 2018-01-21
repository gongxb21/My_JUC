package my_juc.countdownlunch;

import java.util.concurrent.CountDownLatch;

/**
 * @author gongxb
 *workthread
 * 2018Äê1ÔÂ21ÈÕ
 */
public class WorkThread extends Thread{
	private CountDownLatch cdl;
	public WorkThread(CountDownLatch cdl) {
		this.cdl=cdl;
		
	}
	public void run() {
		System.out.println("work thread run() start ,now is "+System.currentTimeMillis());
		cdl.countDown();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("work thread run() end ,now is "+System.currentTimeMillis());
	}
}
