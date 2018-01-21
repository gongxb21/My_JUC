package my_juc.threadgroup;

/**
 * @author gongxb
 *
 * 2018Äê1ÔÂ21ÈÕ
 */
public class ThreadGroupThread extends Thread{
	public void run() {
		try {
			System.out.println("the Thread is not interrupted");
			while(this.isInterrupted()) {
				System.out.println("the Thread is  interrupted");
				Thread.sleep(1000);
			}
			
		}catch (Exception e) {

		}
	}
	
}
