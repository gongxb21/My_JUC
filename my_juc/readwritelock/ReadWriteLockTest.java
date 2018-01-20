package my_juc.readwritelock;

/**
 * @author gongxb
 *
 * 2018年1月20日
 */
public class ReadWriteLockTest {
	public static void main(String[] args) {
		//readLock();
		//writeLock();
		readWriteLock();
	}
	/**
	 * 证明了读锁是共享锁
	 * 
	 * void
	 */
	public static void readLock() {
		MyThreadReadLock rl=new MyThreadReadLock();
		Thread t1=new Thread(new Runnable() {
			public void run() {
				try {
					rl.read();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2=new Thread(new Runnable() {
			public void run() {
				try {
					rl.read();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
	}
	
	/**
	 * 证明了写锁是独享锁
	 * 
	 * void
	 */
	public static void writeLock() {
		MyThreadWriteLock wl=new MyThreadWriteLock();
		Thread t1=new Thread(new Runnable() {
			public void run() {
					wl.write();
			}
		});
		Thread t2=new Thread(new Runnable() {
			public void run() {
				wl.write();
			}
		});
		
		t1.start();
		t2.start();
	}
	
	/**
	 * 证明了读写锁是互斥的
	 * 
	 * void
	 */
	public static void readWriteLock() {
		MyThreadReadLock rl=new MyThreadReadLock();
		Thread t1=new Thread(new Runnable() {
			public void run() {
				try {
					rl.read();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2=new Thread(new Runnable() {
			public void run() {
					rl.write();
			}
		});
		
		
		t1.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
	}
	
}
