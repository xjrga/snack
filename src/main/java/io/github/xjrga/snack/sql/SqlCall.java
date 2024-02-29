package io.github.xjrga.snack.sql;

import java.util.List;

public interface SqlCall<T> {
  List<T> execute();

  List<T> execute(Integer precision);
}
