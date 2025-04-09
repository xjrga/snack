package io.github.xjrga.snack.logger;

import io.github.xjrga.snack.other.Utilities;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jr
 */
public enum LoggerImpl implements Logger {
  INSTANCE;
  private boolean print;
  private boolean write;
  private String regex;

  LoggerImpl() {
    print = false;
    write = false;
    regex = ".*";
  }

  @Override
  public void logRecord(String message) {
    if (!print) {
      return;
    }
    logMessage(message, (new Throwable()).getStackTrace());
  }

  @Override
  public void logProblem(Throwable t) {
    if (!print) {
      return;
    }
    logMessage(t.getMessage(), (new Throwable()).getStackTrace());
  }

  public void logMessage(String message, StackTraceElement[] stack) {
    List<LogEntry> records = new ArrayList();
    StringBuilder sb = new StringBuilder();
    sb.append("\n");
    sb.append("StackTrace at ");
    sb.append(LocalTime.now());
    sb.append(".\n\n");
    sb.append(message);
    sb.append("\n\n");
    for (int i = 1; i < stack.length; i++) {
      StackTraceElement ste = stack[i];
      String callerClassName = ste.getClassName();
      String callerMethodName = ste.getMethodName();
      int callerLineNum = ste.getLineNumber();
      LogEntry r = new LogEntry(i, callerClassName, callerMethodName, callerLineNum);
      records.add(r);
    }
    records.stream()
        .filter((LogEntry o) -> o.getCallerClassPackage().matches(regex))
        .toList()
        .forEach(
            a -> {
              sb.append(a);
              sb.append("\n");
            });
    if (print) {
      System.out.println(sb.toString());
    }
    if (write) {
      Utilities.appendToFile("stacktrace.log", sb.toString());
    }
  }

  public void print() {
    print = true;
  }

  public void write() {
    write = true;
  }

  public void filter(String regex) {
    this.regex = regex;
  }
}
