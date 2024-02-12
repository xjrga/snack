package io.github.xjrga.snack.model;

import io.github.xjrga.snack.data.DbLink;
import io.github.xjrga.snack.model.iface.Reload_mixid;
import io.github.xjrga.snack.model.iface.Round_up;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;

public class Mix_stats implements Round_up, Reload_mixid {
  private final DbLink dbLink;
  private Integer precision = 1;
  private StringBuilder sb;

  public Mix_stats(DbLink dbLink) {
    this.dbLink = dbLink;
  }

  @Override
  public void reload(String MixId) {
    sb = new StringBuilder();
    try {
      LinkedList<HashMap> list = (LinkedList) dbLink.MixResult_Select_Pct(MixId, precision);
      list.forEach(row -> {
        Double calories = (Double) row.get("CALORIES");
        Double fatpct = (Double) row.get("FATPCT");
        Double carbpct = (Double) row.get("CARBPCT");
        Double proteinpct = (Double) row.get("PROTEINPCT");
        Double alcoholpct = (Double) row.get("ALCOHOLPCT");
        Double fq = (Double) row.get("FQ");
        Double satfatpct = (Double) row.get("SATFATPCT");
        Double monoufatpct = (Double) row.get("MONOUFATPCT");
        Double polyufatpct = (Double) row.get("POLYUFATPCT");
        Double essentialfatratio = (Double) row.get("ESSENTIALFATRATIO");
        Double electrolyteratio = (Double) row.get("ELECTROLYTERATIO");
        Double lapct = (Double) row.get("LAPCT");
        Double alapct = (Double) row.get("ALAPCT");
        Double psratio = (Double) row.get("PSRATIO");
        Double msratio = (Double) row.get("MSRATIO");
        sb.append("Fat: ");
        sb.append(fatpct);
        sb.append("%\n");
        sb.append("Carbohydrate: ");
        sb.append(carbpct);
        sb.append("%\n");
        sb.append("Protein: ");
        sb.append(proteinpct);
        sb.append("%\n");
        sb.append("Alcohol: ");
        sb.append(alcoholpct);
        sb.append("%\n");
        sb.append("Saturated Fat: ");
        sb.append(satfatpct);
        sb.append("%\n");
        sb.append("Polyunsaturated Fat: ");
        sb.append(polyufatpct);
        sb.append("%\n");
        sb.append("Monounsaturated Fat: ");
        sb.append(monoufatpct);
        sb.append("%\n");
        sb.append("Linoleic Acid: ");
        sb.append(lapct);
        sb.append("%\n");
        sb.append("Alpha-linolenic Acid: ");
        sb.append(alapct);
        sb.append("%\n");
        sb.append("Ratio PUFA/SFA: ");
        sb.append(psratio);
        sb.append("\n");
        sb.append("Ratio MUFA/SFA: ");
        sb.append(msratio);
        sb.append("\n");
        sb.append("Ratio LA/ALA: ");
        sb.append(essentialfatratio);
        sb.append("\n");
        sb.append("Ratio K/Na: ");
        sb.append(electrolyteratio);
        sb.append("\n");
        sb.append("Food Quotient (FQ): ");
        sb.append(fq);
        sb.append("\n");
      });
    } catch (SQLException e) {
    }
  }

  public String get_stats() {
    return sb.toString();
  }

  @Override
  public void set_precision(Integer precision) {
    this.precision = precision;
  }
}
