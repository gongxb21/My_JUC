package my_juc.synchronizedtest;

/**
 * @author gongxb
 *
 * 2018年1月20日
 * 测试死锁
 */
public class DeadLock {
	public Object obj1=new Object();
	public Object obj2=new Object();
	
	public void metohd1() {
		synchronized (obj1) {
			System.out.println("mthod1 获取到 obj1 锁");
			synchronized (obj2) {
				try {
					Thread.sleep(2000);
					System.out.println("method1 获取到obj2 锁");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void metohd2() {
		synchronized (obj2) {
			System.out.println("mthod2 获取到 obj2 锁");
			synchronized (obj1) {
				try {
					Thread.sleep(2000);
					System.out.println("method2 获取到obj1 锁");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
