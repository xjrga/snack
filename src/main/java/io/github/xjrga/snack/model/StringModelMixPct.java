package io.github.xjrga.snack.model;

import io.github.xjrga.snack.data.DbLink;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class StringModelMixPct implements RoundUp {

    private final DbLink dbLink;
    private Integer precision = 0;

    public StringModelMixPct(DbLink dbLink) {
        this.dbLink = dbLink;
    }

    public String reload(String MixId) {
        String s = "";
        try {
            LinkedList all = (LinkedList) dbLink.MixResult_Select_Pct(MixId, precision);
            Iterator it = all.iterator();
            while (it.hasNext()) {
                HashMap row = (HashMap) it.next();
                Double calories = (Double) row.get("CALORIES");
                Double fat = (Double) row.get("FAT");
                Double carbs = (Double) row.get("CARBS");
                Double protein = (Double) row.get("PROTEIN");
                Double alcohol = (Double) row.get("ALCOHOL");
                Double fq = (Double) row.get("FQ");
                Double satfat = (Double) row.get("SATFAT");
                Double monoufat = (Double) row.get("MONOUFAT");
                Double polyufat = (Double) row.get("POLYUFAT");
                //Calories calculation result is different if we choose digestible carbohydrate or carbohydrate by difference. I chose to use digestible carbohydrate.
                //It is an approximation.
                StringBuilder sb = new StringBuilder();
                //This calories result is slightly different that the one reported because it uses digestible carbohydrate in calculation.
                //sb.append("Calories: ");
                //sb.append(mixResultDwPctDataObject.getCalories());
                sb.append("Per cent of total energy: ");
                sb.append("   ");
                sb.append("Fat: ");
                sb.append(fat);
                sb.append("   ");
                sb.append("Carbohydrate: ");
                sb.append(carbs);
                sb.append("   ");
                sb.append("Protein: ");
                sb.append(protein);
                sb.append("   ");
                sb.append("Alcohol: ");
                sb.append(alcohol);
                sb.append("   ");
                sb.append("Food Quotient: ");
                sb.append(fq);
                sb.append("   ");
                sb.append("SFA: ");
                sb.append(satfat);
                sb.append("   ");
                sb.append("MUFA: ");
                sb.append(monoufat);
                sb.append("   ");
                sb.append("PUFA: ");
                sb.append(polyufat);
                s = sb.toString();
            }
        } catch (SQLException e) {

        }
        return s;
    }

    @Override
    public void setPrecision(Integer precision) {
        this.precision = precision;
    }
}
