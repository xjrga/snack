package io.github.xjrga.snack.other;

/**
 * @author jr
 */
public class Performance {

	private long t0;
	private long t1;

	public Performance() {

	}

	public void start() {

		t0 = System.currentTimeMillis();

	}

	public void stop() {

		t1 = System.currentTimeMillis();

	}

	public Double runtime() {

		long runTime = t1 - t0;
		return runTime / 1000D;

	}

}
