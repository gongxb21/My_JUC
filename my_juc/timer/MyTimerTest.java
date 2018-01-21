package my_juc.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author gongxb
 *
 *         2018年1月21日
 */
public class MyTimerTest {
	public static void main(String[] args) throws ParseException {
		//test1();
		test2();
	}

	public static void test1() throws ParseException {
		// 设置为守护线程
		Timer timer = new Timer(true);
		// Timer timer=new Timer();
		TimerTask task = new MyTimerTask();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = "2018-01-21 13:57:40";
		Date d = sdf.parse(dateString);
		System.out.println("Date is " + d.toLocaleString());
		System.out.println("now is " + new Date().toLocaleString());

		timer.schedule(task, d);

	}
	
	public static void test2() throws ParseException {
		Timer timer=new Timer();
		TimerTask task=new MyTimerTask();
		TimerTask task2=new MyTimerTask();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = "2018-01-21 14:01:40";
		Date d = sdf.parse(dateString);
		System.out.println("Date start is " + d.toLocaleString());
		System.out.println("now start is " + new Date().toLocaleString());
		String dateStringend = "2018-01-21 14:04:10";
		Date dateend = sdf.parse(dateStringend);
		System.out.println("Date end is " + d.toLocaleString());
		System.out.println("now  end is " + new Date().toLocaleString());
		timer.schedule(task, d);
		timer.schedule(task2, dateend);
	}
}
