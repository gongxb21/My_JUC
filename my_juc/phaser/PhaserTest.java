package my_juc.phaser;

import java.util.concurrent.Phaser;


/**
 * @author gongxb
 *
 *         2018年1月21日
 */
public class PhaserTest {
	public static void main(String[] args) {
		final int count = 3;
		final Phaser phaser = new Phaser(count); // 总共有3个registered parties
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
			phaser.arriveAndAwaitAdvance();// 每执行到这里，都会有一个party arrive，如果arrived parties等于registered
											// parties，就往下继续执行，否则等待
			System.out.println("ID:" + Thread.currentThread().getId() + " start");
		}

	}
}
