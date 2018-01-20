package my_juc.synchronizedtest;

/**
 * @author gongxb
 *
 * 2018年1月20日
 * 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程仍然可以访问“该对象”的非同步代码块
 */
public class Thread2 {
	private String name;
	public Thread2() {
	
	}
	public Thread2(String name) {
		this.name=name;
	}
	public  void syncMeothod()  {
		synchronized(this) {
			for(int i=0;i<3;i++) {
				try {
					Thread.sleep(2000);
					System.out.println("同步方法"+i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void noSyncMethod() {
		for(int i=0;i<3;i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("非同步方法"+i);
		}
	}
	public void anotherSyncMethod() {
		synchronized (this) {
			for(int i=0;i<3;i++) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("第二个同步方法"+i);
			}
		}
	}
	
}
