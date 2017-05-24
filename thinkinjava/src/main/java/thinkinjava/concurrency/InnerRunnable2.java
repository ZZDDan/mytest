package thinkinjava.concurrency;

/**
 * @Title      :InnerThread2
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月17日 上午9:37:36
 */
public class InnerRunnable2 {

	private int countDown = 5;
	private Thread t;
	
	public InnerRunnable2(String name){
		
		t = new Thread(new Runnable(){
			
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
				return Thread.currentThread().getName() + ":" + countDown;
			}
		}, name);
		t.start();
	}
}
