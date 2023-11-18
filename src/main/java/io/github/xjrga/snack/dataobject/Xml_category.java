package io.github.xjrga.snack.dataobject;

/**
 *
 * @author jr
 */
public class Xml_category {
    private final StringBuilder sb;
    private String categoryid = "";
    private String categoryname = "";
    public Xml_category() {
        sb = new StringBuilder();
    }
    public void set_categoryid( String mixid ) {
        this.categoryid = mixid;
    }
    public void set_categoryname( String name ) {
        this.categoryname = name;
    }
    public String get_categoryid() {
        return categoryid;
    }
    public String get_categoryname() {
        return categoryname;
    }
    @Override
    public String toString() {
        sb.append( "[" );
        sb.append( categoryid );
        sb.append( "," );
        sb.append( categoryname );
        sb.append( "]" );
        return sb.toString();
    }
}
