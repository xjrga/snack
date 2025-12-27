package io.github.xjrga.snack.dataobject;

import java.math.BigDecimal;

public class Xml_group_constraint {

    private BigDecimal b = new BigDecimal( "0.0" );
    private String groupid = "";
    private String nutrientid = "";
    private Integer relationshipid = 0;
    private final StringBuilder sb;

    public Xml_group_constraint() {
        sb = new StringBuilder();
    }

    public BigDecimal getB() {
        return b;
    }

    public String getGroupid() {
        return groupid;
    }

    public String getNutrientid() {
        return nutrientid;
    }

    public Integer getRelationshipid() {
        return relationshipid;
    }

    public void setB( BigDecimal b ) {
        this.b = b;
    }

    public void setGroupid( String foodid ) {
        this.groupid = foodid;
    }

    public void setNutrientid( String nutrientid ) {
        this.nutrientid = nutrientid;
    }

    public void setRelationshipid( Integer relationshipid ) {
        this.relationshipid = relationshipid;
    }

    @Override
    public String toString() {
        sb.append( "[" );
        sb.append( groupid );
        sb.append( "," );
        sb.append( nutrientid );
        sb.append( "," );
        sb.append( relationshipid );
        sb.append( "," );
        sb.append( b );
        sb.append( "]" );
        return sb.toString();
    }
}
