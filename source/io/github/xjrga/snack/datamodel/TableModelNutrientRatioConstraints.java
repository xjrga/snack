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
package io.github.xjrga.snack.datamodel;

import io.github.xjrga.snack.database.DbLink;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class TableModelNutrientRatioConstraints extends DefaultTableModel implements Reload_mixid {
  private final DbLink dbLink;
  private Vector columns;
  private int rowCount;

  public TableModelNutrientRatioConstraints(DbLink dbLink) {
    this.dbLink = dbLink;
    this.setColumnIdentifiers();
    rowCount = 0;
  }

  private void setColumnIdentifiers() {
    columns = new Vector();
    columns.add("MixId");
    columns.add("NutrientIdA");
    columns.add("NutrientIdB");
    columns.add("RelationshipId");
    columns.add("NutrientA");
    columns.add("A");
    columns.add("Eq");
    columns.add("NutrientB");
    columns.add("B");
    this.setColumnIdentifiers(columns);
  }

  @Override
  public Class getColumnClass(int i) {
    Class returnValue = Object.class;
    switch (i) {
        // mixid
      case 0:
        returnValue = Integer.class;
        break;
        // nutrientid A
      case 1:
        returnValue = String.class;
        break;
        // nutrientid B
      case 2:
        returnValue = String.class;
        break;
        // relationshipid
      case 3:
        returnValue = Integer.class;
        break;
        // Nutrient Name A
      case 4:
        returnValue = String.class;
        break;
        // qA
      case 5:
        returnValue = Double.class;
        break;
        // Relationship
      case 6:
        returnValue = String.class;
        break;
        // Nutrient Name B
      case 7:
        returnValue = String.class;
        break;
        // qB
      case 8:
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
      LinkedList<HashMap> list = (LinkedList) dbLink.NutrientRatio_Select(mixid);
      list.forEach(
          rowm -> {
            String mixid2 = (String) rowm.get("MIXID");
            String nutrientidA = (String) rowm.get("NUTRIENT_ID_1");
            String nutrientidB = (String) rowm.get("NUTRIENT_ID_2");
            Integer relationshipid = (Integer) rowm.get("RELATIONSHIPID");
            String nutrientA = (String) rowm.get("NUTRIENTA");
            String nutrientB = (String) rowm.get("NUTRIENTB");
            Double qA = (Double) rowm.get("A");
            Double qB = (Double) rowm.get("B");
            String relationship = (String) rowm.get("RELATIONSHIP");
            Vector row = new Vector();
            row.add(mixid2);
            row.add(nutrientidA);
            row.add(nutrientidB);
            row.add(relationshipid);
            row.add(nutrientA);
            row.add(qA);
            row.add(relationship);
            row.add(nutrientB);
            row.add(qB);
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
    return (Double) getValueAt(rowCount++, 6);
  }
}
