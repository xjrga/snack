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

public class RelationshipDO {

  private String name;
  private int relationshipid;

  public RelationshipDO(int relationshipid, String name) {
    this.setRelationshipid(relationshipid);
    this.setName(name);
  }

  public String getName() {
    return name;
  }

  public int getRelationshipid() {
    return relationshipid;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setRelationshipid(int relationshipid) {
    this.relationshipid = relationshipid;
  }

  @Override
  public String toString() {
    // return "{"+relationshipid+":"+name+"}";
    return name;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 67 * hash + this.relationshipid;
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
    final RelationshipDO other = (RelationshipDO) obj;
    return this.relationshipid == other.relationshipid;
  }
}
