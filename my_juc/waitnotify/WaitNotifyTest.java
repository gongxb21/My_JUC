package my_juc.waitnotify;

/**
 * @author gongxb
 *
 * 2018��1��20��
 */
public class WaitNotifyTest {
	
	public static void main(String[] args) throws InterruptedException {
		//test1();
		//test2();
		//test3();
		interruptTest();
	}
	//�����н�����Կ�������notify֮��wait��������ִ��
	public static void test1() throws InterruptedException {
		Object lock=new Object();
		Thread1 td1=new Thread1(lock);
		MyThread2 td2=new MyThread2(lock);
		
		Thread thread=new Thread(td1);
		Thread thread2=new Thread(td2);
		thread.start();
		Thread.sleep(2000);
		thread2.start();
	}
	/**
	 * ֤����wait ���ͷ���
	 * 
	 * void
	 * @throws InterruptedException 
	 */
	public static void test2() throws InterruptedException {
		Object lock=new Object();
		Thread1 td1=new Thread1(lock);
		Thread1 td2=new Thread1(lock);
		
		Thread thread=new Thread(td1);
		Thread thread2=new Thread(td2);
		thread.start();
		Thread.sleep(2000);
		thread2.start();
	}
	/**
	 * ֤����notify�ǲ��ͷ�����
	 * @throws InterruptedException
	 * void
	 */
	public static void test3() throws InterruptedException {
		Object lock=new Object();
		MyThread2 td1=new MyThread2(lock);
		MyThread2 td2=new MyThread2(lock);
		
		Thread thread=new Thread(td1);
		Thread thread2=new Thread(td2);
		thread.start();
		Thread.sleep(2000);
		thread2.start();
	}
	/**
	 * interrupt()���������ò����ж��̣߳��������߳�������ʱ����߳�һ���жϱ�ʶ����ʾ���߳��жϡ�wait()����"������һ�ֳ���"��
	 * @throws InterruptedException
	 * void
	 */
	public static void interruptTest() throws InterruptedException {
		Object lock =new Object();
		Thread1 td1=new Thread1(lock);
		Thread thread=new Thread(td1);
		thread.start();
		Thread.sleep(3000);
		thread.interrupt();
		
		
	}
}
