/*
 * Snack: Learning Software for Nutrition
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
package io.github.xjrga.snack.model;

import io.github.xjrga.snack.data.DbLink;
import io.github.xjrga.snack.data.Nutrient;
import io.github.xjrga.snack.model.iface.Reload_mixid;
import io.github.xjrga.snack.model.iface.Round_up;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;

public class Result_loader
        implements Round_up, Reload_mixid {
    private final DbLink dbLink;
    private Integer precision = 0;
    private Vector cost_table;
    private Vector water_table;
    private Vector electrolytes_table;
    private Vector minerals_table;
    private Vector vitamins_table;
    private Vector carbs_table;
    private Vector fat_table;
    private Vector sfa_table;
    private Vector pufa_table;
    private Vector protein_table;
    private Vector energy_table;
    private Vector macronutrient_table;
    public Result_loader( DbLink dbLink ) {
        this.dbLink = dbLink;
    }
    @Override
    public void reload( String mixid ) {
        energy_table = new Vector();
        macronutrient_table = new Vector();
        protein_table = new Vector();
        fat_table = new Vector();
        sfa_table = new Vector();
        pufa_table = new Vector();
        carbs_table = new Vector();
        vitamins_table = new Vector();
        minerals_table = new Vector();
        electrolytes_table = new Vector();
        water_table = new Vector();
        cost_table = new Vector();
        try {
            LinkedList<HashMap> list = ( LinkedList ) dbLink.MixResult_Select( mixid, precision );
            list.forEach( rowm
                    -> {
                //ENERGY TABLE
                String Name = ( String ) rowm.get( "Name" );
                Double Weight = ( Double ) rowm.get( Nutrient.WEIGHT.getLabel() );
                Double EnergyGross = ( Double ) rowm.get( Nutrient.ENERGYGROSS.getLabel() );
                Double EnergyDigestible = ( Double ) rowm.get( Nutrient.ENERGYDIGESTIBLE.getLabel() );
                Double EnergyFat = ( Double ) rowm.get( Nutrient.ENERGYFAT.getLabel() );
                Double EnergyCarbohydrate = ( Double ) rowm.get( Nutrient.ENERGYCARBOHYDRATE.getLabel() );
                Double EnergyProtein = ( Double ) rowm.get( Nutrient.ENERGYPROTEIN.getLabel() );
                Double EnergyAlcohol = ( Double ) rowm.get( Nutrient.ENERGYALCOHOL.getLabel() );
                Double EnergyFatCarbohydrate = ( Double ) rowm.get( Nutrient.ENERGYFATCARBOHYDRATE.getLabel() );
                Vector energy_row = new Vector();
                energy_row.add( Name );
                energy_row.add( Weight );
                energy_row.add( EnergyGross );
                energy_row.add( EnergyDigestible );
                energy_row.add( EnergyFat );
                energy_row.add( EnergyCarbohydrate );
                energy_row.add( EnergyFatCarbohydrate );
                energy_row.add( EnergyProtein );
                energy_row.add( EnergyAlcohol );
                energy_table.add( energy_row );
                //MACRONUTRIENT TABLE
                Double Fat = ( Double ) rowm.get( Nutrient.FAT.getLabel() );
                Double DigestibleCarbohydrate = ( Double ) rowm.get( Nutrient.DIGESTIBLECARBOHYDRATE.getLabel() );
                Double Protein = ( Double ) rowm.get( Nutrient.PROTEIN.getLabel() );
                Double Alcohol = ( Double ) rowm.get( Nutrient.ALCOHOL.getLabel() );
                Vector macronutrient_row = new Vector();
                macronutrient_row.add( Name );
                macronutrient_row.add( Weight );
                macronutrient_row.add( Fat );
                macronutrient_row.add( DigestibleCarbohydrate );
                macronutrient_row.add( Protein );
                macronutrient_row.add( Alcohol );
                macronutrient_table.add( macronutrient_row );
                //PROTEIN TABLE
                Double CompleteProtein = ( Double ) rowm.get( Nutrient.COMPLETEPROTEIN.getLabel() );
                Vector protein_row = new Vector();
                protein_row.add( Name );
                protein_row.add( Weight );
                protein_row.add( EnergyProtein );
                protein_row.add( Protein );
                protein_row.add( CompleteProtein );
                protein_table.add( protein_row );
                //FAT TABLE
                Double Monounsaturated = ( Double ) rowm.get( Nutrient.MUFA.getLabel() );
                Double Polyunsaturated = ( Double ) rowm.get( Nutrient.PUFA.getLabel() );
                Double Saturated = ( Double ) rowm.get( Nutrient.SFA.getLabel() );
                Double Cholesterol = ( Double ) rowm.get( Nutrient.CHOLESTEROL.getLabel() );
                Vector fat_row = new Vector();
                fat_row.add( Name );
                fat_row.add( Weight );
                fat_row.add( EnergyFat );
                fat_row.add( Fat );
                fat_row.add( Monounsaturated );
                fat_row.add( Polyunsaturated );
                fat_row.add( Saturated );
                fat_row.add( Cholesterol );
                fat_table.add( fat_row );
                //SFA TABLE
                Double Lauric = ( Double ) rowm.get( Nutrient.LAURIC.getLabel() );
                Double Myristic = ( Double ) rowm.get( Nutrient.MYRISTIC.getLabel() );
                Double Palmitic = ( Double ) rowm.get( Nutrient.PALMITIC.getLabel() );
                Double Stearic = ( Double ) rowm.get( Nutrient.STEARIC.getLabel() );
                Double Hcsfa = ( Double ) rowm.get( Nutrient.HCSFA.getLabel() );
                Vector sfa_row = new Vector();
                sfa_row.add( Name );
                sfa_row.add( Weight );
                sfa_row.add( Saturated );
                sfa_row.add( Hcsfa );
                sfa_row.add( Lauric );
                sfa_row.add( Myristic );
                sfa_row.add( Palmitic );
                sfa_row.add( Stearic );
                sfa_table.add( sfa_row );
                //PUFA TABLE
                Double Linoleic = ( Double ) rowm.get( Nutrient.LINOLEIC.getLabel() );
                Double Linolenic = ( Double ) rowm.get( Nutrient.LINOLENIC.getLabel() );
                Double DHA = ( Double ) rowm.get( Nutrient.DHA.getLabel() );
                Double EPA = ( Double ) rowm.get( Nutrient.EPA.getLabel() );
                Vector pufa_row = new Vector();
                pufa_row.add( Name );
                pufa_row.add( Weight );
                pufa_row.add( Polyunsaturated );
                pufa_row.add( Linoleic );
                pufa_row.add( Linolenic );
                pufa_row.add( EPA );
                pufa_row.add( DHA );
                pufa_table.add( pufa_row );
                //CARBOHYDRATE TABLE
                Double CarbsByDiff = ( Double ) rowm.get( Nutrient.CARBOHYDRATEBYDIFFERENCE.getLabel() );
                Double Fiber = ( Double ) rowm.get( Nutrient.FIBER.getLabel() );
                Vector carbs_row = new Vector();
                carbs_row.add( Name );
                carbs_row.add( Weight );
                carbs_row.add( EnergyCarbohydrate );
                carbs_row.add( CarbsByDiff );
                carbs_row.add( Fiber );
                carbs_row.add( DigestibleCarbohydrate );
                carbs_table.add( carbs_row );
                //VITAMINS TABLE
                Double VitaminA = ( Double ) rowm.get( Nutrient.VITAMINA.getLabel() );
                Double VitaminE = ( Double ) rowm.get( Nutrient.VITAMINE.getLabel() );
                Double VitaminD = ( Double ) rowm.get( Nutrient.VITAMIND.getLabel() );
                Double VitaminC = ( Double ) rowm.get( Nutrient.VITAMINC.getLabel() );
                Double Thiamin = ( Double ) rowm.get( Nutrient.THIAMIN.getLabel() );
                Double Riboflavin = ( Double ) rowm.get( Nutrient.RIBOFLAVIN.getLabel() );
                Double Niacin = ( Double ) rowm.get( Nutrient.NIACIN.getLabel() );
                Double Pantothenic = ( Double ) rowm.get( Nutrient.PANTOTHENICACID.getLabel() );
                Double VitaminB6 = ( Double ) rowm.get( Nutrient.VITAMINB6.getLabel() );
                Double VitaminB12 = ( Double ) rowm.get( Nutrient.VITAMINB12.getLabel() );
                Double Choline = ( Double ) rowm.get( Nutrient.CHOLINE.getLabel() );
                Double VitaminK = ( Double ) rowm.get( Nutrient.VITAMINK.getLabel() );
                Double Folate = ( Double ) rowm.get( Nutrient.FOLATE.getLabel() );
                Vector vitamins_row = new Vector();
                vitamins_row.add( Name );
                vitamins_row.add( Weight );
                vitamins_row.add( VitaminA );
                vitamins_row.add( VitaminD );
                vitamins_row.add( VitaminE );
                vitamins_row.add( VitaminC );
                vitamins_row.add( Thiamin );
                vitamins_row.add( Riboflavin );
                vitamins_row.add( Niacin );
                vitamins_row.add( VitaminB6 );
                vitamins_row.add( Folate );
                vitamins_row.add( VitaminB12 );
                vitamins_row.add( VitaminK );
                vitamins_row.add( Pantothenic );
                vitamins_row.add( Choline );
                vitamins_table.add( vitamins_row );
                //MINERALS TABLE
                Double Calcium = ( Double ) rowm.get( Nutrient.CALCIUM.getLabel() );
                Double Iron = ( Double ) rowm.get( Nutrient.IRON.getLabel() );
                Double Magnesium = ( Double ) rowm.get( Nutrient.MAGNESIUM.getLabel() );
                Double Phosphorus = ( Double ) rowm.get( Nutrient.PHOSPHORUS.getLabel() );
                Double Zinc = ( Double ) rowm.get( Nutrient.ZINC.getLabel() );
                Double Copper = ( Double ) rowm.get( Nutrient.COPPER.getLabel() );
                Double Manganese = ( Double ) rowm.get( Nutrient.MANGANESE.getLabel() );
                Double Selenium = ( Double ) rowm.get( Nutrient.SELENIUM.getLabel() );
                Vector minerals_row = new Vector();
                minerals_row.add( Name );
                minerals_row.add( Weight );
                minerals_row.add( Calcium );
                minerals_row.add( Phosphorus );
                minerals_row.add( Magnesium );
                minerals_row.add( Iron );
                minerals_row.add( Zinc );
                minerals_row.add( Copper );
                minerals_row.add( Manganese );
                minerals_row.add( Selenium );
                minerals_table.add( minerals_row );
                //ELECTROLYTES TABLE
                Double Potassium = ( Double ) rowm.get( Nutrient.POTASSIUM.getLabel() );
                Double Sodium = ( Double ) rowm.get( Nutrient.SODIUM.getLabel() );
                Double Water = ( Double ) rowm.get( Nutrient.WATER.getLabel() );
                Vector electrolytes_row = new Vector();
                electrolytes_row.add( Name );
                electrolytes_row.add( Weight );
                electrolytes_row.add( Water );
                electrolytes_row.add( Potassium );
                electrolytes_row.add( Sodium );
                electrolytes_table.add( electrolytes_row );
                //COST TABLE
                Double Cost = ( Double ) rowm.get( Nutrient.COST.getLabel() );
                Vector cost_row = new Vector();
                cost_row.add( Name );
                cost_row.add( Weight );
                cost_row.add( Cost );
                cost_table.add( cost_row );
            } );
        } catch ( SQLException e ) {
        }
    }
    @Override
    public void set_precision( Integer precision ) {
        this.precision = precision;
    }
    public Integer getPrecision() {
        return precision;
    }
    public Vector get_cost_table() {
        return cost_table;
    }
    public Vector get_water_table() {
        return water_table;
    }
    public Vector get_electrolytes_table() {
        return electrolytes_table;
    }
    public Vector get_minerals_table() {
        return minerals_table;
    }
    public Vector get_vitamins_table() {
        return vitamins_table;
    }
    public Vector get_carbs_table() {
        return carbs_table;
    }
    public Vector get_fats_table() {
        return fat_table;
    }
    public Vector get_sfa_table() {
        return sfa_table;
    }
    public Vector get_pufa_table() {
        return pufa_table;
    }
    public Vector get_protein_table() {
        return protein_table;
    }
    public Vector get_energy_table() {
        return energy_table;
    }
    public Vector get_macronutrient_table() {
        return macronutrient_table;
    }
}
