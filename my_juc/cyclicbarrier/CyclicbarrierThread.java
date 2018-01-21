package my_juc.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author gongxb
 *
 * 2018年1月21日
 */
public class CyclicbarrierThread extends Thread {
	public CyclicBarrier cb;
	
	public CyclicbarrierThread(CyclicBarrier cb) {
		this.cb=cb;
	}
	
	public void run() {
		try {
			System.out.println(this.getName()+":::"+System.currentTimeMillis());
			System.out.println(this.getName() + "运行了");
	        Thread.sleep(2000);
	        System.out.println(this.getName() + "准备等待了, 时间为" + System.currentTimeMillis());
	        cb.await();
	        System.out.println(this.getName() + "结束等待了, 时间为" + System.currentTimeMillis());
			
		}catch(Exception e) {
			System.out.println("catch a exception ");
		}
		
	}
}
