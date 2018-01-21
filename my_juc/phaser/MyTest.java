package my_juc.phaser;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;


/**
 * @author gongxb
 *
 * 2018��1��21��
 */
public class MyTest {
	
	/**
     Phaser��һ�������߳�ͬ�����ߣ���������CyclicBarrier��CountDownLatch����ع���
	    ���ȣ�����һ�������Phaser���CountDownLatch������CountDownLatch���ԣ���2����Ҫ�ķ�����
	    һ����await()����������ʹ�߳̽���ȴ�״̬����Phaser�У���֮��Ӧ�ķ�����awaitAdvance(int n)��
	    CountDownLatch����һ����Ҫ�ķ�����countDown()��ʹ��������һ����������Ϊ0ʱ���еȴ����߳̿�ʼִ�У�
	    ��Phaser�У���֮��Ӧ�ķ�����arrive()����������Ӵ�����3���̣߳���ӡһЩ��ĸ�������̴߳����ú󲢲�����ִ�У�
	    �������������ж�����п��ƣ�3���Ӻ����н���ͬʱ��ʼִ�У�һ����ʹ��Phaserʵ�ֵİ汾����ע���н�������θ����CountDownLatch�汾��
    */
	public static void main(String[] args) {
		Phaser phaser = new Phaser(1); //�˴���ʹ��CountDownLatch(1)
        for(int i=0; i<3; i++) {
            new MyThread((char)(97+i), phaser).start();
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        phaser.arrive();  //�˴���ʹ��latch.countDown()
	}
	public static class MyThread extends Thread{
		private char mychar;
		private Phaser phaser;
		/**
		 * @param mychar
		 * @param phaser
		 */
		public MyThread(char mychar, Phaser phaser) {
			super();
			this.mychar = mychar;
			this.phaser = phaser;
		}
		@Override
		public void run() {
			phaser.awaitAdvance(phaser.getPhase());
			for(int i=0; i<10; i++) {
                System.out.print(mychar+" ");
                if(i % 10 == 9) {
                    System.out.println();
                }
            }
		}
	}
}
