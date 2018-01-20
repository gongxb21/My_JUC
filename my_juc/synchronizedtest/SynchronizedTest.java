package my_juc.synchronizedtest;

/**
 * @author gongxb
 *
 * 2018��1��20��
 */
public class SynchronizedTest {

	public static void main(String[] args) {
		//test1();
		//test2();
		//test3();
		//test4();
		test5();
	}
	public  static void test1() {
		//synchronized �Ƕ����������Ķ�����ͬһ���������������̲߳�����ֽ���ִ�е����������һ��ִ����֮�󣬲�ִ������һ��
		Thread1 t1 = new Thread1();
		Thread td1 = new Thread(t1, "thread1");
		Thread td2 = new Thread(t1, "thread2");
		td1.start();
		td2.start();
	}
	public static void test2() {
		//synchronized �Ƕ����������Ķ�����ͬһ���������������̻߳���ֽ���ִ�е����
		Thread1 t1=new Thread1("t1");
		Thread1 t2=new Thread1("t1");
		
		t1.start();
		t2.start();
	}
	public static void test3() {
		//��һ���̷߳��ʡ�ĳ���󡱵ġ�synchronized���������ߡ�synchronized����顱ʱ�������߳���Ȼ���Է��ʡ��ö��󡱵ķ�ͬ�������
		Thread t1=new Thread(new Runnable() {
			public void run() {
				new Thread2().syncMeothod();
			}
		});
		
		Thread t2=new Thread(new Runnable() {
			public void run() {
				new Thread2().noSyncMethod();
			}
		});
		
		t1.start();
		t2.start();
	}
	public static void test4() {
		//��һ���̷߳��ʡ�ĳ���󡱵ġ�synchronized���������ߡ�synchronized����顱ʱ�������̶߳ԡ��ö��󡱵������ġ�synchronized���������ߡ�synchronized����顱�ķ��ʽ�������
		Thread2 th2=new Thread2();
		Thread t1=new Thread(new Runnable() {
			public void run() {
				th2.syncMeothod();
			}
		});
		
		Thread t2=new Thread(new Runnable() {
			public void run() {
				th2.anotherSyncMethod();
			}
		});
		
		t1.start();
		t2.start();
	}
	/**
	 * �������� 
	 * 
	 * ��α�������
	 * 1��һ������ֻ��һ������
	 * 2���ö������ʱ�򣬾����ܱ�֤����˳�򣬾����������Ľ���
	 * 3������ʹ��Lock���е�tryLock����ȥ���Ի�ȡ���������������ָ��һ����ʱʱ�ޣ��ڵȴ�������ʱ��֮���ط���һ��ʧ����Ϣ
	 * 
	 * void
	 */
	public static void test5() {
		DeadLock dl=new DeadLock();
		Thread t1=new Thread(new Runnable() {
			public void run() {
				dl.metohd1();
			}
		});
		Thread t2=new Thread(new Runnable() {
			public void run() {
				dl.metohd2();
			}
		});
		
		t1.start();
		t2.start();
	}
}
