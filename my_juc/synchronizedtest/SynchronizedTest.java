package my_juc.synchronizedtest;

/**
 * @author gongxb
 *
 * 2018年1月20日
 */
public class SynchronizedTest {

	public static void main(String[] args) {
		//test1();
		//test2();
		//test3();
		//test4();
		test5();
	}
	public  static void test1() {
		//synchronized 是对象锁，锁的对象不是同一个，所以这两个线程不会出现交替执行的情况，而是一个执行完之后，才执行另外一个
		Thread1 t1 = new Thread1();
		Thread td1 = new Thread(t1, "thread1");
		Thread td2 = new Thread(t1, "thread2");
		td1.start();
		td2.start();
	}
	public static void test2() {
		//synchronized 是对象锁，锁的对象是同一个，所以这两个线程会出现交替执行的情况
		Thread1 t1=new Thread1("t1");
		Thread1 t2=new Thread1("t1");
		
		t1.start();
		t2.start();
	}
	public static void test3() {
		//当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程仍然可以访问“该对象”的非同步代码块
		Thread t1=new Thread(new Runnable() {
			public void run() {
				new Thread2().syncMeothod();
			}
		});
		
		Thread t2=new Thread(new Runnable() {
			public void run() {
				new Thread2().noSyncMethod();
			}
		});
		
		t1.start();
		t2.start();
	}
	public static void test4() {
		//当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程对“该对象”的其他的“synchronized方法”或者“synchronized代码块”的访问将被阻塞
		Thread2 th2=new Thread2();
		Thread t1=new Thread(new Runnable() {
			public void run() {
				th2.syncMeothod();
			}
		});
		
		Thread t2=new Thread(new Runnable() {
			public void run() {
				th2.anotherSyncMethod();
			}
		});
		
		t1.start();
		t2.start();
	}
	/**
	 * 测试死锁 
	 * 
	 * 如何避免死锁
	 * 1、一个程序只用一个锁；
	 * 2、用多个锁的时候，尽可能保证锁的顺序，尽量减少锁的交互
	 * 3、可以使用Lock类中的tryLock方法去尝试获取锁，这个方法可以指定一个超时时限，在等待超过该时限之后变回返回一个失败信息
	 * 
	 * void
	 */
	public static void test5() {
		DeadLock dl=new DeadLock();
		Thread t1=new Thread(new Runnable() {
			public void run() {
				dl.metohd1();
			}
		});
		Thread t2=new Thread(new Runnable() {
			public void run() {
				dl.metohd2();
			}
		});
		
		t1.start();
		t2.start();
	}
}
