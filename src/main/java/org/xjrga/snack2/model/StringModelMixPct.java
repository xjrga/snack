package org.xjrga.snack2.model;

import org.xjrga.snack2.data.DbLink;
import org.xjrga.snack2.dataobject.MixResultDwPctDataObject;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class StringModelMixPct {
    private final DbLink dbLink;

    public StringModelMixPct(DbLink dbLink) {
        this.dbLink = dbLink;
    }

    public String reload(Integer MixId) {
        String s = "";

        try {
            LinkedList all = (LinkedList) dbLink.MixResultDW_Select_Pct(MixId);

            Iterator it = all.iterator();

            while (it.hasNext()) {

                HashMap row = (HashMap) it.next();
                Double calories = (Double) row.get("CALORIES");
                Double fat = (Double) row.get("FAT");
                Double carbs = (Double) row.get("CARBS");
                Double protein = (Double) row.get("PROTEIN");
                Double alcohol = (Double) row.get("ALCOHOL");
                //Food quotient (FQ) calculated using the equation of Black et al
                //Double fq = (carbs*1.00+fat*.71+protein*.81)/100;
                Double fq = (Double) row.get("FQ");

                if (calories == null) {
                    calories = 0.0;
                }
                if (fat == null) {
                    fat = 0.0;
                }
                if (carbs == null) {
                    carbs = 0.0;
                }
                if (protein == null) {
                    protein = 0.0;
                }
                if (alcohol == null) {
                    alcohol = 0.0;
                }

                MixResultDwPctDataObject mixResultDwPctDataObject = new MixResultDwPctDataObject();
                mixResultDwPctDataObject.setCalories(calories);
                mixResultDwPctDataObject.setFat(fat);
                mixResultDwPctDataObject.setCarbs(carbs);
                mixResultDwPctDataObject.setProtein(protein);
                mixResultDwPctDataObject.setAlcohol(alcohol);

                StringBuilder sb = new StringBuilder();
//                sb.append("Calories: ");
//                sb.append(mixResultDwPctDataObject.getCalories());
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
            e.printStackTrace();
        }

        return s;
    }
}
