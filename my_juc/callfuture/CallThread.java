package my_juc.callfuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author gongxb
 *
 * 2018年1月21日
 */
public class CallThread implements Callable {

	@Override
	public String call() throws Exception {
		System.out.println(" call method");
		Thread.sleep(1000);
		return "123";
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es=Executors.newCachedThreadPool();
		CallThread ct=new CallThread();
		Future future=es.submit(ct);
		es.shutdown();
		
		Thread.sleep(5000);
	    System.out.println("主线程等待5秒, 当前时间为" + System.currentTimeMillis());
	        
	    String str = (String) future.get();
	    System.out.println("Future已拿到数据, str = " + str + ", 当前时间为" + System.currentTimeMillis());
	}
	
}
