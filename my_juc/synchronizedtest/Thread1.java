package my_juc.synchronizedtest;

/**
 * @author gongxb
 *
 * 2018��1��20��
 * 
 * ͬ������
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
					System.out.println( Thread.currentThread().getName()+"ռ���˽���"+i);
				} catch (InterruptedException e) {
					e.printStackTrace();
					
				}
			}
		}
	}

}
