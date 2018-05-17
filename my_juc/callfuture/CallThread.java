package my_juc.callfuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author gongxb
 *
 * 2018��1��21��
 */
public class CallThread implements Callable {

	@Override
	public String call() throws Exception {
		system.out.println(" call method");
		Thread.sleep(1000);
		return "1234";
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es=Executors.newCachedThreadPool();
		CallThread ct=new CallThread();
		Future future=es.submit(ct);
		es.shutdown();
		
		Thread.sleep(5000);
	    System.out.println("���̵߳ȴ�5��, ��ǰʱ��Ϊ" + System.currentTimeMillis());
	        
	    String str = (String) future.get();
	    System.out.println("Future���õ�����, str = " + str + ", ��ǰʱ��Ϊ" + System.currentTimeMillis());
	}
	
}
