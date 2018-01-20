package my_juc.productercustomer;

/**
 * @author gongxb
 *
 * 2018��1��20��
 */
public class Producer {
	private Object lock;
	
	public Producer(Object lock) {
		this.lock=lock;
	}
	
	public void product() throws InterruptedException {
			synchronized (lock) {
				if(!Resp.value.equals("")) {
					lock.wait();
				}
				String value=System.currentTimeMillis()+"";
				Resp.value=value;
				Thread.sleep(1000);
				System.out.println("product method"+value);
				lock.notify();
			}
		
	}
}
