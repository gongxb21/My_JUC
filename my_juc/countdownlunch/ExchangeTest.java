package my_juc.countdownlunch;

import java.util.concurrent.Exchanger;

/**
 * @author gongxb
 *
 * 2018��1��21��
 */
public class ExchangeTest {
	public static void main(String[] args) {
		test();
	}
	public static void test() {
		Exchanger exchanger=new Exchanger();
		ExchangeThread et=new ExchangeThread("haha", exchanger) ;
		ExchangeThread et1=new ExchangeThread("haha1", exchanger) ;
		
		et.start();
		et1.start();
		
	}
}
