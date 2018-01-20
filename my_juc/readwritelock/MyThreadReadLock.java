package my_juc.readwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author gongxb
 *
 * 2018��1��20��
 */
public class MyThreadReadLock extends ReentrantReadWriteLock {
	
	public void read() throws InterruptedException {
		try {
			readLock().lock();
			System.out.println(Thread.currentThread().getName()+"�����read����now is "+System.currentTimeMillis());
			Thread.sleep(3000);
		}finally {
			readLock().unlock();
		}
	}	
	public void write()  {
		writeLock().lock();
		System.out.println(Thread.currentThread().getName()+"�����write��  now is "+System.currentTimeMillis());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			writeLock().unlock();
		}
	}
}
