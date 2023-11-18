package io.github.xjrga.snack.dataobject;

public class Xml_nutrient_ratio_constraint {
    private final StringBuilder sb;
    private String nutrientid_a = "";
    private String nutrientid_b = "";
    private Integer relationshipid = 0;
    private Double a = 0.0;
    private Double b = 0.0;
    public Xml_nutrient_ratio_constraint() {
        sb = new StringBuilder();
    }
    public String getNutrientid_a() {
        return nutrientid_a;
    }
    public void setNutrientid_a( String nutrientid_a ) {
        this.nutrientid_a = nutrientid_a;
    }
    public String getNutrientid_b() {
        return nutrientid_b;
    }
    public void setNutrientid_b( String nutrientid_b ) {
        this.nutrientid_b = nutrientid_b;
    }
    public Integer getRelationshipid() {
        return relationshipid;
    }
    public void setRelationshipid( Integer relationshipid ) {
        this.relationshipid = relationshipid;
    }
    public Double getA() {
        return a;
    }
    public void setA( Double a ) {
        this.a = a;
    }
    public Double getB() {
        return b;
    }
    public void setB( Double b ) {
        this.b = b;
    }
    @Override
    public String toString() {
        sb.append( "[" );
        sb.append( nutrientid_a );
        sb.append( "," );
        sb.append( nutrientid_b );
        sb.append( "," );
        sb.append( relationshipid );
        sb.append( "," );
        sb.append( b );
        sb.append( "]" );
        return sb.toString();
    }
}
