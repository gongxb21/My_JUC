package my_juc.phaser;

import java.util.concurrent.Phaser;


/**
 * @author gongxb
 *
 *         2018��1��21��
 */
public class PhaserTest {
	public static void main(String[] args) {
		final int count = 3;
		final Phaser phaser = new Phaser(count); // �ܹ���3��registered parties
		for (int i = 0; i < 5; i++) {
			final Thread thread = new Thread(new Task(phaser, i));
			thread.start();
		}
	}

	public static class Task implements Runnable {
		private final Phaser phaser;
		private final Integer NO;

		/**
		 * @param phaser
		 * @param nO
		 */
		public Task(Phaser phaser, Integer nO) {
			super();
			this.phaser = phaser;
			NO = nO;
		}

		@Override
		public void run() {
			System.out.println("ID:" + Thread.currentThread().getId() + " Working");
			phaser.arriveAndAwaitAdvance();// ÿִ�е����������һ��party arrive�����arrived parties����registered
											// parties�������¼���ִ�У�����ȴ�
			System.out.println("ID:" + Thread.currentThread().getId() + " start");
		}

	}
}
