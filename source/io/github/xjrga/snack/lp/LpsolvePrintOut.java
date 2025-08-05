package io.github.xjrga.snack.lp;

import io.github.xjrga.snack.other.Utilities;
import java.util.Date;

public class LpsolvePrintOut {

	private final StringBuilder sb;
	private final StringBuilder mixLegend;
	private final StringBuilder foodLegend;
	private final StringBuilder objFunction;
	private final StringBuilder driDevQuantity;
	private final StringBuilder driDevSumQuantity;
	private final StringBuilder nutrientQuantity;
	private final StringBuilder nutrientRatio;
	private final StringBuilder foodQuantity;
	private final StringBuilder foodRatio;
	private Boolean isFeasible;
	private String model;

	public LpsolvePrintOut() {

		sb = new StringBuilder();
		mixLegend = new StringBuilder();
		foodLegend = new StringBuilder();
		objFunction = new StringBuilder();
		driDevQuantity = new StringBuilder();
		driDevSumQuantity = new StringBuilder();
		nutrientQuantity = new StringBuilder();
		nutrientRatio = new StringBuilder();
		foodQuantity = new StringBuilder();
		foodRatio = new StringBuilder();
		isFeasible = Boolean.TRUE;
		model = "";
		objFunction.append( "\n" );
		objFunction.append( "/* ----- OBJECTIVE FUNCTION ----- */" );
		objFunction.append( "\n\n" );
		driDevQuantity.append( "\n" );
		driDevQuantity.append( "/* ----- DRI DEVIATION QUANTITY CONSTRAINTS ----- */" );
		driDevQuantity.append( "\n\n" );
		driDevSumQuantity.append( "\n" );
		driDevSumQuantity.append( "/* ----- DRI DEVIATION SUM QUANTITY CONSTRAINTS ----- */" );
		driDevSumQuantity.append( "\n\n" );
		nutrientQuantity.append( "\n" );
		nutrientQuantity.append( "/* ----- NUTRIENT QUANTITY CONSTRAINTS ----- */" );
		nutrientQuantity.append( "\n\n" );
		nutrientRatio.append( "\n" );
		nutrientRatio.append( "/* ----- NUTRIENT RATIO CONSTRAINTS ----- */" );
		nutrientRatio.append( "\n\n" );
		foodQuantity.append( "\n" );
		foodQuantity.append( "/* ----- FOOD QUANTITY CONSTRAINTS ----- */" );
		foodQuantity.append( "\n\n" );
		foodRatio.append( "\n" );
		foodRatio.append( "/* ----- FOOD RATIO CONSTRAINTS ----- */" );
		foodRatio.append( "\n\n" );

	}

	public void addMixLegend( String mix ) {

		String date = Utilities.formatDate( new Date() );
		mixLegend.append( "/*\n" );
		mixLegend.append( String.format( " %1$9s %2$s", "PROBLEM: ", mix ) );
		mixLegend.append( "\n" );
		mixLegend.append( String.format( " %1$9s %2$s", "DATE:    ", date ) );
		mixLegend.append( "\n*/" );
		mixLegend.append( "\n\n" );

		//
	}

	public void addFoodLegend( String legend ) {

		foodLegend.append( "/*\n" );
		foodLegend.append( "VARIABLES\n\n" );
		foodLegend.append( legend );
		foodLegend.append( "\n*/\n" );

	}

	public void addObjectiveFunction( double[] coefficients, String name ) {

		objFunction.append( "/* " );
		objFunction.append( name );
		objFunction.append( " */" );
		objFunction.append( "\n\n" );
		objFunction.append( "min:" );
		objFunction.append( "\n" );

		for ( int i = 0; i < coefficients.length; i++ ) {

			double c = coefficients[i];

			if ( c < 0 ) {

				objFunction.append( String.format( " - %1$ 11.5f X%2$02d", c, i + 1 ) );

			} else {

				objFunction.append( String.format( " + %1$ 11.5f X%2$02d", Math.abs( c ), i + 1 ) );

			}

		}

		objFunction.append( ";" );
		objFunction.append( "\n" );

	}

	public void addDriDevQuantityConstraint( double[] coefficients, int rel, double value, String name ) {

		driDevQuantity.append( "/* " );
		driDevQuantity.append( name );
		driDevQuantity.append( " */" );
		driDevQuantity.append( "\n\n" );
		setConstraintCoefficients( driDevQuantity, coefficients, rel, value );

	}

	public void addDriDevSumQuantityConstraint( double[] coefficients, int rel, double value, String name ) {

		driDevSumQuantity.append( "/* " );
		driDevSumQuantity.append( name );
		driDevSumQuantity.append( " */" );
		driDevSumQuantity.append( "\n\n" );
		setConstraintCoefficients( driDevSumQuantity, coefficients, rel, value );

	}

	public void addNutrientQuantityConstraint( double[] coefficients, int rel, double value, String name ) {

		nutrientQuantity.append( "/* " );
		nutrientQuantity.append( name );
		nutrientQuantity.append( " */" );
		nutrientQuantity.append( "\n\n" );
		setConstraintCoefficients( nutrientQuantity, coefficients, rel, value );

	}

	public void addNutrientRatioConstraint( double[] coefficients, int rel, double value, String name ) {

		nutrientRatio.append( "/* " );
		nutrientRatio.append( name );
		nutrientRatio.append( " */" );
		nutrientRatio.append( "\n\n" );
		setConstraintCoefficients( nutrientRatio, coefficients, rel, value );

	}

	public void addFoodQuantityConstraint( double[] coefficients, int rel, double value, String name ) {

		foodQuantity.append( "/* " );
		foodQuantity.append( name );
		foodQuantity.append( " */" );
		foodQuantity.append( "\n\n" );
		setConstraintCoefficients( foodQuantity, coefficients, rel, value );

	}

	public void addFoodRatioConstraint( double[] coefficients, int rel, double value, String name ) {

		foodRatio.append( "/* " );
		foodRatio.append( name );
		foodRatio.append( " */" );
		foodRatio.append( "\n\n" );
		setConstraintCoefficients( foodRatio, coefficients, rel, value );

	}

	public void feasible() {

		isFeasible = Boolean.TRUE;
		sb.setLength( 0 );
		sb.append( mixLegend );
		sb.append( foodLegend );
		sb.append( objFunction );
		sb.append( driDevQuantity );
		sb.append( driDevSumQuantity );
		sb.append( nutrientQuantity );
		sb.append( nutrientRatio );
		sb.append( foodQuantity );
		sb.append( foodRatio );
		sb.append( "\n" );
		sb.append( "/* Model is feasible. A solution exists which satisfies all the constraints. */" );
		sb.append( "\n" );
		// sb.append("/* This command solves the model: lp_solve -piv1 -s1 -S3 model.lp
		// */");
		// sb.append("\n");
		model = sb.toString();

	}

	public void unfeasible() {

		sb.setLength( 0 );
		isFeasible = Boolean.FALSE;
		sb.append( mixLegend );
		sb.append( foodLegend );
		sb.append( objFunction );
		sb.append( nutrientQuantity );
		sb.append( nutrientRatio );
		sb.append( foodQuantity );
		sb.append( foodRatio );
		sb.append( "\n" );
		sb.append( "/* Model is infeasible. No solution exists which satisfies all the constraints. */" );
		sb.append( "\n" );
		model = sb.toString();

	}

	@Override
	public String toString() {

		return model;

	}

	private void setConstraintCoefficients( StringBuilder sb, double[] coefficients, int rel, double value ) {

		String relationship = LpUtilities.getRelationship( rel );

		for ( int i = 0; i < coefficients.length; i++ ) {

			double c = coefficients[i];

			if ( c < 0 ) {

				sb.append( String.format( " - %1$ 11.5f X%2$02d", Math.abs( c ), i + 1 ) );

			} else {

				sb.append( String.format( " + %1$ 11.5f X%2$02d", c, i + 1 ) );

			}

		}

		sb.append( " " );
		sb.append( String.format( "%1$2s %2$ 11.5f", relationship, value ) );
		sb.append( ";" );
		sb.append( "\n\n" );

	}

}
