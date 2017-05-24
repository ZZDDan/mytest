package thinkinjava.concurrency;


public class EvenGenerator extends IntGenerator {
	private int currentEvenValue = 0;

	public int next() {
		++currentEvenValue; // Danger point here!
		Thread.yield();// 更快的出现，资源抢占的效果
		++currentEvenValue;
		return currentEvenValue;
	}

	public static void main(String[] args) {
		EvenChecker.test(new EvenGenerator());
	}
} 