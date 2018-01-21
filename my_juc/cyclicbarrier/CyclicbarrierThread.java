package my_juc.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author gongxb
 *
 * 2018��1��21��
 */
public class CyclicbarrierThread extends Thread {
	public CyclicBarrier cb;
	
	public CyclicbarrierThread(CyclicBarrier cb) {
		this.cb=cb;
	}
	
	public void run() {
		try {
			System.out.println(this.getName()+":::"+System.currentTimeMillis());
			System.out.println(this.getName() + "������");
	        Thread.sleep(2000);
	        System.out.println(this.getName() + "׼���ȴ���, ʱ��Ϊ" + System.currentTimeMillis());
	        cb.await();
	        System.out.println(this.getName() + "�����ȴ���, ʱ��Ϊ" + System.currentTimeMillis());
			
		}catch(Exception e) {
			System.out.println("catch a exception ");
		}
		
	}
}
