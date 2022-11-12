package io.github.xjrga.snack.dataobject;

public class FoodFactSelectForDataInputDataObject {

    private String Category;
    private String Nutrient;
    private Double q;
    private String NutrientId;

    public FoodFactSelectForDataInputDataObject() {
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory( String category ) {
        Category = category;
    }

    public String getNutrient() {
        return Nutrient;
    }

    public void setNutrient( String nutrient ) {
        Nutrient = nutrient;
    }

    public Double getQ() {
        return q;
    }

    public void setQ( Double q ) {
        this.q = q;
    }

    public String getNutrientId() {
        return NutrientId;
    }

    public void setNutrientId( String nutrientId ) {
        NutrientId = nutrientId;
    }

    @Override
    public String toString() {
        return "FoodFactSelectForDataInputDataObject{" + "Category=" + Category + ", Nutrient=" + Nutrient + ", q=" + q + ", NutrientId=" + NutrientId + '}';
    }
}
