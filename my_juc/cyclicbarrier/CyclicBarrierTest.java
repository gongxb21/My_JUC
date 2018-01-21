package my_juc.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * @author gongxb
 *
 * 2018Äê1ÔÂ21ÈÕ
 */
public class CyclicBarrierTest {
	public static void main(String[] args) {
		test1();
	}
	public static void test1() {
		CyclicBarrier cb=new CyclicBarrier(3);
		CyclicbarrierThread cbt=new CyclicbarrierThread(cb);
		CyclicbarrierThread cbt1=new CyclicbarrierThread(cb);
		CyclicbarrierThread cbt2=new CyclicbarrierThread(cb);
		try {
			
			cbt.start();
			Thread.sleep(1000);
			cbt2.start();
			Thread.sleep(2000);
			cbt1.start();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
