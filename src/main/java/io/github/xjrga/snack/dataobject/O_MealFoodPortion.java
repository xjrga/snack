package io.github.xjrga.snack.dataobject;

import java.math.BigDecimal;

public class O_MealFoodPortion {

    private BigDecimal ActualWt;
    private BigDecimal ExpectedWt;
    private String FoodId;
    private Integer MealId;
    private String MixId;
    private BigDecimal Pct;


    public O_MealFoodPortion() {
    }


    public BigDecimal getActualwt() {
        return ActualWt;
    }


    public BigDecimal getExpectedwt() {
        return ExpectedWt;
    }


    public String getFoodid() {
        return FoodId;
    }


    public Integer getMealid() {
        return MealId;
    }


    public String getMixid() {
        return MixId;
    }


    public BigDecimal getPct() {
        return Pct;
    }


    public void setActualwt( BigDecimal ActualWt ) {
        this.ActualWt = ActualWt;
    }


    public void setExpectedwt( BigDecimal ExpectedWt ) {
        this.ExpectedWt = ExpectedWt;
    }


    public void setFoodid( String FoodId ) {
        this.FoodId = FoodId;
    }


    public void setMealid( Integer MealId ) {
        this.MealId = MealId;
    }


    public void setMixid( String MixId ) {
        this.MixId = MixId;
    }


    public void setPct( BigDecimal Pct ) {
        this.Pct = Pct;
    }


    @Override
    public String toString() {
        return "O_MealFoodAllocation{MixId=" + MixId + ", MealId=" + MealId + ", FoodId=" + FoodId + ", Pct=" + Pct
                + ", ExpectedWt=" + ExpectedWt + ", ActualWt=" + ActualWt + "}";
    }
}
