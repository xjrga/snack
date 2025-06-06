package io.github.xjrga.snack.dataobject;

/**
 * @author jr
 */
public class Xml_mix {

  private String mixid = "";
  private String name = "";
  private String nutrientid = "";
  private final StringBuilder sb;

  public Xml_mix() {
    sb = new StringBuilder();
  }

  public String get_mixid() {
    return mixid;
  }

  public String get_name() {
    return name;
  }

  public String get_nutrientid() {
    return nutrientid;
  }

  public void set_mixid(String mixid) {
    this.mixid = mixid;
  }

  public void set_name(String name) {
    this.name = name;
  }

  public void set_nutrientid(String nutrientid) {
    this.nutrientid = nutrientid;
  }

  @Override
  public String toString() {
    sb.append("[");
    sb.append(mixid);
    sb.append(",");
    sb.append(name);
    sb.append(",");
    sb.append(nutrientid);
    sb.append("]");
    return sb.toString();
  }
}
