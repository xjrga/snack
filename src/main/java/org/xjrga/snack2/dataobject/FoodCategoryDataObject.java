package org.xjrga.snack2.dataobject;

public class FoodCategoryDataObject {
    private String FoodCategoryId;
    private String Name;

    public FoodCategoryDataObject() {
    }

    public String getFoodCategoryId() {
        return FoodCategoryId;
    }

    public void setFoodCategoryId(String FoodCategoryId) {
        this.FoodCategoryId = FoodCategoryId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Name);
        return sb.toString();
    }
}