package my_juc.dqueue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author gongxb
 *
 * 2018Äê1ÔÂ21ÈÕ
 */
public class Dqueue {
	public static void main(String[] args) {
		BlockingDeque blockingDeque=new LinkedBlockingDeque(10);
		blockingDeque.add("1");
		blockingDeque.addFirst("2");
		blockingDeque.addLast("10");
		
		System.out.println(blockingDeque.getFirst());
		System.out.println(blockingDeque.poll());
		System.out.println(blockingDeque.poll());
		System.out.println(blockingDeque.getLast());
	}
}
