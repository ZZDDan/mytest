package thinkinjava.concurrency;

import java.io.IOException;

/**
 * @Title      :UnresponsiveUI
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月22日 上午11:26:11
 */
class UnresponsiveUI {
	private volatile double d = 1;
	public UnresponsiveUI() throws IOException {
		while(d>1){
			d = d + (Math.PI + Math.E)/d;
			System.in.read();
		}
	}

}
public class ResponsiveUI extends Thread{
	private volatile static double d;

	public ResponsiveUI() {
		setDaemon(true);
		start();
	}
	
	@Override
	public void run() {
		while(true){
			d = d + (Math.PI + Math.E)/d;
		}
	}
	
	public static void main(String[] args) throws IOException {
		new UnresponsiveUI();
		//new ResponsiveUI();
		System.in.read();
		System.out.println(d);
	}
}
