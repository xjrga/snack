package io.github.xjrga.snack.other;

public class ElapsedTime {

  private long end;
  private long start;

  public ElapsedTime() {}

  public void end() {
    end = System.currentTimeMillis();
  }

  public float getElapsedTimeInMinutes() {
    return (end - start) / (60 * 1000F);
  }

  public float getElapsedTimeInSeconds() {
    return (end - start) / 1000F;
  }

  public void start() {
    start = System.currentTimeMillis();
  }
}
