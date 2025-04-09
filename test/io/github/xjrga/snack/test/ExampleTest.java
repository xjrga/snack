package io.github.xjrga.snack.test;

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
    String md5Hex = DigestUtils.md5Hex(password).toUpperCase();
    Assert.assertEquals(md5Hex, hash);
  }

  @Test
  public void test01() {
    BigDecimal a = new BigDecimal("1.0010");
    BigDecimal b = new BigDecimal("2.0020");
    ArrayList<BigDecimal> l = new ArrayList();
    l.add(a);
    l.add(b);
    StringBuilder sb = new StringBuilder();
    l.forEach(d -> sb.append(d.stripTrailingZeros().toPlainString()));
    System.out.println(DigestUtils.md5Hex(sb.toString()));
    Assert.assertTrue(true);
    // 13f36a34936e1d627e617b82a290291f
    //

  }

  //  @Test
  //  public void test02() {
  //    List<List> results = Reloader.reloadMixResults("960549540");
  //    List<List> energy = Reloader.getEnergy(results);
  //    System.out.println(energy);
  //    Assert.assertTrue(true);
  //  }
}
