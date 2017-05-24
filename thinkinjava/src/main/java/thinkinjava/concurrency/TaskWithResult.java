package thinkinjava.concurrency;

import java.util.concurrent.Callable;

/**
 * @Title      :TaskWithResult
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月16日 上午11:23:04
 */
public class TaskWithResult implements Callable<String> {

	private int id;
	private int countDown = 10;
	
	public TaskWithResult(int id) {
		this.id = id;
	}
	
	private String status() {
		return "#" + id  + "(" + (--countDown > 0 ? countDown : "LiftOff") + "),";
	}
	
	
	@Override
	public String call() throws Exception {
		while (countDown > 0) {
			System.out.print(status());
		}
		return "result of TaskWithResult " + id;
	}

}
