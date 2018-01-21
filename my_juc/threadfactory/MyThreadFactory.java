package my_juc.threadfactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author gongxb
 *
 * 2018Äê1ÔÂ21ÈÕ
 */
public class MyThreadFactory implements ThreadFactory{
	private String name;
	private int count;
	private List<String> list;
	

	/**
	 * @param name
	 * @param count
	 * @param list
	 */
	public MyThreadFactory(String name) {
		super();
		this.name = name;
		this.count = 1;
		this.list = new ArrayList<String>();
	}


	@Override
	public Thread newThread(Runnable runnable) {
		Thread t=new Thread(runnable,name+"-Thread_"+count);
		count++;
		list.add(String.format("Created thread %d with name %s on %s \n", t.getId(), t.getName(), new Date()));
		return t;
	}
	
	public String getListContent() {
		StringBuilder builder=new StringBuilder();
		Iterator it=this.list.iterator();
		while(it.hasNext()) {
			builder.append(it.next());
		}
		return builder.toString();
	}
	
	public static class Task implements Runnable{
		public void run() {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		MyThreadFactory mtf=new MyThreadFactory("MyThreadFactory");
		Task task=new Task();
		Thread thread;
		System.out.printf("Starting the Threads\n");
        for (int i = 1; i <= 10; i++) {
            thread = mtf.newThread(task);
            thread.start();
        }
        System.out.printf("All Threads are created now\n\n");
        System.out.printf("Give me CustomThreadFactory stats:\n\n" + mtf.getListContent());
	}
}
