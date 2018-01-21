package my_juc.reentrantlock;

/**
 * @author gongxb
 *
 * 2018年1月20日
 */
public class ReentrantLockTest {
	public static void main(String[] args) throws InterruptedException {
		//lockTest();
		conditionTest();
	}
	
	/**
	 * 说明了一个线程打印完毕之后下一个线程才可以获得锁去打印数据，这也证明了ReentrantLock具有加锁的功能
	 * 
	 * void
	 */
	public static void lockTest() {
		WorkThread t1=new WorkThread();
		WorkThread t2=new WorkThread();
		WorkThread t3=new WorkThread();
		
		t1.start();
		t2.start();
		t3.start();
	}
	/**
	 * 成功利用ReentrantLock的Condition实现了等待/通知模型。其实这个例子还证明了一点，
	 * Condition的await()方法是释放锁的，原因也很简单，要是await()方法不释放锁，
	 * 那么signal()方法又怎么能调用到Condition的signal()方法呢？
	 *注意要是用一个Condition的话，那么多个线程被该Condition给await()后，调用
	 *Condition的signalAll()方法唤醒的是所有的线程。如果想单独唤醒部分线程该怎么办呢？
	 *new出多个Condition就可以了，这样也有助于提升程序运行的效率。
	 *使用多个Condition的场景是很常见的，像ArrayBlockingQueue里就有。
	 * 
	 * void
	 * @throws InterruptedException 
	 */
	public static void conditionTest() throws InterruptedException {
		MyThreaddomain md=new MyThreaddomain();
		MyThreadAwait mta=new MyThreadAwait(md);
		MyThreadSingal mts=new MyThreadSingal(md);
		
		mta.start();
		Thread.sleep(2000);
		mts.start();
	}
}
