package io.github.xjrga.snack.other;

public class DigestibleCarbohydrate {

	private Double digestibleCarbs;
	private final Double totalCarbohydrate;
	private final Double totalFiber;

	public DigestibleCarbohydrate( Double totalCarbohydrate, Double totalFiber ) {

		this.totalCarbohydrate = totalCarbohydrate;
		this.totalFiber = totalFiber;

	}

	public double getDigestibleCarbohydrate() {

		digestibleCarbs = totalCarbohydrate - totalFiber;
		return digestibleCarbs;

	}

}
