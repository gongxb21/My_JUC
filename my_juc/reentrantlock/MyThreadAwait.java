package my_juc.reentrantlock;

/**
 * @author gongxb
 *
 * 2018Äê1ÔÂ20ÈÕ
 */
public class MyThreadAwait extends Thread{
	
	private MyThreaddomain md;
	
	public MyThreadAwait(MyThreaddomain md) {
		this.md= md;
	}
	
	public void run() {
		try {
			md.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
