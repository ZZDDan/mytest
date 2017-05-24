package thinkinjava.concurrency;
/**
 * @Title      :TestInnerClassThread
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月18日 下午5:09:19
 */
public class TestInnerClassThread {

	public static void main(String[] args){
		new InnerThread1("InnerThread1");
		new InnerThread2("InnerThread2");
		new InnerRunnable1("InnerRunnable1");
		new InnerRunnable2("InnerRunnable2");
		new ThreadMethod("ThreadMethod");
	}
}
