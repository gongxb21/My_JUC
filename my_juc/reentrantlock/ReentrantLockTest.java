package my_juc.reentrantlock;

/**
 * @author gongxb
 *
 * 2018��1��20��
 */
public class ReentrantLockTest {
	public static void main(String[] args) throws InterruptedException {
		//lockTest();
		conditionTest();
	}
	
	/**
	 * ˵����һ���̴߳�ӡ���֮����һ���̲߳ſ��Ի����ȥ��ӡ���ݣ���Ҳ֤����ReentrantLock���м����Ĺ���
	 * 
	 * void
	 */
	public static void lockTest() {
		WorkThread t1=new WorkThread();
		WorkThread t2=new WorkThread();
		WorkThread t3=new WorkThread();
		
		t1.start();
		t2.start();
		t3.start();
	}
	/**
	 * �ɹ�����ReentrantLock��Conditionʵ���˵ȴ�/֪ͨģ�͡���ʵ������ӻ�֤����һ�㣬
	 * Condition��await()�������ͷ����ģ�ԭ��Ҳ�ܼ򵥣�Ҫ��await()�������ͷ�����
	 * ��ôsignal()��������ô�ܵ��õ�Condition��signal()�����أ�
	 *ע��Ҫ����һ��Condition�Ļ�����ô����̱߳���Condition��await()�󣬵���
	 *Condition��signalAll()�������ѵ������е��̡߳�����뵥�����Ѳ����̸߳���ô���أ�
	 *new�����Condition�Ϳ����ˣ�����Ҳ�����������������е�Ч�ʡ�
	 *ʹ�ö��Condition�ĳ����Ǻܳ����ģ���ArrayBlockingQueue����С�
	 * 
	 * void
	 * @throws InterruptedException 
	 */
	public static void conditionTest() throws InterruptedException {
		MyThreaddomain md=new MyThreaddomain();
		MyThreadAwait mta=new MyThreadAwait(md);
		MyThreadSingal mts=new MyThreadSingal(md);
		
		mta.start();
		Thread.sleep(2000);
		mts.start();
	}
}
