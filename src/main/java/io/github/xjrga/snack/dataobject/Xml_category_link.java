package io.github.xjrga.snack.dataobject;

/**
 *
 * @author jr
 */
public class Xml_category_link {

    private final StringBuilder sb;
    private String foodid = "";
    private String categoryid = "";

    public Xml_category_link() {
        sb = new StringBuilder();
    }

    public void set_foodid( String name ) {
        this.foodid = name;
    }

    public void set_categoryid( String mixid ) {
        this.categoryid = mixid;
    }

    public String get_foodid() {
        return foodid;
    }

    public String get_categoryid() {
        return categoryid;
    }

    @Override
    public String toString() {
        sb.append( "[" );
        sb.append( foodid );
        sb.append( "," );
        sb.append( categoryid );
        sb.append( "]" );
        return sb.toString();
    }

}
