package io.github.xjrga.snack.datamodel;

import io.github.xjrga.snack.dataobject.InventoryDays;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class InventoryDays_pop {
  public Vector columns;

  public InventoryDays_pop() {
    columns = new Vector();
    columns.add("MixId");
    columns.add("Name");
    columns.add("Days");
  }

  public DefaultTableModel apply(List<InventoryDays> list) {
    DefaultTableModel model =
        new DefaultTableModel() {
          @Override
          public Class getColumnClass(int i) {
            Class returnValue = Object.class;
            switch (i) {
              case 0:
              case 1:
                returnValue = String.class;
                break;
              case 2:
                returnValue = Double.class;
                break;
            }
            return returnValue;
          }
        };
    Vector vector = new Vector();
    list.forEach(
        element -> {
          Vector row_vector = new Vector();
          BigDecimal days = new BigDecimal(element.getDays());
          row_vector.add(element.getMixid());
          row_vector.add(element.getName());
          row_vector.add(days.setScale(1, RoundingMode.HALF_UP));
          vector.add(row_vector);
        });
    model.setDataVector(vector, columns);
    return model;
  }
}
