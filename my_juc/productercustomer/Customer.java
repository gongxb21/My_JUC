package my_juc.productercustomer;

/**
 * @author gongxb
 *
 * 2018Äê1ÔÂ20ÈÕ
 */
public class Customer {
	private Object lock;
	public Customer(Object lock) {
		this.lock=lock;
	}
	
	public void consume() throws InterruptedException {
		
		synchronized (lock) {
			if(Resp.value.equals("")) {
				lock.wait();
			}
			System.out.println("consume method "+Resp.value);
			Resp.value="";
			Thread.sleep(1000);
			lock.notify();
		}
	}
}
