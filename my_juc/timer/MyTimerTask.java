package my_juc.timer;

import java.util.TimerTask;

/**
 * @author gongxb
 *
 * 2018Äê1ÔÂ21ÈÕ
 */
public class MyTimerTask  extends TimerTask {
	public void run() {
		System.out.println("now is "+System.currentTimeMillis());
		System.out.println(" my timer task .run()");
	}

}
