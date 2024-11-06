package io.github.xjrga.snack.gui;

public class ColumnBuild {
  enum columnAlignment {
    LEFT,
    CENTER,
    RIGHT,
    FILL;
  }

  enum resizeBehavior {
    NONE,
    GROW;
  }

  enum componentSize {
    MIN,
    PREF,
    DEFAULT;
  }

  private final StringBuilder columns;

  public ColumnBuild() {
    columns = new StringBuilder();
  }

  public void add(String columnSpec) {
    columns.append(columnSpec);
    columns.append(",");
  }

  // Using component size
  public void add(columnAlignment alignment, componentSize size) {
    columns.append(alignment.name());
    columns.append(":");
    columns.append(size);
    columns.append(",");
  }

  public void add(componentSize size, resizeBehavior behavior) {
    columns.append(size);
    columns.append(":");
    columns.append(behavior.name());
    columns.append(",");
  }

  public void add(columnAlignment alignment, componentSize size, resizeBehavior behavior) {
    columns.append(alignment.name());
    columns.append(":");
    columns.append(size);
    columns.append(":");
    columns.append(behavior.name());
    columns.append(",");
  }

  // Using constant size
  public void add(Integer pixels) {
    columns.append(pixels);
    columns.append("px");
    columns.append(",");
  }

  public void add(columnAlignment alignment, Integer pixels) {
    columns.append(alignment.name());
    columns.append(":");
    columns.append(pixels);
    columns.append("px");
    columns.append(",");
  }

  public void add(Integer pixels, resizeBehavior behavior) {
    columns.append(pixels);
    columns.append("px");
    columns.append(":");
    columns.append(behavior.name());
    columns.append(",");
  }

  public void add(columnAlignment alignment, Integer pixels, resizeBehavior behavior) {
    columns.append(alignment.name());
    columns.append(":");
    columns.append(pixels);
    columns.append("px");
    columns.append(":");
    columns.append(behavior.name());
    columns.append(",");
  }

  public void add(componentSize size) {
    columns.append(size);
    columns.append(",");
  }

  public String get() {
    return columns.toString().substring(0, columns.toString().length() - 1);
  }
}
