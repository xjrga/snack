package io.github.xjrga.snack.other;

/**
 *
 * @author jr
 */
public class MoistureContentModifier {

	private final Double initialWeight;
	private final Double initialWaterWeight;
	private final Double finalPctWater;
	private final Double dryMatterWeight;
	private final Double finalWaterWeight;
	private final Double finalWeight;
	private final Double initialPctWater;

	public MoistureContentModifier( Double initialWeight, Double initialWaterWeight, Double finalMoistureContent ) {

		this.initialWeight = initialWeight;
		this.initialWaterWeight = initialWaterWeight;
		finalPctWater = finalMoistureContent / 100.0;
		dryMatterWeight = initialWeight - initialWaterWeight;
		finalWaterWeight = finalPctWater * dryMatterWeight / (1 - finalPctWater);
		finalWeight = dryMatterWeight + finalWaterWeight;
		initialPctWater = initialWaterWeight / initialWeight;

	}

	public Double getInitialWeight() {

		return initialWeight;

	}

	public Double getInitialWaterWeight() {

		return initialWaterWeight;

	}

	public Double getFinalPctWater() {

		return finalPctWater * 100.0;

	}

	public Double getDryMatterWeight() {

		return dryMatterWeight;

	}

	public Double getFinalWaterWeight() {

		return finalWaterWeight;

	}

	public Double getFinalWeight() {

		return finalWeight;

	}

	public Double getInitialMoistureContent() {

		return initialPctWater * 100.0;

	}

	public Double getFinalMoistureContent() {

		return finalPctWater * 100.0;

	}

}
