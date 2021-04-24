package io.github.xjrga.snack2.model;

import io.github.xjrga.snack2.data.DbLink;
import io.github.xjrga.snack2.dataobject.MixResultDwPctDataObject;
import io.github.xjrga.snack2.other.Log;

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

    public String reload(Integer MixId) {
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
                //Calories calculation result is different if we choose digestible carbohydrate or carbohydrate by difference. I chose to use digestible carbohydrate.
                //It is an approximation.
                MixResultDwPctDataObject mixResultDwPctDataObject = new MixResultDwPctDataObject();
                mixResultDwPctDataObject.setCalories(calories);
                mixResultDwPctDataObject.setFat(fat);
                mixResultDwPctDataObject.setCarbs(carbs);
                mixResultDwPctDataObject.setProtein(protein);
                mixResultDwPctDataObject.setAlcohol(alcohol);
                StringBuilder sb = new StringBuilder();
                //This calories result is slightly different that the one reported because it uses digestible carbohydrate in calculation.
                //sb.append("Calories: ");
                //sb.append(mixResultDwPctDataObject.getCalories());
                sb.append("Per cent of total energy: ");
                sb.append("   ");
                sb.append("Fat: ");
                sb.append(mixResultDwPctDataObject.getFat());
                sb.append("   ");
                sb.append("Carbohydrate: ");
                sb.append(mixResultDwPctDataObject.getCarbs());
                sb.append("   ");
                sb.append("Protein: ");
                sb.append(mixResultDwPctDataObject.getProtein());
                sb.append("   ");
                sb.append("Alcohol: ");
                sb.append(mixResultDwPctDataObject.getAlcohol());
                sb.append("     ");
                sb.append("Food Quotient: ");
                sb.append(fq);
                s = sb.toString();
            }
        } catch (SQLException e) {
            Log.getLog().start("files/exception.log");
            Log.getLog().logMessage(e.toString());
            Log.getLog().write();
            Log.getLog().close();
            e.printStackTrace();
        }
        return s;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }
}
