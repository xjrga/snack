/*
 * Snack: Nutritional Software
 * Copyright (C) 2018 Jorge R Garcia de Alba
 * License: http://www.gnu.org/licenses/gpl.html GPL version 2 or higher
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package io.github.xjrga.snack.dataobject;

public class MixDataObject {

    private String MixId;
    private String Name;
    private Integer status;
    private String nutrientid;
    private String model;

    public MixDataObject() {
    }

    public MixDataObject( String MixId, String Name ) {
        this.MixId = MixId;
        this.Name = Name;
    }

    public String getMixId() {
        return MixId;
    }

    public void setMixId( String MixId ) {
        this.MixId = MixId;
    }

    public String getName() {
        return Name;
    }

    public void setName( String Name ) {
        this.Name = Name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus( Integer status ) {
        this.status = status;
    }

    public String getNutrientid() {
        return nutrientid;
    }

    public void setNutrientid( String nutrientid ) {
        this.nutrientid = nutrientid;
    }

    public String getModel() {
        return model;
    }

    public void setModel( String model ) {
        this.model = model;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append( Name );
        return sb.toString();
    }
}
