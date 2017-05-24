package thinkinjava.concurrency;
/**
 * @Title      :DaemonSpawn
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月16日 下午5:00:00
 */
public class DaemonSpawn implements Runnable {

	@Override
	public void run() {
		while(true){
			Thread.yield();
		}
	}

}
