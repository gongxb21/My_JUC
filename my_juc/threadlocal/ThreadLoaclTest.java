package my_juc.threadlocal;

/**
 * @author gongxb
 *
 * 2018Äê1ÔÂ20ÈÕ
 */
public class ThreadLoaclTest {
	public static void main(String[] args) {
		test1();
	}
	public static void test1() {
		ThreadLocalThread tlt1=new ThreadLocalThread("1");
		ThreadLocalThread tlt2=new ThreadLocalThread("1");
		ThreadLocalThread tlt3=new ThreadLocalThread("1");
		
		tlt1.start();
		tlt2.start();
		tlt3.start();
	}
}
