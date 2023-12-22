package io.github.xjrga.snack.other;

public enum Log {
  Log1,
  Log2;
  private final StringBuilder error_log_builder;

  private Log() {
    error_log_builder = new StringBuilder();
  }

  public void append(String text) {
    error_log_builder.append(text);
  }

  public String get_text() {
    return error_log_builder.toString();
  }

  public void clear() {
    error_log_builder.setLength(0);
  }
}
