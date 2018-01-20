package my_juc.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gongxb
 *
 * 2018Äê1ÔÂ20ÈÕ
 */
public class MyThreaddomain {
	private ReentrantLock lock=new ReentrantLock();
	private Condition condition=lock.newCondition();
	
	public void await() throws InterruptedException {
		try {
			lock.lock();
			System.out.println(Thread.currentThread().getName()+" await method  start now is "+System.currentTimeMillis());
			condition.await();
			System.out.println(Thread.currentThread().getName()+" await method end now is "+System.currentTimeMillis());
		}finally {
			lock.unlock();
		}
	}
	
	
	public void signal() {
		try {
			lock.lock();
			System.out.println(Thread.currentThread().getName()+"signal method start now is "+System.currentTimeMillis());
			condition.signal();
			System.out.println(Thread.currentThread().getName()+"signal method end now is "+System.currentTimeMillis());
			
		}finally {
			lock.unlock();
		}
	}
}
