package my_juc.threadgroup;

/**
 * @author gongxb
 *
 * 2018��1��21��
 */
public class ThreadGroupThreadTest {
	public static void main(String[] args) throws InterruptedException {
		//test1();
		//test2();
		test3();
	}
	
	/**
	 * ThreadGroup �Ĺ��췽��
	 * 
	 * void
	 */
	public static void test1() {
		ThreadGroupThread tgt=new ThreadGroupThread();
		ThreadGroupThread tgt2=new ThreadGroupThread();
		ThreadGroup tg=new ThreadGroup("myThreadGroup");
		
		Thread t1=new Thread(tg,"thread1");
		Thread t2=new Thread(tg,"thread2");
		t1.start();
		t2.start();
		System.out.println("thread group .count is "+tg.activeCount());
		System.out.println("thread group . name is "+tg.getName());
		
	}
	/**
	 * û��ָ���߳��飬��ô�Զ��鵽��ǰ�߳��������߳�����
	 * 
	 * void
	 */
	public static void test2() {
		ThreadGroupThread tgt=new ThreadGroupThread();
		Thread t1=new Thread(tgt);
		Thread t2=new Thread(tgt);
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getThreadGroup().getName());
		t2.start();
		System.out.println(Thread.currentThread().getThreadGroup().getName());
		
	}
	/**
	 * ThreadGroup�е�interrupt()���������ж����߳����ڵ��߳�
	 * @throws InterruptedException
	 * void
	 */
	public static void test3() throws InterruptedException {
		ThreadGroup tg=new ThreadGroup("MyThreadGroup");
		ThreadGroupThread tgt=new ThreadGroupThread();
		Thread t=null;
		for(int i=0;i<3;i++) {
			t=new Thread(tg,tgt);
			t.start();
		}
		Thread.sleep(2000);
		tg.interrupt();
		System.out.println("������ interrupt ����");
		System.out.println("active count is"+tg.activeCount());
		
	}
}
