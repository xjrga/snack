/*
 * Snack: Nutritional Software Copyright (C) 2018 Jorge R Garcia de Alba License:
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
package io.github.xjrga.snack.dataobject;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Objects;

public class MixDO implements Comparator {

  private String mixid;
  private String model;
  private String name;
  private String nutrientid;
  private BigDecimal cost;

  public MixDO() {
    this.mixid = "";
    this.model = "";
    this.name = "";
    this.nutrientid = "";
    this.cost = new BigDecimal("0.0");
  }

  public MixDO(String mixid, String name) {
    this.mixid = mixid;
    this.name = name;
  }

  public MixDO(String mixid) {
    this.mixid = mixid;
    this.name = "";
  }

  public String getMixId() {
    return mixid;
  }

  public String getModel() {
    return model;
  }

  public String getName() {
    return name;
  }

  public String getNutrientid() {
    return nutrientid;
  }

  public void setMixId(String mixid) {
    this.mixid = mixid;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setNutrientid(String nutrientid) {
    this.nutrientid = nutrientid;
  }

  public BigDecimal getCost() {
    return cost;
  }

  public void setCost(BigDecimal cost) {
    this.cost = cost;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(name);
    return sb.toString();
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 67 * hash + Objects.hashCode(this.mixid);
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
    final MixDO other = (MixDO) obj;
    return this.mixid.equals(other.mixid);
  }

  @Override
  public int compare(Object o1, Object o2) {
    MixDO m1 = (MixDO) o1;
    MixDO m2 = (MixDO) o2;
    return m1.getMixId().compareTo(m2.getMixId());
  }
}
