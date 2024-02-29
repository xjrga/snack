package io.github.xjrga.snack.sql;

import java.util.List;

public interface SqlCallMixid<T> {

  List<T> execute(String mixid);

  List<T> execute(String mixid, Integer precision);
}
