/*
 * Snack: Learning Software for Nutrition Copyright (C) 2018 Jorge R Garcia de Alba License:
 * http://www.gnu.org/licenses/gpl.html GPL version 2 or higher
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program; if
 * not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */
package io.github.xjrga.snack.model;

import io.github.xjrga.snack.data.DbLink;
import io.github.xjrga.snack.model.iface.Reload_mixid;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class TableModelFoodNutrientRatioConstraints extends DefaultTableModel
    implements Reload_mixid {
  private final DbLink dbLink;
  private Vector columns;
  private int rowCount;

  public TableModelFoodNutrientRatioConstraints(DbLink dbLink) {
    this.dbLink = dbLink;
    this.setColumnIdentifiers();
    rowCount = 0;
  }

  private void setColumnIdentifiers() {
    columns = new Vector();
    columns.add("MixId");
    columns.add("FoodIdA");
    columns.add("NutrientIdA");
    columns.add("FoodIdB");
    columns.add("NutrientIdB");
    columns.add("RelationshipId");
    columns.add("FoodA");
    columns.add("NutrientA");
    columns.add("A");
    columns.add("Eq");
    columns.add("FoodB");
    columns.add("NutrientB");
    columns.add("B");
    this.setColumnIdentifiers(columns);
  }

  @Override
  public Class getColumnClass(int i) {
    Class returnValue = Object.class;
    switch (i) {
      case 0:
        // mixid
        returnValue = Integer.class;
        break;
      case 1:
        // foodid A
        returnValue = String.class;
        break;
      case 2:
        // nutrientid A
        returnValue = String.class;
        break;
      case 3:
        // foodid B
        returnValue = String.class;
        break;
      case 4:
        // nutrientid B
        returnValue = String.class;
        break;
      case 5:
        // relationshipid
        returnValue = Integer.class;
        break;
      case 6:
        // Food Name A
        returnValue = String.class;
        break;
      case 7:
        // Nutrient Name A
        returnValue = String.class;
        break;
      case 8:
        // A
        returnValue = Double.class;
        break;
      case 9:
        // Relationship
        returnValue = String.class;
        break;
      case 10:
        // Food Name B
        returnValue = String.class;
        break;
      case 11:
        // Nutrient Name B
        returnValue = String.class;
        break;
      case 12:
        // B
        returnValue = Double.class;
        break;
    }
    return returnValue;
  }

  @Override
  public boolean isCellEditable(int i, int i1) {
    return false;
  }

  @Override
  public void reload(String mixid) {
    Vector table = new Vector();
    try {
      LinkedList<HashMap> list = (LinkedList) dbLink.FoodNutrientRatio_Select(mixid);
      list.forEach(rowm -> {
        String mixid2 = (String) rowm.get("MIXID");
        String foodidA = (String) rowm.get("FOOD_ID_1");
        String nutrientidA = (String) rowm.get("NUTRIENT_ID_1");
        String foodidB = (String) rowm.get("FOOD_ID_2");
        String nutrientidB = (String) rowm.get("NUTRIENT_ID_2");
        Integer relationshipid = (Integer) rowm.get("RELATIONSHIPID");
        String foodA = (String) rowm.get("FOODA");
        String nutrientA = (String) rowm.get("NUTRIENTA");
        String foodB = (String) rowm.get("FOODB");
        String nutrientB = (String) rowm.get("NUTRIENTB");
        Double a = (Double) rowm.get("A");
        Double b = (Double) rowm.get("B");
        String relationship = (String) rowm.get("RELATIONSHIP");
        Vector row = new Vector();
        row.add(mixid2);
        row.add(foodidA);
        row.add(nutrientidA);
        row.add(foodidB);
        row.add(nutrientidB);
        row.add(relationshipid);
        row.add(foodA);
        row.add(nutrientA);
        row.add(a);
        row.add(relationship);
        row.add(foodB);
        row.add(nutrientB);
        row.add(b);
        table.add(row);
      });
      this.setDataVector(table, columns);
    } catch (SQLException e) {
    }
  }

  public Double getNextA() {
    if (rowCount >= getRowCount()) {
      return Double.NEGATIVE_INFINITY;
    }
    return (Double) getValueAt(rowCount++, 10);
  }
}
