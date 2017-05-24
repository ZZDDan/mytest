package thinkinjava.concurrency;

/**
 * @Title      :InnerRunnable1
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月17日 上午9:40:41
 */
public class InnerRunnable1 {

	private int countDown = 5;
	@SuppressWarnings("unused")
    private Inner inner;
	
	private class Inner implements Runnable {
		
		Thread t;
		
		public Inner(String name) {
			t = new Thread(name);
			t.start();
		}
		
		@Override
		public void run() {
			while(true){
				System.out.println(this);
				if(--countDown == 0){
					return ;
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println("sleep() interrupt");
				}
			}
		}
		
		@Override
		public String toString() {
			return t.getName() + ":" + countDown;
		}
	}
	
	public InnerRunnable1(String name){
		inner = new Inner(name);
	}
}
