package io.github.xjrga.snack.logger;

import java.util.Objects;

/**
 * @author jr
 */
public class LogEntry {

  private final int stackElement;
  private final String callerClassName;
  private final String callerClassPackage;
  private final String callerSimpleClassName;
  private final String callerMethodName;
  private final int callerLineNum;

  public LogEntry(
      int stackElement, String callerClassName, String callerMethodName, int callerLineNum) {
    this.stackElement = stackElement;
    this.callerClassName = callerClassName;
    this.callerClassPackage = callerClassName.substring(0, callerClassName.lastIndexOf("."));
    this.callerSimpleClassName = callerClassName.replace(callerClassPackage + ".", "");
    this.callerMethodName = callerMethodName;
    this.callerLineNum = callerLineNum;
  }

  public int getStackElement() {
    return stackElement;
  }

  public String getCallerClassName() {
    return callerClassName;
  }

  public String getCallerClassPackage() {
    return callerClassPackage;
  }

  public String getCallerSimpleClassName() {
    return callerSimpleClassName;
  }

  public String getCallerMethodName() {
    return callerMethodName;
  }

  public int getCallerLineNum() {
    return callerLineNum;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 11 * hash + this.stackElement;
    hash = 11 * hash + Objects.hashCode(this.callerClassName);
    hash = 11 * hash + Objects.hashCode(this.callerMethodName);
    hash = 11 * hash + this.callerLineNum;
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final LogEntry other = (LogEntry) obj;
    if (this.stackElement != other.stackElement) {
      return false;
    }
    if (this.callerLineNum != other.callerLineNum) {
      return false;
    }
    if (!Objects.equals(this.callerClassName, other.callerClassName)) {
      return false;
    }
    return Objects.equals(this.callerMethodName, other.callerMethodName);
  }

  @Override
  public String toString() {
    String record =
        String.format(
            "%1$2s,%2$-50s,%3$-60s,%4$-30s,%5$5s",
            stackElement,
            callerClassPackage,
            callerSimpleClassName,
            callerMethodName,
            callerLineNum);
    return record;
  }
}
