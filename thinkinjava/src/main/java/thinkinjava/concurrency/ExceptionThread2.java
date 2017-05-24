package thinkinjava.concurrency;
/**
 * @Title      :Exceptionthread2
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月22日 下午2:57:12
 */
public class ExceptionThread2 implements Runnable{
	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		System.out.println("run() by " + thread);
		System.out.println("eh = " + thread.getUncaughtExceptionHandler());
		throw new RuntimeException();
	}
}
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("caught " + e);
	}
}