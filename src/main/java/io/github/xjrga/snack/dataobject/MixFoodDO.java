package io.github.xjrga.snack.dataobject;

import java.util.Objects;

/**
 * @author jr
 */
public class MixFoodDO {

    private String foodid;
    private String foodname;


    public MixFoodDO() {
        foodid = "";
        foodname = "";
    }


    public MixFoodDO( String foodid, String foodname ) {
        this.setFoodId( foodid );
        this.setFoodName( foodname );
    }


    public String getFoodId() {
        return foodid;
    }


    public String getFoodName() {
        return foodname;
    }


    public void setFoodId( String foodid ) {
        this.foodid = foodid;
    }


    public void setFoodName( String foodname ) {
        this.foodname = foodname;
    }


    @Override
    public String toString() {
        return getFoodName();
    }


    public boolean isNull() {
        return false;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode( this.foodid );
        return hash;
    }


    @Override
    public boolean equals( Object obj ) {
        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        final MixFoodDO other = ( MixFoodDO ) obj;
        return Objects.equals( this.foodid, other.foodid );
    }
}
