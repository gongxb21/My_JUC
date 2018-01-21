package my_juc.countdownlunch;

import java.util.concurrent.CountDownLatch;

/**
 * @author gongxb
 *
 * 2018Äê1ÔÂ21ÈÕ
 */
public class CountdownLunchTest {
	public static void main(String[] args) throws InterruptedException {
		test1();
	}
	public static void test1() throws InterruptedException {
		CountDownLatch cdl=new CountDownLatch(3);
		WorkThread wt= new WorkThread(cdl);
		WorkThread wt1= new WorkThread(cdl);
		WorkThread wt2= new WorkThread(cdl);
		AwaitThread at4=new AwaitThread(cdl);
		
		at4.start();
		Thread.sleep(1000);
		wt.start();
		wt2.start();
		wt1.start();
	}
	/**
	 * @param cdl
	 * @return
	 * MyThread
	 */
	private static WorkThread MyThread(CountDownLatch cdl) {
		
		return null;
	}
}
