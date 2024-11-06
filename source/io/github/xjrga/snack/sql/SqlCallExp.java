package io.github.xjrga.snack.sql;

import java.util.List;

public interface SqlCallExp<T, K> {

  List<T> execute(K o);
}
