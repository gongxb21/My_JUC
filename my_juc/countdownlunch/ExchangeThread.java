package my_juc.countdownlunch;

import java.util.concurrent.Exchanger;

/**
 * @author gongxb
 *
 * 2018Äê1ÔÂ21ÈÕ
 */
public class ExchangeThread extends Thread{
	public String name;
	private Exchanger<String> exchanger=new Exchanger<String>();
	
	public ExchangeThread(String name,Exchanger exchanger) {
		this.name=name;
		this.exchanger=exchanger;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName()+"start time:"+System.currentTimeMillis());
		System.out.println(this.getName());
		try {
			String Str=exchanger.exchange(name);
			System.out.println(this.getName()+" after change Str="+Str);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
