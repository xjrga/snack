package org.xjrga.snack2.dataobject;

public class MixResultDwPctDataObject {

    private Integer MixId;
    private Double Protein;
    private Double Fat;
    private Double Carbs;
    private Double Calories;
    private Double Alcohol;

    public MixResultDwPctDataObject() {

    }

    public Integer getMixId() {
        return MixId;
    }

    public void setMixId(Integer mixId) {
        MixId = mixId;
    }

    public Double getProtein() {
        return Protein;
    }

    public void setProtein(Double protein) {
        Protein = protein;
    }

    public Double getFat() {
        return Fat;
    }

    public void setFat(Double fat) {
        Fat = fat;
    }

    public Double getCarbs() {
        return Carbs;
    }

    public void setCarbs(Double carbs) {
        Carbs = carbs;
    }

    public Double getCalories() {
        return Calories;
    }

    public void setCalories(Double calories) {
        Calories = calories;
    }

    public Double getAlcohol() {
        return Alcohol;
    }

    public void setAlcohol(Double alcohol) {
        Alcohol = alcohol;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(MixId);
        sb.append(":");
        sb.append(Calories);
        sb.append(":");
        sb.append(Fat);
        sb.append(":");
        sb.append(Carbs);
        sb.append(":");
        sb.append(Protein);
        sb.append(":");
        sb.append(Alcohol);
        return sb.toString();
    }

}
