package io.github.xjrga.snack.gui;

public class RowBuild {
  enum rowAlignment {
    TOP,
    CENTER,
    BOTTOM,
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

  public RowBuild() {
    columns = new StringBuilder();
  }

  // Using component size
  public void add(rowAlignment alignment, componentSize size) {
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

  public void add(rowAlignment alignment, componentSize size, resizeBehavior behavior) {
    columns.append(alignment.name());
    columns.append(":");
    columns.append(size);
    columns.append(":");
    columns.append(behavior.name());
    columns.append(",");
  }

  // Using constant size
  public void add(rowAlignment alignment, Integer pixels) {
    columns.append(alignment.name());
    columns.append(":");
    columns.append(pixels);
    columns.append(",");
  }

  public void add(Integer pixels, resizeBehavior behavior) {
    columns.append(pixels);
    columns.append(":");
    columns.append(behavior.name());
    columns.append(",");
  }

  public void add(rowAlignment alignment, Integer pixels, resizeBehavior behavior) {
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
