package my_juc.reentrantlock;

/**
 * @author gongxb
 *
 * 2018Äê1ÔÂ20ÈÕ
 */
public class MyThreadSingal extends Thread{
	private MyThreaddomain md;
	public MyThreadSingal(MyThreaddomain md) {
		this.md=md;
	}
	public void run() {
		System.out.println("before signnal");
		md.signal();
		System.out.println("after singal");
	}

}
