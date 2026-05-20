package io.github.xjrga.snack.test;

import io.github.xjrga.snack.other.MoistureContentModifier;
import java.math.BigDecimal;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author jr
 */
public class ExampleTest extends TestCase {

	@Test
	public void test() {

		String hash = "35454B055CC325EA1AF2126E27707052";
		String password = "ILoveJava";
		String md5Hex = DigestUtils.md5Hex( password ).toUpperCase();
		Assert.assertEquals( md5Hex, hash );

	}

	@Test
	public void test01() {

		BigDecimal a = new BigDecimal( "1.0010" );
		BigDecimal b = new BigDecimal( "2.0020" );
		ArrayList<BigDecimal> l = new ArrayList();
		l.add( a );
		l.add( b );
		StringBuilder sb = new StringBuilder();
		l.forEach( d -> sb.append( d.stripTrailingZeros().toPlainString() ) );
		System.out.println( DigestUtils.md5Hex( sb.toString() ) );
		Assert.assertTrue( true );
		// 13f36a34936e1d627e617b82a290291f
		//

	}

	@Test
	public void test02() {

		MoistureContentModifier mcm = new MoistureContentModifier( 100.0, 10.0, 30.0 );
		StringBuilder sb = new StringBuilder();
		sb.append( "Initial Weight: " );
		sb.append( mcm.getInitialWeight() );
		sb.append( "\n" );
		sb.append( "Initial Water Weight: " );
		sb.append( mcm.getInitialWaterWeight() );
		sb.append( "\n" );
		sb.append( "Dry Matter Weight: " );
		sb.append( mcm.getDryMatterWeight() );
		sb.append( "\n" );
		sb.append( "Initial %MC: " );
		sb.append( mcm.getInitialMoistureContent() );
		sb.append( "\n" );
		sb.append( "Final Weight: " );
		sb.append( mcm.getFinalWeight() );
		sb.append( "\n" );
		sb.append( "Final Water Weight: " );
		sb.append( mcm.getFinalWaterWeight() );
		sb.append( "\n" );
		sb.append( "Final %MC: " );
		sb.append( mcm.getFinalMoistureContent() );
		System.out.println( sb.toString() );
		Assert.assertTrue( true );

	}
}
