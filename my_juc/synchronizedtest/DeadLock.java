package my_juc.synchronizedtest;

/**
 * @author gongxb
 *
 * 2018��1��20��
 * ��������
 */
public class DeadLock {
	public Object obj1=new Object();
	public Object obj2=new Object();
	
	public void metohd1() {
		synchronized (obj1) {
			System.out.println("mthod1 ��ȡ�� obj1 ��");
			synchronized (obj2) {
				try {
					Thread.sleep(2000);
					System.out.println("method1 ��ȡ��obj2 ��");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void metohd2() {
		synchronized (obj2) {
			System.out.println("mthod2 ��ȡ�� obj2 ��");
			synchronized (obj1) {
				try {
					Thread.sleep(2000);
					System.out.println("method2 ��ȡ��obj1 ��");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
