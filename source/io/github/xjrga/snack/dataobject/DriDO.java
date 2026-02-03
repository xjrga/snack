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

public class DriDO {

    private String nutrientId;
    private String nutrientName;
    private String nutrientUnits;
    private Integer lifestageId;
    private String lifestageLabel;
    private BigDecimal nutrientQ;


    public DriDO() {
    }


    public DriDO(
            String nutrientId,
            String nutrientName,
            String nutrientUnits,
            Integer lifestageId,
            String lifestageLabel,
            BigDecimal nutrientQ ) {
        this.nutrientId = nutrientId;
        this.nutrientName = nutrientName;
        this.nutrientUnits = nutrientUnits;
        this.lifestageId = lifestageId;
        this.lifestageLabel = lifestageLabel;
        this.nutrientQ = nutrientQ;
    }


    public String getNutrientId() {
        return nutrientId;
    }


    public void setNutrientId( String nutrientId ) {
        this.nutrientId = nutrientId;
    }


    public String getNutrientName() {
        return nutrientName;
    }


    public void setNutrientName( String nutrientName ) {
        this.nutrientName = nutrientName;
    }


    public String getNutrientUnits() {
        return nutrientUnits;
    }


    public void setNutrientUnits( String nutrientUnits ) {
        this.nutrientUnits = nutrientUnits;
    }


    public Integer getLifestageId() {
        return lifestageId;
    }


    public void setLifestageId( Integer lifestageId ) {
        this.lifestageId = lifestageId;
    }


    public String getLifestageLabel() {
        return lifestageLabel;
    }


    public void setLifestageLabel( String lifestageLabel ) {
        this.lifestageLabel = lifestageLabel;
    }


    public BigDecimal getNutrientQ() {
        return nutrientQ;
    }


    public void setNutrientQ( BigDecimal nutrientQ ) {
        this.nutrientQ = nutrientQ;
    }
}
