/*
 * Copyright (C) 2021 Jorge R Garcia de Alba &lt;jorge.r.garciadealba@gmail.com&gt;
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
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package io.github.xjrga.snack.other;

import io.github.xjrga.snack.data.DbLink;
import io.github.xjrga.snack.data.Nutrient;
import io.github.xjrga.snack.dataobject.Xml_category;
import io.github.xjrga.snack.dataobject.Xml_category_link;
import io.github.xjrga.snack.dataobject.Xml_food;
import io.github.xjrga.snack.dataobject.Xml_food_nutrient_constraint;
import io.github.xjrga.snack.dataobject.Xml_food_nutrient_ratio_constraint;
import io.github.xjrga.snack.dataobject.Xml_mix;
import io.github.xjrga.snack.dataobject.Xml_nutrient_constraint;
import io.github.xjrga.snack.dataobject.Xml_nutrient_percent_constraint;
import io.github.xjrga.snack.dataobject.Xml_nutrient_ratio_constraint;
import io.github.xjrga.snack.gui.Message;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

/**
 * This class allows import and export of color data in xml format
 *
 * @author Jorge R Garcia de Alba &lt;jorge.r.garciadealba@gmail.com&gt;
 */
public class Xml_receive {

    private final XMLInputFactory inputFactory;
    private XMLEventReader eventReader;
    private String start_event;
    private String end_event;
    private String main_event;
    private final DbLink dbLink;

    /**
     * Constructs DataTransfer class
     */
    public Xml_receive( DbLink dbLink ) {
        inputFactory = XMLInputFactory.newInstance();
        this.dbLink = dbLink;
    }

    public void import_snack_data( String path ) {
        try {
            if( Utilities.validate_xml_doc( "resources/schemas/snack.xsd", path ) ) {
                File file = new File( path );
                BufferedReader reader = new BufferedReader( new FileReader( file ) );
                eventReader = inputFactory.createXMLEventReader( reader );
                Xml_mix mix = null;
                Xml_food food = null;
                Xml_nutrient_constraint nutrient_constraint = null;
                Xml_food_nutrient_constraint food_nutrient_constraint = null;
                Xml_food_nutrient_ratio_constraint food_nutrient_ratio_constraint = null;
                Xml_nutrient_ratio_constraint nutrient_ratio_constraint = null;
                Xml_nutrient_percent_constraint nutrient_percent_constraint = null;
                Xml_category category = null;
                Xml_category_link category_link = null;
                while( eventReader.hasNext() ) {
                    XMLEvent event = eventReader.nextEvent();
                    switch( event.getEventType() ) {
                        case XMLEvent.START_ELEMENT:
                            start_event = event.asStartElement().getName().getLocalPart();
                            switch( start_event ) {
                                case "mix":
                                    System.out.println( "Start mix" );
                                    mix = new Xml_mix();
                                    main_event = start_event;
                                    break;
                                case "food":
                                    System.out.println( "Start food" );
                                    food = new Xml_food();
                                    main_event = start_event;
                                    break;
                                case "category":
                                    System.out.println( "Start category" );
                                    category = new Xml_category();
                                    main_event = start_event;
                                    break;
                                case "category_link":
                                    System.out.println( "Start category_link" );
                                    category_link = new Xml_category_link();
                                    main_event = start_event;
                                    break;
                                case "nutrient_constraint":
                                    System.out.println( "Start nutrient_constraint" );
                                    nutrient_constraint = new Xml_nutrient_constraint();
                                    main_event = start_event;
                                    break;
                                case "food_nutrient_constraint":
                                    System.out.println( "Start food_nutrient_constraint" );
                                    food_nutrient_constraint = new Xml_food_nutrient_constraint();
                                    main_event = start_event;
                                    break;
                                case "food_nutrient_ratio_constraint":
                                    System.out.println( "Start food_nutrient_ratio_constraint" );
                                    food_nutrient_ratio_constraint = new Xml_food_nutrient_ratio_constraint();
                                    main_event = start_event;
                                    break;
                                case "nutrient_ratio_constraint":
                                    System.out.println( "Start nutrient_ratio_constraint" );
                                    nutrient_ratio_constraint = new Xml_nutrient_ratio_constraint();
                                    main_event = start_event;
                                    break;
                                case "nutrient_percent_constraint":
                                    System.out.println( "Start nutrient_percent_constraint" );
                                    nutrient_percent_constraint = new Xml_nutrient_percent_constraint();
                                    main_event = start_event;
                                    break;
                            }
                            break;
                        case XMLEvent.CHARACTERS:
                            String data = event.asCharacters().getData().strip();
                            if( !data.isBlank() ) {
                                switch( start_event ) {
                                    //mix
                                    case "mixid":
                                        mix.set_mixid( data );
                                        break;
                                    case "name":
                                        switch( main_event ) {
                                            case "mix":
                                                mix.set_name( data );
                                                break;
                                            case "food":
                                                food.setName( data );
                                                break;
                                        }
                                        break;
                                    case "categoryid":
                                        switch( main_event ) {
                                            case "category":
                                                category.set_categoryid( data );
                                                break;
                                            case "category_link":
                                                category_link.set_categoryid( data );
                                                break;
                                        }
                                        break;
                                    case "categoryname":
                                        category.set_categoryname( data );
                                        break;
                                    case "foodid":
                                        switch( main_event ) {
                                            case "food":
                                                food.setFoodid( data );
                                                break;
                                            case "category_link":
                                                category_link.set_foodid( data );
                                                break;
                                            case "food_nutrient_constraint":
                                                food_nutrient_constraint.setFoodid( data );
                                                break;
                                            case "nutrient_percent_constraint":
                                                nutrient_percent_constraint.setFoodid( data );
                                                break;
                                        }
                                        break;
                                    case "foodid_01":
                                        food_nutrient_ratio_constraint.setFoodid_a( data );
                                        break;
                                    case "foodid_02":
                                        food_nutrient_ratio_constraint.setFoodid_b( data );
                                        break;
                                    case "nutrientid":
                                        switch( main_event ) {
                                            case "mix":
                                                mix.set_nutrientid( data );
                                                break;
                                            case "nutrient_constraint":
                                                nutrient_constraint.setNutrientid( data );
                                                break;
                                            case "food_nutrient_constraint":
                                                food_nutrient_constraint.setNutrientid( data );
                                                break;
                                            case "nutrient_percent_constraint":
                                                nutrient_percent_constraint.setNutrientid( data );
                                                break;
                                        }
                                        break;
                                    case "nutrientid_01":
                                        switch( main_event ) {
                                            case "food_nutrient_ratio_constraint":
                                                food_nutrient_ratio_constraint.setNutrientid_a( data );
                                                break;
                                            case "nutrient_ratio_constraint":
                                                nutrient_ratio_constraint.setNutrientid_a( data );
                                                break;
                                        }
                                        break;
                                    case "nutrientid_02":
                                        switch( main_event ) {
                                            case "food_nutrient_ratio_constraint":
                                                food_nutrient_ratio_constraint.setNutrientid_b( data );
                                                break;
                                            case "nutrient_ratio_constraint":
                                                nutrient_ratio_constraint.setNutrientid_b( data );
                                                break;
                                        }
                                        break;
                                    case "relationshipid":
                                        switch( main_event ) {
                                            case "nutrient_constraint":
                                                nutrient_constraint.setRelationshipid( Integer.valueOf( data ) );
                                                break;
                                            case "food_nutrient_constraint":
                                                food_nutrient_constraint.setRelationshipid( Integer.valueOf( data ) );
                                                break;
                                            case "food_nutrient_ratio_constraint":
                                                food_nutrient_ratio_constraint.setRelationshipid( Integer.valueOf( data ) );
                                                break;
                                            case "nutrient_ratio_constraint":
                                                nutrient_ratio_constraint.setRelationshipid( Integer.valueOf( data ) );
                                                break;
                                            case "nutrient_percent_constraint":
                                                nutrient_percent_constraint.setRelationshipid( Integer.valueOf( data ) );
                                                break;
                                        }
                                        break;
                                    case "a":
                                        switch( main_event ) {
                                            case "food_nutrient_ratio_constraint":
                                                food_nutrient_ratio_constraint.setA( Double.valueOf( data ) );
                                                break;
                                            case "nutrient_ratio_constraint":
                                                nutrient_ratio_constraint.setA( Double.valueOf( data ) );
                                                break;
                                        }
                                    case "b":
                                        switch( main_event ) {
                                            case "nutrient_constraint":
                                                nutrient_constraint.setB( Double.valueOf( data ) );
                                                break;
                                            case "food_nutrient_constraint":
                                                food_nutrient_constraint.setB( Double.valueOf( data ) );
                                                break;
                                            case "food_nutrient_ratio_constraint":
                                                food_nutrient_ratio_constraint.setB( Double.valueOf( data ) );
                                                break;
                                            case "nutrient_ratio_constraint":
                                                nutrient_ratio_constraint.setB( Double.valueOf( data ) );
                                                break;
                                            case "nutrient_percent_constraint":
                                                nutrient_percent_constraint.setB( Double.valueOf( data ) );
                                                break;
                                        }
                                        break;
                                    //food
                                    case "alcohol":
                                        food.setAlcohol( Double.valueOf( data ) );
                                        break;
                                    case "calcium":
                                        food.setCalcium( Double.valueOf( data ) );
                                        break;
                                    case "carbohydrate_by_difference":
                                        food.setCarbohydrate_by_difference( Double.valueOf( data ) );
                                        break;
                                    case "cholesterol":
                                        food.setCholesterol( Double.valueOf( data ) );
                                        break;
                                    case "choline":
                                        food.setCholine( Double.valueOf( data ) );
                                        break;
                                    case "complete_protein":
                                        food.setComplete_protein( Double.valueOf( data ) );
                                        break;
                                    case "copper":
                                        food.setCopper( Double.valueOf( data ) );
                                        break;
                                    case "cost":
                                        food.setCost( Double.valueOf( data ) );
                                        break;
                                    case "dha":
                                        food.setDha( Double.valueOf( data ) );
                                        break;
                                    case "digestible_carbohydrate":
                                        food.setDigestible_carbohydrate( Double.valueOf( data ) );
                                        break;
                                    case "energy_alcohol":
                                        food.setEnergy_alcohol( Double.valueOf( data ) );
                                        break;
                                    case "energy_carbohydrate":
                                        food.setEnergy_carbohydrate( Double.valueOf( data ) );
                                        break;
                                    case "energy_digestible":
                                        food.setEnergy_digestible( Double.valueOf( data ) );
                                        break;
                                    case "energy_fat_and_carbohydrate":
                                        food.setEnergy_fat_and_carbohydrate( Double.valueOf( data ) );
                                        break;
                                    case "energy_fat":
                                        food.setEnergy_fat( Double.valueOf( data ) );
                                        break;
                                    case "energy_gross":
                                        food.setEnergy_gross( Double.valueOf( data ) );
                                        break;
                                    case "energy_protein":
                                        food.setEnergy_protein( Double.valueOf( data ) );
                                        break;
                                    case "epa":
                                        food.setEpa( Double.valueOf( data ) );
                                        break;
                                    case "fat":
                                        food.setFat( Double.valueOf( data ) );
                                        break;
                                    case "fiber":
                                        food.setFiber( Double.valueOf( data ) );
                                        break;
                                    case "folate":
                                        food.setFolate( Double.valueOf( data ) );
                                        break;
                                    case "glycemic_load":
                                        food.setGlycemic_load( Double.valueOf( data ) );
                                        break;
                                    case "iron":
                                        food.setIron( Double.valueOf( data ) );
                                        break;
                                    case "linoleic":
                                        food.setLinoleic( Double.valueOf( data ) );
                                        break;
                                    case "linolenic":
                                        food.setLinolenic( Double.valueOf( data ) );
                                        break;
                                    case "magnesium":
                                        food.setMagnesium( Double.valueOf( data ) );
                                        break;
                                    case "manganese":
                                        food.setManganese( Double.valueOf( data ) );
                                        break;
                                    case "mufa":
                                        food.setMufa( Double.valueOf( data ) );
                                        break;
                                    case "niacin":
                                        food.setNiacin( Double.valueOf( data ) );
                                        break;
                                    case "pantothenic_acid":
                                        food.setPantothenic_acid( Double.valueOf( data ) );
                                        break;
                                    case "phosphorus":
                                        food.setPhosphorus( Double.valueOf( data ) );
                                        break;
                                    case "potassium":
                                        food.setPotassium( Double.valueOf( data ) );
                                        break;
                                    case "protein":
                                        food.setProtein( Double.valueOf( data ) );
                                        break;
                                    case "pufa":
                                        food.setPufa( Double.valueOf( data ) );
                                        break;
                                    case "riboflavin":
                                        food.setRiboflavin( Double.valueOf( data ) );
                                        break;
                                    case "selenium":
                                        food.setSelenium( Double.valueOf( data ) );
                                        break;
                                    case "sfa":
                                        food.setSfa( Double.valueOf( data ) );
                                        break;
                                    case "sodium":
                                        food.setSodium( Double.valueOf( data ) );
                                        break;
                                    case "thiamin":
                                        food.setThiamin( Double.valueOf( data ) );
                                        break;
                                    case "vitamin_a":
                                        food.setVitamin_a( Double.valueOf( data ) );
                                        break;
                                    case "vitamin_b12":
                                        food.setVitamin_b12( Double.valueOf( data ) );
                                        break;
                                    case "vitamin_b6":
                                        food.setVitamin_b6( Double.valueOf( data ) );
                                        break;
                                    case "vitamin_c":
                                        food.setVitamin_c( Double.valueOf( data ) );
                                        break;
                                    case "vitamin_d":
                                        food.setVitamin_d( Double.valueOf( data ) );
                                        break;
                                    case "vitamin_e":
                                        food.setVitamin_e( Double.valueOf( data ) );
                                        break;
                                    case "vitamin_k":
                                        food.setVitamin_k( Double.valueOf( data ) );
                                        break;
                                    case "water":
                                        food.setWater( Double.valueOf( data ) );
                                        break;
                                    case "weight":
                                        food.setWeight( Double.valueOf( data ) );
                                        break;
                                    case "zinc":
                                        food.setZinc( Double.valueOf( data ) );
                                        break;
                                }
                            }
                            break;
                        case XMLEvent.END_ELEMENT:
                            end_event = event.asEndElement().getName().getLocalPart();
                            switch( end_event ) {
                                case "mix":
                                    System.out.println( "End mix" );
                                    System.out.println( mix.toString() );
                                    try {
                                        dbLink.snack_mix_insertmix(
                                                mix.get_mixid(),
                                                mix.get_name(),
                                                1,
                                                mix.get_nutrientid(),
                                                ""
                                        );
                                    } catch( SQLException ex ) {
                                        System.out.println( "-> " + ex.getMessage()
                                                + " " + mix.get_mixid()
                                                + " " + mix.get_name()
                                                + " " + mix.get_nutrientid()
                                        );
                                    }
                                    break;

                                case "food":
                                    System.out.println( "End food" );
                                    System.out.println( food.toString() );
                                    try {
                                        dbLink.snack_food_insertfood(
                                                food.getFoodid(),
                                                food.getName()
                                        );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.ALCOHOL.getNumber(), food.getAlcohol() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.CALCIUM.getNumber(), food.getCalcium() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.CARBOHYDRATEBYDIFFERENCE.getNumber(), food.getCarbohydrate_by_difference() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.CHOLESTEROL.getNumber(), food.getCholesterol() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.CHOLINE.getNumber(), food.getCholine() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.COMPLETEPROTEIN.getNumber(), food.getComplete_protein() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.COPPER.getNumber(), food.getCopper() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.COST.getNumber(), food.getCost() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.DHA.getNumber(), food.getDha() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.DIGESTIBLECARBOHYDRATE.getNumber(), food.getDigestible_carbohydrate() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.ENERGYALCOHOL.getNumber(), food.getEnergy_alcohol() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.ENERGYCARBOHYDRATE.getNumber(), food.getEnergy_carbohydrate() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.ENERGYDIGESTIBLE.getNumber(), food.getEnergy_digestible() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.ENERGYFATCARBOHYDRATE.getNumber(), food.getEnergy_fat_and_carbohydrate() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.ENERGYFAT.getNumber(), food.getEnergy_fat() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.ENERGYGROSS.getNumber(), food.getEnergy_gross() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.ENERGYPROTEIN.getNumber(), food.getEnergy_protein() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.EPA.getNumber(), food.getEpa() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.FAT.getNumber(), food.getFat() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.FIBER.getNumber(), food.getFiber() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.FOLATE.getNumber(), food.getFolate() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.GLYCEMICLOAD.getNumber(), food.getGlycemic_load() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.IRON.getNumber(), food.getIron() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.LINOLEIC.getNumber(), food.getLinoleic() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.LINOLENIC.getNumber(), food.getLinolenic() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.MAGNESIUM.getNumber(), food.getMagnesium() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.MANGANESE.getNumber(), food.getManganese() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.MUFA.getNumber(), food.getMufa() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.NIACIN.getNumber(), food.getNiacin() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.PANTOTHENICACID.getNumber(), food.getPantothenic_acid() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.PHOSPHORUS.getNumber(), food.getPhosphorus() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.POTASSIUM.getNumber(), food.getPotassium() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.PROTEIN.getNumber(), food.getProtein() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.PUFA.getNumber(), food.getPufa() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.RIBOFLAVIN.getNumber(), food.getRiboflavin() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.SELENIUM.getNumber(), food.getSelenium() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.SFA.getNumber(), food.getSfa() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.SODIUM.getNumber(), food.getSodium() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.THIAMIN.getNumber(), food.getThiamin() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.VITAMINA.getNumber(), food.getVitamin_a() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.VITAMINB12.getNumber(), food.getVitamin_b12() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.VITAMINB6.getNumber(), food.getVitamin_b6() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.VITAMINC.getNumber(), food.getVitamin_c() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.VITAMIND.getNumber(), food.getVitamin_d() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.VITAMINE.getNumber(), food.getVitamin_e() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.VITAMINK.getNumber(), food.getVitamin_k() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.WATER.getNumber(), food.getWater() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.WEIGHT.getNumber(), food.getWeight() );
                                        dbLink.FoodFact_Merge( food.getFoodid(), Nutrient.ZINC.getNumber(), food.getZinc() );
                                    } catch( SQLException ex ) {
                                        System.out.println( "-> " + ex.getMessage()
                                                + " " + food.getFoodid()
                                                + " " + food.getName()
                                        );
                                    }
                                    try {
                                        dbLink.MixFood_Insert(
                                                mix.get_mixid(),
                                                food.getFoodid()
                                        );
                                    } catch( SQLException ex ) {
                                        System.out.println( "-> " + ex.getMessage()
                                                + " " + mix.get_mixid()
                                                + " " + food.getFoodid()
                                        );
                                    }
                                    break;
                                case "category":
                                    System.out.println( "End category" );
                                    System.out.println( category.toString() );
                                    try {
                                        dbLink.FoodCategory_Insert(
                                                category.get_categoryid(),
                                                category.get_categoryname()
                                        );
                                    } catch( SQLException ex ) {
                                        System.out.println( "-> " + ex.getMessage()
                                                + " " + category.get_categoryid()
                                                + " " + category.get_categoryname()
                                        );
                                    }
                                    break;
                                case "category_link":
                                    System.out.println( "End category_link" );
                                    System.out.println( category_link.toString() );
                                    try {
                                        dbLink.CategoryLink_Insert(
                                                category_link.get_categoryid(),
                                                category_link.get_foodid()
                                        );
                                    } catch( SQLException ex ) {
                                        System.out.println( "-> " + ex.getMessage()
                                                + " " + category_link.get_categoryid()
                                                + " " + category_link.get_foodid()
                                        );
                                    }
                                    break;
                                case "nutrient_constraint":
                                    System.out.println( "End nutrient_constraint" );
                                    System.out.println( nutrient_constraint.toString() );
                                    try {
                                        dbLink.NutrientConstraint_Merge(
                                                mix.get_mixid(),
                                                nutrient_constraint.getNutrientid(),
                                                nutrient_constraint.getRelationshipid(),
                                                nutrient_constraint.getB()
                                        );
                                    } catch( SQLException ex ) {
                                        System.out.println( "-> " + ex.getMessage()
                                                + " " + mix.get_mixid()
                                                + " " + nutrient_constraint.getNutrientid()
                                                + " " + nutrient_constraint.getRelationshipid()
                                        );
                                    }
                                    break;
                                case "food_nutrient_constraint":
                                    System.out.println( "End food_nutrient_constraint" );
                                    System.out.println( food_nutrient_constraint.toString() );
                                    try {
                                        dbLink.FoodNutrientConstraint_Merge(
                                                mix.get_mixid(),
                                                food_nutrient_constraint.getFoodid(),
                                                food_nutrient_constraint.getNutrientid(),
                                                food_nutrient_constraint.getRelationshipid(),
                                                food_nutrient_constraint.getB()
                                        );
                                    } catch( SQLException ex ) {
                                        System.out.println( "-> " + ex.getMessage()
                                                + " " + mix.get_mixid()
                                                + " " + food_nutrient_constraint.getFoodid()
                                                + " " + food_nutrient_constraint.getNutrientid()
                                                + " " + food_nutrient_constraint.getRelationshipid() );
                                    }
                                    break;
                                case "food_nutrient_ratio_constraint":
                                    System.out.println( "End food_nutrient_ratio_constraint" );
                                    System.out.println( food_nutrient_ratio_constraint.toString() );
                                    try {
                                        dbLink.FoodNutrientRatio_Merge(
                                                mix.get_mixid(),
                                                food_nutrient_ratio_constraint.getFoodid_a(),
                                                food_nutrient_ratio_constraint.getNutrientid_a(),
                                                food_nutrient_ratio_constraint.getFoodid_b(),
                                                food_nutrient_ratio_constraint.getNutrientid_b(),
                                                food_nutrient_ratio_constraint.getRelationshipid(),
                                                food_nutrient_ratio_constraint.getA(),
                                                food_nutrient_ratio_constraint.getB()
                                        );
                                    } catch( SQLException ex ) {
                                        System.out.println( "-> " + ex.getMessage()
                                                + " " + mix.get_mixid()
                                                + " " + food_nutrient_ratio_constraint.getFoodid_a()
                                                + " " + food_nutrient_ratio_constraint.getNutrientid_a()
                                                + " " + food_nutrient_ratio_constraint.getFoodid_b()
                                                + " " + food_nutrient_ratio_constraint.getNutrientid_b()
                                                + " " + food_nutrient_ratio_constraint.getRelationshipid()
                                        );
                                    }
                                    break;
                                case "nutrient_ratio_constraint":
                                    System.out.println( "End nutrient_ratio_constraint" );
                                    System.out.println( nutrient_ratio_constraint.toString() );
                                    try {
                                        dbLink.NutrientRatio_Merge(
                                                mix.get_mixid(),
                                                nutrient_ratio_constraint.getNutrientid_a(),
                                                nutrient_ratio_constraint.getNutrientid_b(),
                                                nutrient_ratio_constraint.getRelationshipid(),
                                                nutrient_ratio_constraint.getA(),
                                                nutrient_ratio_constraint.getB()
                                        );
                                    } catch( SQLException ex ) {
                                        System.out.println( "-> " + ex.getMessage()
                                                + " " + mix.get_mixid()
                                                + " " + nutrient_ratio_constraint.getNutrientid_a()
                                                + " " + nutrient_ratio_constraint.getNutrientid_b()
                                                + " " + nutrient_ratio_constraint.getRelationshipid()
                                        );
                                    }
                                    break;
                                case "nutrient_percent_constraint":
                                    System.out.println( "End nutrient_percent_constraint" );
                                    System.out.println( nutrient_percent_constraint.toString() );
                                    try {
                                        dbLink.NutrientPercentConstraint_Merge(
                                                mix.get_mixid(),
                                                nutrient_percent_constraint.getFoodid(),
                                                nutrient_percent_constraint.getNutrientid(),
                                                nutrient_percent_constraint.getRelationshipid(),
                                                nutrient_percent_constraint.getB() );
                                    } catch( SQLException ex ) {
                                        System.out.println( "-> " + ex.getMessage()
                                                + " " + mix.get_mixid()
                                                + " " + nutrient_percent_constraint.getFoodid()
                                                + " " + nutrient_percent_constraint.getNutrientid()
                                                + " " + nutrient_percent_constraint.getRelationshipid()
                                        );
                                    }
                                    break;
                            }
                            break;
                    }
                }
                reader.close();
                dbLink.stopTransaction();
            }
            else {
                show_message_invalid();
            }
        } catch( IOException | NumberFormatException | XMLStreamException ex ) {

        }
    }

    private void show_message_invalid() {
        JComponent[] inputs = new JComponent[] {
            new JLabel( "Data exchange document is not valid." )
        };
        Message.showOptionDialog( inputs, "Validation" );
    }
}
