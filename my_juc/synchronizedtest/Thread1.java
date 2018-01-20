package my_juc.synchronizedtest;

/**
 * @author gongxb
 *
 * 2018年1月20日
 * 
 * 同步方法
 */
public class Thread1 extends Thread {
	public Thread1(String name) {
		super();
	}
	public Thread1() {
		super();
	}
	@Override
	public void run() {
		synchronized(this) {
			for(int i=0;i<3;i++) {
				try {
					Thread.sleep(1000);
					System.out.println( Thread.currentThread().getName()+"占用了进程"+i);
				} catch (InterruptedException e) {
					e.printStackTrace();
					
				}
			}
		}
	}

}
