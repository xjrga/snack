package io.github.xjrga.snack.datamodel;

import io.github.xjrga.snack.dataobject.InventorySum;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class InventorySum_pop {
  public Vector columns;

  public InventorySum_pop() {
    columns = new Vector();
    columns.add("FoodId");
    columns.add("Name");
    columns.add("g");
    columns.add("oz");
    columns.add("lb");
    columns.add("kg");
  }

  public DefaultTableModel apply(List<InventorySum> list) {
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
              case 3:
              case 4:
              case 5:
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
          String foodid = element.getFoodid();
          String name = element.getName();
          BigDecimal g = new BigDecimal(element.getG());
          BigDecimal oz = new BigDecimal(element.getOz());
          BigDecimal lb = new BigDecimal(element.getLb());
          BigDecimal kg = new BigDecimal(element.getKg());
          row_vector.add(foodid);
          row_vector.add(name);
          row_vector.add(g.setScale(2, RoundingMode.HALF_UP));
          row_vector.add(oz.setScale(2, RoundingMode.HALF_UP));
          row_vector.add(lb.setScale(2, RoundingMode.HALF_UP));
          row_vector.add(kg.setScale(2, RoundingMode.HALF_UP));
          vector.add(row_vector);
        });
    model.setDataVector(vector, columns);
    return model;
  }
}
