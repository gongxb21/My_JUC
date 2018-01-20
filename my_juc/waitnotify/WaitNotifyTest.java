package my_juc.waitnotify;

/**
 * @author gongxb
 *
 * 2018年1月20日
 */
public class WaitNotifyTest {
	
	public static void main(String[] args) throws InterruptedException {
		//test1();
		//test2();
		//test3();
		interruptTest();
	}
	//从运行结果可以看到，在notify之后，wait方法继续执行
	public static void test1() throws InterruptedException {
		Object lock=new Object();
		Thread1 td1=new Thread1(lock);
		MyThread2 td2=new MyThread2(lock);
		
		Thread thread=new Thread(td1);
		Thread thread2=new Thread(td2);
		thread.start();
		Thread.sleep(2000);
		thread2.start();
	}
	/**
	 * 证明了wait 会释放锁
	 * 
	 * void
	 * @throws InterruptedException 
	 */
	public static void test2() throws InterruptedException {
		Object lock=new Object();
		Thread1 td1=new Thread1(lock);
		Thread1 td2=new Thread1(lock);
		
		Thread thread=new Thread(td1);
		Thread thread2=new Thread(td2);
		thread.start();
		Thread.sleep(2000);
		thread2.start();
	}
	/**
	 * 证明了notify是不释放锁的
	 * @throws InterruptedException
	 * void
	 */
	public static void test3() throws InterruptedException {
		Object lock=new Object();
		MyThread2 td1=new MyThread2(lock);
		MyThread2 td2=new MyThread2(lock);
		
		Thread thread=new Thread(td1);
		Thread thread2=new Thread(td2);
		thread.start();
		Thread.sleep(2000);
		thread2.start();
	}
	/**
	 * interrupt()方法的作用不是中断线程，而是在线程阻塞的时候给线程一个中断标识，表示该线程中断。wait()就是"阻塞的一种场景"，
	 * @throws InterruptedException
	 * void
	 */
	public static void interruptTest() throws InterruptedException {
		Object lock =new Object();
		Thread1 td1=new Thread1(lock);
		Thread thread=new Thread(td1);
		thread.start();
		Thread.sleep(3000);
		thread.interrupt();
		
		
	}
}
