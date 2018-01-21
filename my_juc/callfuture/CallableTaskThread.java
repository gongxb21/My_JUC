package my_juc.callfuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author gongxb
 *
 * 2018��1��21��
 */
public class CallableTaskThread implements Callable {

	@Override
	public String call() throws Exception {
		System.out.println(" call method");
		return "123";
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es=Executors.newCachedThreadPool();
		CallableTaskThread ctt=new CallableTaskThread();
		FutureTask ft=new FutureTask(ctt);
		es.submit(ft);
		es.shutdown();
		
		Thread.sleep(5000);
	    System.out.println("���̵߳ȴ�5��, ��ǰʱ��Ϊ" + System.currentTimeMillis());
	        
	    String str = (String) ft.get();
	    System.out.println("Future���õ�����, str = " + str + ", ��ǰʱ��Ϊ" + System.currentTimeMillis());
	}
	
}
