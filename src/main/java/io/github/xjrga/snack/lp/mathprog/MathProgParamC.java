package io.github.xjrga.snack.lp.mathprog;

import io.github.xjrga.snack.data.FoodFactData;
import io.github.xjrga.snack.dataobject.CoefficientMod;
import java.util.List;

public class MathProgParamC {
  private final String paramA;

  public MathProgParamC(String mixid) {
    List<CoefficientMod> coefficients = (new FoodFactData()).apply(mixid);
    StringBuilder strb = new StringBuilder();
    coefficients.forEach(o -> {
      if (o.getRow() == 0) {
        strb.append(printFirstRow(o));
        strb.append("\n");
      } else {
        strb.append(printRow(o));
        strb.append("\n");
      }
    });
    strb.setLength(strb.length() - 1);
    strb.append(";");
    paramA = strb.toString();
  }

  public String get() {
    return paramA;
  }

  private String printFirstRow(CoefficientMod o) {
    StringBuilder pattern = new StringBuilder();
    pattern.append("%1$8s ");
    pattern.append("%2$ 27.0f ");
    pattern.append("%3$ 27.0f ");
    pattern.append("%4$ 27.0f ");
    pattern.append("%5$ 27.0f ");
    pattern.append("%6$ 27.0f ");
    pattern.append("%7$ 27.0f ");
    pattern.append("%8$ 27.0f ");
    pattern.append("%9$ 27.0f ");
    pattern.append("%10$ 27.0f ");
    pattern.append("%11$ 27.0f ");
    pattern.append("%12$ 27.0f ");
    pattern.append("%13$ 27.0f ");
    pattern.append("%14$ 27.0f ");
    pattern.append("%15$ 27.0f ");
    pattern.append("%16$ 27.0f ");
    pattern.append("%17$ 27.0f ");
    pattern.append("%18$ 27.0f ");
    pattern.append("%19$ 27.0f ");
    pattern.append("%20$ 27.0f ");
    pattern.append("%21$ 27.0f ");
    pattern.append("%22$ 27.0f ");
    pattern.append("%23$ 27.0f ");
    pattern.append("%24$ 27.0f ");
    pattern.append("%25$ 27.0f ");
    pattern.append("%26$ 27.0f ");
    pattern.append("%27$ 27.0f ");
    pattern.append("%28$ 27.0f ");
    pattern.append("%29$ 27.0f ");
    pattern.append("%30$ 27.0f ");
    pattern.append("%31$ 27.0f ");
    pattern.append("%32$ 27.0f ");
    pattern.append("%33$ 27.0f ");
    pattern.append("%34$ 27.0f ");
    pattern.append("%35$ 27.0f ");
    pattern.append("%36$ 27.0f ");
    pattern.append("%37$ 27.0f ");
    pattern.append("%38$ 27.0f ");
    pattern.append("%39$ 27.0f ");
    pattern.append("%40$ 27.0f ");
    pattern.append("%41$ 27.0f ");
    pattern.append("%42$ 27.0f ");
    pattern.append("%43$ 27.0f ");
    pattern.append("%44$ 27.0f ");
    pattern.append("%45$ 27.0f ");
    pattern.append("%46$ 27.0f ");
    pattern.append("%47$ 27.0f ");
    pattern.append("%48$ 27.0f ");
    pattern.append("%49$ 27.0f ");
    pattern.append("%50$ 27.0f ");
    pattern.append("%51$ 27.0f ");
    pattern.append("%52$ 27.0f ");
    pattern.append("%53$ 27.0f ");
    pattern.append("%54$ 27.0f ");
    pattern.append("%55$ 27.0f:=");
    return String.format(pattern.toString(), "param c:", o.getN10000(), o.getN10001(),
        o.getN10003(), o.getN10005(), o.getN10006(), o.getN10009(), o.getN10010(), o.getN10011(),
        o.getN10012(), o.getN10013(), o.getN10014(), o.getN10015(), o.getN203(), o.getN204(),
        o.getN205(), o.getN208(), o.getN221(), o.getN255(), o.getN291(), o.getN301(), o.getN303(),
        o.getN304(), o.getN305(), o.getN306(), o.getN307(), o.getN309(), o.getN312(), o.getN315(),
        o.getN317(), o.getN320(), o.getN323(), o.getN328(), o.getN401(), o.getN404(), o.getN405(),
        o.getN406(), o.getN410(), o.getN415(), o.getN418(), o.getN421(), o.getN430(), o.getN435(),
        o.getN601(), o.getN606(), o.getN611(), o.getN612(), o.getN613(), o.getN614(), o.getN618(),
        o.getN619(), o.getN621(), o.getN629(), o.getN645(), o.getN646());
  }

  private String printRow(CoefficientMod o) {
    StringBuilder pattern = new StringBuilder();
    pattern.append("      ");
    pattern.append("%1$2d ");
    pattern.append("%2$ 27.17f ");
    pattern.append("%3$ 27.17f ");
    pattern.append("%4$ 27.17f ");
    pattern.append("%5$ 27.17f ");
    pattern.append("%6$ 27.17f ");
    pattern.append("%7$ 27.17f ");
    pattern.append("%8$ 27.17f ");
    pattern.append("%9$ 27.17f ");
    pattern.append("%10$ 27.17f ");
    pattern.append("%11$ 27.17f ");
    pattern.append("%12$ 27.17f ");
    pattern.append("%13$ 27.17f ");
    pattern.append("%14$ 27.17f ");
    pattern.append("%15$ 27.17f ");
    pattern.append("%16$ 27.17f ");
    pattern.append("%17$ 27.17f ");
    pattern.append("%18$ 27.17f ");
    pattern.append("%19$ 27.17f ");
    pattern.append("%20$ 27.17f ");
    pattern.append("%21$ 27.17f ");
    pattern.append("%22$ 27.17f ");
    pattern.append("%23$ 27.17f ");
    pattern.append("%24$ 27.17f ");
    pattern.append("%25$ 27.17f ");
    pattern.append("%26$ 27.17f ");
    pattern.append("%27$ 27.17f ");
    pattern.append("%28$ 27.17f ");
    pattern.append("%29$ 27.17f ");
    pattern.append("%30$ 27.17f ");
    pattern.append("%31$ 27.17f ");
    pattern.append("%32$ 27.17f ");
    pattern.append("%33$ 27.17f ");
    pattern.append("%34$ 27.17f ");
    pattern.append("%35$ 27.17f ");
    pattern.append("%36$ 27.17f ");
    pattern.append("%37$ 27.17f ");
    pattern.append("%38$ 27.17f ");
    pattern.append("%39$ 27.17f ");
    pattern.append("%40$ 27.17f ");
    pattern.append("%41$ 27.17f ");
    pattern.append("%42$ 27.17f ");
    pattern.append("%43$ 27.17f ");
    pattern.append("%44$ 27.17f ");
    pattern.append("%45$ 27.17f ");
    pattern.append("%46$ 27.17f ");
    pattern.append("%47$ 27.17f ");
    pattern.append("%48$ 27.17f ");
    pattern.append("%49$ 27.17f ");
    pattern.append("%50$ 27.17f ");
    pattern.append("%51$ 27.17f ");
    pattern.append("%52$ 27.17f ");
    pattern.append("%53$ 27.17f ");
    pattern.append("%54$ 27.17f ");
    pattern.append("%55$ 27.17f");
    return String.format(pattern.toString(), o.getRow(), o.getN10000(), o.getN10001(),
        o.getN10003(), o.getN10005(), o.getN10006(), o.getN10009(), o.getN10010(), o.getN10011(),
        o.getN10012(), o.getN10013(), o.getN10014(), o.getN10015(), o.getN203(), o.getN204(),
        o.getN205(), o.getN208(), o.getN221(), o.getN255(), o.getN291(), o.getN301(), o.getN303(),
        o.getN304(), o.getN305(), o.getN306(), o.getN307(), o.getN309(), o.getN312(), o.getN315(),
        o.getN317(), o.getN320(), o.getN323(), o.getN328(), o.getN401(), o.getN404(), o.getN405(),
        o.getN406(), o.getN410(), o.getN415(), o.getN418(), o.getN421(), o.getN430(), o.getN435(),
        o.getN601(), o.getN606(), o.getN611(), o.getN612(), o.getN613(), o.getN614(), o.getN618(),
        o.getN619(), o.getN621(), o.getN629(), o.getN645(), o.getN646());
  }
}
