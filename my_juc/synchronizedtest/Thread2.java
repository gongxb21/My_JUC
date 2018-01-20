package my_juc.synchronizedtest;

/**
 * @author gongxb
 *
 * 2018��1��20��
 * ��һ���̷߳��ʡ�ĳ���󡱵ġ�synchronized���������ߡ�synchronized����顱ʱ�������߳���Ȼ���Է��ʡ��ö��󡱵ķ�ͬ�������
 */
public class Thread2 {
	private String name;
	public Thread2() {
	
	}
	public Thread2(String name) {
		this.name=name;
	}
	public  void syncMeothod()  {
		synchronized(this) {
			for(int i=0;i<3;i++) {
				try {
					Thread.sleep(2000);
					System.out.println("ͬ������"+i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void noSyncMethod() {
		for(int i=0;i<3;i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("��ͬ������"+i);
		}
	}
	public void anotherSyncMethod() {
		synchronized (this) {
			for(int i=0;i<3;i++) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("�ڶ���ͬ������"+i);
			}
		}
	}
	
}
