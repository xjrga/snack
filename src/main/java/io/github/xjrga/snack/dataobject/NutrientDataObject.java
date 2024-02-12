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

public class NutrientDataObject {
  private String nutr_no;
  private String nutrdesc;
  private Double q;

  public NutrientDataObject(String nutrientid, String nutrdesc, Double q) {
    this.setNutr_no(nutrientid);
    this.setNutrdesc(nutrdesc);
    this.setQ(q);
  }

  public String getNutr_no() {
    return nutr_no;
  }

  public void setNutr_no(String nutr_no) {
    this.nutr_no = nutr_no;
  }

  public String getNutrdesc() {
    return nutrdesc;
  }

  public void setNutrdesc(String nutrdesc) {
    this.nutrdesc = nutrdesc;
  }

  public Double getQ() {
    return q;
  }

  public void setQ(Double q) {
    this.q = q;
  }

  @Override
  public String toString() {
    // return "{"+nutr_no+":"+nutrdesc+"}";
    return nutrdesc;
  }
}
