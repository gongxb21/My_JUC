package my_juc.productercustomer;

/**
 * @author gongxb
 *
 * 2018Äê1ÔÂ20ÈÕ
 */
public class ProductCustomerTest {
	public static void main(String[] args) {
		productCustoemrTest();
	}
	
	public static void productCustoemrTest() {
		 Object lock=new Object();
		Producer producer =new Producer(lock);
		Customer customer =new Customer(lock);
		
		Thread t1=new Thread(new Runnable() {
			public void run() {
				try {
					while(true)
					producer.product();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 =new Thread(new Runnable() {
			public void run() {
				try {
					while(true)
					customer.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
	}
	
}

