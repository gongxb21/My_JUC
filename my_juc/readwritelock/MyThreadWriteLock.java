package my_juc.readwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author gongxb
 *
 * 2018年1月20日
 */
public class MyThreadWriteLock  extends ReentrantReadWriteLock{
	public void write()  {
		writeLock().lock();
		System.out.println(Thread.currentThread().getName()+"获得了write锁  now is "+System.currentTimeMillis());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			writeLock().unlock();
		}
	}
}
