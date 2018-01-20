package my_juc.threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gongxb
 *
 * 2018Äê1ÔÂ20ÈÕ
 */
public class ThreadLocalThread extends Thread {
	private String name;
	private ThreadLocal<String> tl=new ThreadLocal<String>();
	private static AtomicInteger ai=new AtomicInteger();
	public ThreadLocalThread(String name) {
		this.name=name;
	}
	
	public  void run () {
		for(int i=0;i<3;i++) {
			tl.set(ai.addAndGet(1)+"");
			System.out.println(Thread.currentThread().getName()+"  add method ai is "+tl.get());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
