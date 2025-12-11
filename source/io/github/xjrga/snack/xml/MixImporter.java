/*
 * Copyright (C) 2021 Jorge R Garcia de Alba &lt;jorge.r.garciadealba@gmail.com&gt;
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
 * not, write to the Free Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 */
package io.github.xjrga.snack.xml;

import io.github.xjrga.snack.database.callable.BackgroundExec;
import io.github.xjrga.snack.database.callable.FoodCreator;
import io.github.xjrga.snack.database.callable.insert.InsertGroupFoodTask;
import io.github.xjrga.snack.database.callable.insert.InsertFoodPortionTask;
import io.github.xjrga.snack.database.callable.insert.InsertGroupTask;
import io.github.xjrga.snack.database.callable.insert.InsertMealTask;
import io.github.xjrga.snack.database.callable.insert.InsertMixFoodTask;
import io.github.xjrga.snack.database.callable.insert.InsertMixTask;
import io.github.xjrga.snack.database.callable.insert.MergeGroupConstraintTask;
import io.github.xjrga.snack.database.callable.insert.MergeFoodConstraintTask;
import io.github.xjrga.snack.database.callable.insert.MergeFoodRatioConstraintTask;
import io.github.xjrga.snack.database.callable.insert.MergeNutrientConstraintTask;
import io.github.xjrga.snack.database.callable.insert.MergeNutrientRatioConstraintTask;
import io.github.xjrga.snack.dataobject.Category;
import io.github.xjrga.snack.dataobject.Food;
import io.github.xjrga.snack.dataobject.MixDO;
import io.github.xjrga.snack.dataobject.O_Meal;
import io.github.xjrga.snack.dataobject.O_MealFoodPortion;
import io.github.xjrga.snack.dataobject.O_group;
import io.github.xjrga.snack.dataobject.O_groupfood;
import io.github.xjrga.snack.dataobject.Xml_food_nutrient_constraint;
import io.github.xjrga.snack.dataobject.Xml_food_nutrient_ratio_constraint;
import io.github.xjrga.snack.dataobject.Xml_group_constraint;
import io.github.xjrga.snack.dataobject.Xml_nutrient_constraint;
import io.github.xjrga.snack.dataobject.Xml_nutrient_ratio_constraint;
import io.github.xjrga.snack.gui.Message;
import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.other.Utilities;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.concurrent.Future;
import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

/**
 * This class allows import and export of snack data in xml format
 *
 * @author Jorge R Garcia de Alba &lt;jorge.r.garciadealba@gmail.com&gt;
 */
public class MixImporter {

    private String endEvent;
    private XMLEventReader eventReader;
    private String mainEvent;
    private String startEvent;
    private StartElement startElement;

    public MixImporter() {}

    public MixDO receive(String path) {

        MixDO mix = new MixDO("");

        if (!validateMixSchema(path)) {

            return mix;
        }

        mix = parseMixDocument(path);
        return mix;
    }

    private boolean validateMixSchema(String path) {

        boolean validated = true;
        URL schemaUrl = Utilities.getResourceAsUrl("/resources/schemas/snacks.xsd");
        Source xmlFile = new StreamSource(new File(path));
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = null;

        try {

            schema = schemaFactory.newSchema(schemaUrl);

        } catch (SAXException e) {

            LoggerImpl.INSTANCE.logProblem(e);
            validated = false;
            Message.showMessagePad(800, 300, "File is not valid.", e.getMessage());
        }

        Validator validator = schema.newValidator();

        try {

            validator.validate(xmlFile);

        } catch (IOException | SAXException e) {

            LoggerImpl.INSTANCE.logProblem(e);
            validated = false;
            Message.showMessagePad(800, 300, "File is not valid.", e.getMessage());
        }

        return validated;
    }

    private MixDO parseMixDocument(String path) {

        MixDO mix = new MixDO();
        BufferedReader reader = null;

        try {

            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            reader = new BufferedReader(new FileReader(new File(path)));
            eventReader = inputFactory.createXMLEventReader(reader);

        } catch (FileNotFoundException | XMLStreamException e) {

            LoggerImpl.INSTANCE.logProblem(e);
        }

        Food food = null;
        Xml_nutrient_constraint nutrient_constraint = null;
        Xml_food_nutrient_constraint food_nutrient_constraint = null;
        Xml_food_nutrient_ratio_constraint food_nutrient_ratio_constraint = null;
        Xml_nutrient_ratio_constraint nutrient_ratio_constraint = null;
        Xml_group_constraint group_constraint = null;
        Category category = null;
        O_Meal meal = null;
        O_MealFoodPortion portion = new O_MealFoodPortion();
        QName attribute = new QName("nutr_no");
        String nutr_no = "";
        boolean created = false;
        O_group group = null;
        O_groupfood groupfood = null;

        while (eventReader.hasNext()) {

            XMLEvent event = null;

            try {

                event = eventReader.nextEvent();

            } catch (Exception e) {

                LoggerImpl.INSTANCE.logProblem(e);
            }

            switch (event.getEventType()) {
                case XMLStreamConstants.START_ELEMENT:
                    startElement = event.asStartElement();
                    startEvent = startElement.getName().getLocalPart();
                    switch (startEvent) {
                        case "snack" -> {
                            mainEvent = startEvent;
                        }
                        case "mix" -> {
                            mix = new MixDO();
                            mainEvent = startEvent;
                        }
                        case "food" -> {
                            food = new Food();
                            mainEvent = startEvent;
                        }
                        case "category" -> {
                            category = new Category();
                            mainEvent = startEvent;
                        }
                        case "nutrient_quantity" -> {
                            nutrient_constraint = new Xml_nutrient_constraint();
                            mainEvent = startEvent;
                        }
                        case "nutrient_ratio" -> {
                            nutrient_ratio_constraint = new Xml_nutrient_ratio_constraint();
                            mainEvent = startEvent;
                        }
                        case "food_quantity" -> {
                            food_nutrient_constraint = new Xml_food_nutrient_constraint();
                            mainEvent = startEvent;
                        }
                        case "food_ratio" -> {
                            food_nutrient_ratio_constraint = new Xml_food_nutrient_ratio_constraint();
                            mainEvent = startEvent;
                        }
                        case "meal" -> {
                            meal = new O_Meal();
                            mainEvent = startEvent;
                        }
                        case "meal_food_portion" -> {
                            portion = new O_MealFoodPortion();
                            mainEvent = startEvent;
                        }
                        case "group" -> {
                            group = new O_group();
                            mainEvent = startEvent;
                        }
                        case "groupfood" -> {
                            groupfood = new O_groupfood();
                            mainEvent = startEvent;
                        }
                        case "group_quantity" -> {
                            group_constraint = new Xml_group_constraint();
                            mainEvent = startEvent;
                        }
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    String data = event.asCharacters().getData().strip();
                    if (!data.isBlank()) {

                        switch (startEvent) {
                            case "mix-name":
                                mix.setName(data);
                                break;

                            case "group-id":
                                switch (mainEvent) {
                                    case "group" -> group.setGroupid(data);
                                    case "groupfood" -> groupfood.setGroupid(data);
                                    case "group_quantity" -> group_constraint.setGroupid(data);
                                }
                                break;

                            case "group-name":
                                group.setName(data);
                                break;

                            case "meal-id":
                                switch (mainEvent) {
                                    case "meal" -> meal.setMealid(Integer.valueOf(data));
                                    case "meal_food_portion" -> portion.setMealid(Integer.valueOf(data));
                                }
                                break;

                            case "meal-name":
                                meal.setName(data);
                                break;

                            case "meal-order":
                                meal.setMealOrder(Integer.valueOf(data));
                                break;

                            case "pct":
                                portion.setPct(new BigDecimal(data));
                                break;

                            case "expected-wt":
                                portion.setExpectedwt(new BigDecimal(data));
                                break;

                            case "actual-wt":
                                portion.setActualwt(new BigDecimal(data));
                                break;

                            case "mix-id":
                                switch (mainEvent) {
                                    case "mix" -> mix.setMixid(data);
                                    case "meal" -> meal.setMixid(data);
                                    case "meal_food_portion" -> portion.setMixid(data);
                                    case "group" -> group.setMixid(data);
                                    case "groupfood" -> groupfood.setMixid(data);
                                }
                                break;

                            case "category-id":
                                category.setCategoryId(data);
                                break;

                            case "category-name":
                                category.setCategoryName(data);
                                break;

                            case "food-id":
                                switch (mainEvent) {
                                    case "food" -> food.setFoodId(data);
                                    case "food_quantity" -> food_nutrient_constraint.setFoodid(data);
                                    case "meal_food_portion" -> portion.setFoodid(data);
                                    case "groupfood" -> groupfood.setFoodid(data);
                                }
                                break;

                            case "food-id_a":
                                food_nutrient_ratio_constraint.setFoodid_a(data);
                                break;

                            case "food-id_b":
                                food_nutrient_ratio_constraint.setFoodid_b(data);
                                break;

                            case "nutrient-id":
                                switch (mainEvent) {
                                    case "nutrient_quantity" -> nutrient_constraint.setNutrientid(data);
                                    case "food_quantity" -> food_nutrient_constraint.setNutrientid(data);
                                    case "group_quantity" -> group_constraint.setNutrientid(data);
                                }
                                break;

                            case "lifestage-id":
                                switch (mainEvent) {
                                    case "mix" -> mix.setLifestageid(Integer.valueOf(data));
                                }
                                break;

                            case "nutrient-id_a":
                                switch (mainEvent) {
                                    case "nutrient_ratio" -> nutrient_ratio_constraint.setNutrientid_a(data);
                                    case "food_ratio" -> food_nutrient_ratio_constraint.setNutrientid_a(data);
                                }
                                break;

                            case "nutrient-id_b":
                                switch (mainEvent) {
                                    case "nutrient_ratio" -> nutrient_ratio_constraint.setNutrientid_b(data);
                                    case "food_ratio" -> food_nutrient_ratio_constraint.setNutrientid_b(data);
                                }
                                break;

                            case "relationship-id":
                                switch (mainEvent) {
                                    case "nutrient_quantity" ->
                                        nutrient_constraint.setRelationshipid(Integer.valueOf(data));
                                    case "nutrient_ratio" ->
                                        nutrient_ratio_constraint.setRelationshipid(Integer.valueOf(data));
                                    case "food_quantity" ->
                                        food_nutrient_constraint.setRelationshipid(Integer.valueOf(data));
                                    case "food_ratio" ->
                                        food_nutrient_ratio_constraint.setRelationshipid(Integer.valueOf(data));
                                    case "group_quantity" -> group_constraint.setRelationshipid(Integer.valueOf(data));
                                }
                                break;

                            case "a":
                                switch (mainEvent) {
                                    case "nutrient_ratio" -> nutrient_ratio_constraint.setA(new BigDecimal(data));
                                    case "food_ratio" -> food_nutrient_ratio_constraint.setA(new BigDecimal(data));
                                }
                            case "b":
                                switch (mainEvent) {
                                    case "nutrient_quantity" -> nutrient_constraint.setB(new BigDecimal(data));
                                    case "nutrient_ratio" -> nutrient_ratio_constraint.setB(new BigDecimal(data));
                                    case "food_quantity" -> food_nutrient_constraint.setB(new BigDecimal(data));
                                    case "food_ratio" -> food_nutrient_ratio_constraint.setB(new BigDecimal(data));
                                    case "group_quantity" -> group_constraint.setB(new BigDecimal(data));
                                }
                                break;

                            case "food-name":
                                food.setFoodName(data);
                                break;

                            // ** Carbohydrates **
                            // Carbohydrates, By Difference (g), 205,
                            // carbohydrates-carbs_by_diff
                            case "carbohydrates-carbs_by_diff":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setCarbohydrates_carbs_by_diff_quantity(data);
                                food.setCarbohydrates_carbs_by_diff_nutr_no(nutr_no);
                                break;

                            // Carbohydrates, Fiber, Insoluble (g), 10018,
                            // carbohydrates-fiber_insoluble
                            case "carbohydrates-fiber_insoluble":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setCarbohydrates_fiber_insoluble_quantity(data);
                                food.setCarbohydrates_fiber_insoluble_nutr_no(nutr_no);
                                break;

                            // Carbohydrates, Fiber, Soluble (g), 10017,
                            // carbohydrates-fiber_soluble
                            case "carbohydrates-fiber_soluble":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setCarbohydrates_fiber_soluble_quantity(data);
                                food.setCarbohydrates_fiber_soluble_nutr_no(nutr_no);
                                break;

                            // Carbohydrates, Fiber (g), 291,
                            // carbohydrates-fiber
                            case "carbohydrates-fiber":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setCarbohydrates_fiber_quantity(data);
                                food.setCarbohydrates_fiber_nutr_no(nutr_no);
                                break;

                            // Carbohydrates, Fructose (g), 212,
                            // carbohydrates-fructose
                            case "carbohydrates-fructose":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setCarbohydrates_fructose_quantity(data);
                                food.setCarbohydrates_fructose_nutr_no(nutr_no);
                                break;

                            // Carbohydrates, Glucose (g), 211,
                            // carbohydrates-glucose
                            case "carbohydrates-glucose":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setCarbohydrates_glucose_quantity(data);
                                food.setCarbohydrates_glucose_nutr_no(nutr_no);
                                break;

                            case "carbohydrates-glycemic_load":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setCarbohydrates_glycemic_load_quantity(data);
                                food.setCarbohydrates_glycemic_load_nutr_no(nutr_no);
                                break;

                            // Carbohydrates, Lactose (g), 213,
                            // carbohydrates-lactose
                            case "carbohydrates-lactose":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setCarbohydrates_lactose_quantity(data);
                                food.setCarbohydrates_lactose_nutr_no(nutr_no);
                                break;

                            // Carbohydrates, Starch (g), 209,
                            // carbohydrates-starch
                            case "carbohydrates-starch":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setCarbohydrates_starch_quantity(data);
                                food.setCarbohydrates_starch_nutr_no(nutr_no);
                                break;

                            // Carbohydrates, Sucrose (g), 210,
                            // carbohydrates-sucrose
                            case "carbohydrates-sucrose":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setCarbohydrates_sucrose_quantity(data);
                                food.setCarbohydrates_sucrose_nutr_no(nutr_no);
                                break;

                            // Carbohydrates, Sugars (g), 269,
                            // carbohydrates-sugars
                            case "carbohydrates-sugars":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setCarbohydrates_sugars_quantity(data);
                                food.setCarbohydrates_sugars_nutr_no(nutr_no);
                                break;

                            // ** Energy **
                            case "energy-gross":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setEnergy_gross_quantity(data);
                                food.setEnergy_gross_nutr_no(nutr_no);
                                break;

                            // ** Fats **
                            // Fats, Cholesterol (mg), 601, fats-cholesterol
                            case "fats-cholesterol":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setFats_cholesterol_quantity(data);
                                food.setFats_cholesterol_nutr_no(nutr_no);
                                break;

                            // Fats, Docosahexaenoic Acid, DHA, 22:6 n-3
                            // (g), 621, fats-dha
                            case "fats-dha":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setFats_dha_quantity(data);
                                food.setFats_dha_nutr_no(nutr_no);
                                break;

                            // Fats, Eicosapentaenoic Acid, EPA, 20:5 n-3
                            // (g), 629, fats-epa
                            case "fats-epa":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setFats_epa_quantity(data);
                                food.setFats_epa_nutr_no(nutr_no);
                                break;

                            // Fats, Lauric Acid, 12:0 (g), 611, fats-lauric
                            case "fats-lauric":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setFats_lauric_quantity(data);
                                food.setFats_lauric_nutr_no(nutr_no);
                                break;

                            // Fats, Linoleic Acid, LA, 18:2 n-6 (g), 618,
                            // fats-linoleic
                            case "fats-linoleic":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setFats_linoleic_quantity(data);
                                food.setFats_linoleic_nutr_no(nutr_no);
                                break;

                            // Fats, Linolenic Acid, ALA, 18:3 n-3 (g), 619,
                            // fats-linolenic
                            case "fats-linolenic":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setFats_linolenic_quantity(data);
                                food.setFats_linolenic_nutr_no(nutr_no);
                                break;

                            // Fats, Monounsaturated Fat, MUFA (g), 645,
                            // fats-monounsaturated
                            case "fats-monounsaturated":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setFats_monounsaturated_quantity(data);
                                food.setFats_monounsaturated_nutr_no(nutr_no);
                                break;

                            // Fats, Myristic Acid, 14:0 (g), 612,
                            // fats-myristic
                            case "fats-myristic":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setFats_myristic_quantity(data);
                                food.setFats_myristic_nutr_no(nutr_no);
                                break;

                            // Fats, Palmitic Acid, 16:0 (g), 613,
                            // fats-palmitic
                            case "fats-palmitic":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setFats_palmitic_quantity(data);
                                food.setFats_palmitic_nutr_no(nutr_no);
                                break;

                            // Fats, Polyunsaturated Fat, PUFA (g), 646,
                            // fats-polyunsaturated
                            case "fats-polyunsaturated":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setFats_polyunsaturated_quantity(data);
                                food.setFats_polyunsaturated_nutr_no(nutr_no);
                                break;

                            // Fats, Saturated Fat, SFA (g), 606,
                            // fats-saturated
                            case "fats-saturated":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setFats_saturated_quantity(data);
                                food.setFats_saturated_nutr_no(nutr_no);
                                break;

                            // Fats, Stearic Acid, 18:0 (g), 614,
                            // fats-stearic
                            case "fats-stearic":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setFats_stearic_quantity(data);
                                food.setFats_stearic_nutr_no(nutr_no);
                                break;

                            // Fats, Total Fat (g), 204, fats-total
                            case "fats-total":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setFats_total_quantity(data);
                                food.setFats_total_nutr_no(nutr_no);
                                break;

                            // ** Minerals **
                            // Minerals, Calcium (mg), 301, minerals-calcium
                            case "minerals-calcium":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setMinerals_calcium_quantity(data);
                                food.setMinerals_calcium_nutr_no(nutr_no);
                                break;

                            // Minerals, Copper (mg), 312, minerals-copper
                            case "minerals-copper":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setMinerals_copper_quantity(data);
                                food.setMinerals_copper_nutr_no(nutr_no);
                                break;

                            // Minerals, Iron (mg), 303, minerals-iron
                            case "minerals-iron":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setMinerals_iron_quantity(data);
                                food.setMinerals_iron_nutr_no(nutr_no);
                                break;

                            // Minerals, Magnesium (mg), 304,
                            // minerals-magnesium
                            case "minerals-magnesium":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setMinerals_magnesium_quantity(data);
                                food.setMinerals_magnesium_nutr_no(nutr_no);
                                break;

                            // Minerals, Manganese (mg), 315,
                            // minerals-manganese
                            case "minerals-manganese":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setMinerals_manganese_quantity(data);
                                food.setMinerals_manganese_nutr_no(nutr_no);
                                break;

                            // Minerals, Phosphorus (mg), 305,
                            // minerals-phosphorus
                            case "minerals-phosphorus":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setMinerals_phosphorus_quantity(data);
                                food.setMinerals_phosphorus_nutr_no(nutr_no);
                                break;

                            // Minerals, Potassium (mg), 306,
                            // minerals-potassium
                            case "minerals-potassium":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setMinerals_potassium_quantity(data);
                                food.setMinerals_potassium_nutr_no(nutr_no);
                                break;

                            // Minerals, Selenium (µg), 317,
                            // minerals-selenium
                            case "minerals-selenium":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setMinerals_selenium_quantity(data);
                                food.setMinerals_selenium_nutr_no(nutr_no);
                                break;

                            // Minerals, Sodium (mg), 307, minerals-sodium
                            case "minerals-sodium":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setMinerals_sodium_quantity(data);
                                food.setMinerals_sodium_nutr_no(nutr_no);
                                break;

                            // Minerals, Zinc (mg), 309, minerals-zinc
                            case "minerals-zinc":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setMinerals_zinc_quantity(data);
                                food.setMinerals_zinc_nutr_no(nutr_no);
                                break;

                            // ** Other **
                            // Other, Alcohol (g), 221, other-alcohol
                            case "other-alcohol":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setOther_alcohol_quantity(data);
                                food.setOther_alcohol_nutr_no(nutr_no);
                                break;

                            // Other, Cost ($), 10005, other-cost
                            case "other-cost":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setOther_cost_quantity(data);
                                food.setOther_cost_nutr_no(nutr_no);
                                break;

                            // Other, Water (g), 255, other-water
                            case "other-water":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setOther_water_quantity(data);
                                food.setOther_water_nutr_no(nutr_no);
                                break;

                            // Other, Weight (g), 10000, other-weight
                            case "other-weight":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setOther_weight_quantity(data);
                                food.setOther_weight_nutr_no(nutr_no);
                                break;

                            // ** Phytonutrients **
                            // Phytonutrients, Anthocyanins (mg), 10024,
                            // phytonutrients-anthocyanins
                            case "phytonutrients-anthocyanins":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setPhytonutrients_anthocyanins_quantity(data);
                                food.setPhytonutrients_anthocyanins_nutr_no(nutr_no);
                                break;

                            // Phytonutrients, Caffeine (mg), 262,
                            // phytonutrients-caffeine
                            case "phytonutrients-caffeine":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setPhytonutrients_caffeine_quantity(data);
                                food.setPhytonutrients_caffeine_nutr_no(nutr_no);
                                break;

                            // Phytonutrients, Carotene, beta (µg), 321,
                            // phytonutrients-beta_carotene
                            case "phytonutrients-beta_carotene":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setPhytonutrients_beta_carotene_quantity(data);
                                food.setPhytonutrients_beta_carotene_nutr_no(nutr_no);
                                break;

                            // Phytonutrients, Carotenoids (mg), 10019,
                            // phytonutrients-carotenoids
                            case "phytonutrients-carotenoids":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setPhytonutrients_carotenoids_quantity(data);
                                food.setPhytonutrients_carotenoids_nutr_no(nutr_no);
                                break;

                            // Phytonutrients, Flavanols (mg), 10022,
                            // phytonutrients-flavanols
                            case "phytonutrients-flavanols":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setPhytonutrients_flavanols_quantity(data);
                                food.setPhytonutrients_flavanols_nutr_no(nutr_no);
                                break;

                            // Phytonutrients, Flavanones (mg), 10023,
                            // phytonutrients-flavanones
                            case "phytonutrients-flavanones":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setPhytonutrients_flavanones_quantity(data);
                                food.setPhytonutrients_flavanones_nutr_no(nutr_no);
                                break;

                            // Phytonutrients, Flavones (mg), 10021,
                            // phytonutrients-flavones
                            case "phytonutrients-flavones":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setPhytonutrients_flavones_quantity(data);
                                food.setPhytonutrients_flavones_nutr_no(nutr_no);
                                break;

                            // Phytonutrients, Flavonoids (mg), 10026,
                            // phytonutrients-flavonoids
                            case "phytonutrients-flavonoids":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setPhytonutrients_flavonoids_quantity(data);
                                food.setPhytonutrients_flavonoids_nutr_no(nutr_no);
                                break;

                            // Phytonutrients, Flavonols (mg), 10020,
                            // phytonutrients-flavonols
                            case "phytonutrients-flavonols":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setPhytonutrients_flavonols_quantity(data);
                                food.setPhytonutrients_flavonols_nutr_no(nutr_no);
                                break;

                            // Phytonutrients, Isoflavones (mg), 10025,
                            // phytonutrients-isoflavones
                            case "phytonutrients-isoflavones":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setPhytonutrients_isoflavones_quantity(data);
                                food.setPhytonutrients_isoflavones_nutr_no(nutr_no);
                                break;

                            // Phytonutrients, Lutein + zeaxanthin (µg),
                            // 338,
                            case "phytonutrients-lutein_zeaxanthin":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setPhytonutrients_lutein_zeaxanthin_quantity(data);
                                food.setPhytonutrients_lutein_zeaxanthin_nutr_no(nutr_no);
                                break;

                            // Phytonutrients, Lycopene (µg), 337,
                            // phytonutrients-lycopene
                            case "phytonutrients-lycopene":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setPhytonutrients_lycopene_quantity(data);
                                food.setPhytonutrients_lycopene_nutr_no(nutr_no);
                                break;

                            // Phytonutrients, Phytosterols (mg), 636,
                            // phytonutrients-phytosterols
                            case "phytonutrients-phytosterols":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setPhytonutrients_phytosterols_quantity(data);
                                food.setPhytonutrients_phytosterols_nutr_no(nutr_no);
                                break;

                            // Phytonutrients, Theobromine (mg), 263,
                            // phytonutrients-theobromine
                            case "phytonutrients-theobromine":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setPhytonutrients_theobromine_quantity(data);
                                food.setPhytonutrients_theobromine_nutr_no(nutr_no);
                                break;

                            // Phytonutrients, Tocopherol, gamma (mg), 342,
                            // phytonutrients-theobromine
                            case "phytonutrients-gamma_tocopherol":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setPhytonutrients_gamma_tocopherol_quantity(data);
                                food.setPhytonutrients_gamma_tocopherol_nutr_no(nutr_no);
                                break;

                            // ** Protein **
                            // Protein, Complete Protein (g), 10001,
                            // protein-complete
                            case "protein-complete":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setProtein_complete_quantity(data);
                                food.setProtein_complete_nutr_no(nutr_no);
                                break;

                            // Protein, Total Protein (g), 203,
                            // protein-total
                            case "protein-total":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setProtein_total_quantity(data);
                                food.setProtein_total_nutr_no(nutr_no);
                                break;

                            // ** Vitamins **
                            // Vitamins, A, RAE (µg), 320,
                            // vitamins-vitamin_a
                            case "vitamins-vitamin_a":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setVitamins_vitamin_a_quantity(data);
                                food.setVitamins_vitamin_a_nutr_no(nutr_no);
                                break;

                            // Vitamins, B12 (µg), 418, vitamins-vitamin_b12
                            case "vitamins-vitamin_b12":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setVitamins_vitamin_b12_quantity(data);
                                food.setVitamins_vitamin_b12_nutr_no(nutr_no);
                                break;

                            // Vitamins, B6 (mg), 415, vitamins-vitamin_b6
                            case "vitamins-vitamin_b6":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setVitamins_vitamin_b6_quantity(data);
                                food.setVitamins_vitamin_b6_nutr_no(nutr_no);
                                break;

                            // Vitamins, C (mg), 401, vitamins-vitamin_c
                            case "vitamins-vitamin_c":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setVitamins_vitamin_c_quantity(data);
                                food.setVitamins_vitamin_c_nutr_no(nutr_no);
                                break;

                            // Vitamins, Choline (mg), 421, vitamins-choline
                            case "vitamins-choline":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setVitamins_choline_quantity(data);
                                food.setVitamins_choline_nutr_no(nutr_no);
                                break;

                            // Vitamins, D (µg), 328, vitamins-vitamin_d
                            case "vitamins-vitamin_d":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setVitamins_vitamin_d_quantity(data);
                                food.setVitamins_vitamin_d_nutr_no(nutr_no);
                                break;

                            // Vitamins, E (mg), 323, vitamins-vitamin_e
                            case "vitamins-vitamin_e":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setVitamins_vitamin_e_quantity(data);
                                food.setVitamins_vitamin_e_nutr_no(nutr_no);
                                break;

                            // Vitamins, Folate, DFE (µg), 435,
                            // vitamins-folate
                            case "vitamins-folate":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setVitamins_folate_quantity(data);
                                food.setVitamins_folate_nutr_no(nutr_no);
                                break;

                            // Vitamins, K (µg), 430, vitamins-vitamin_k
                            case "vitamins-vitamin_k":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setVitamins_vitamin_k_quantity(data);
                                food.setVitamins_vitamin_k_nutr_no(nutr_no);
                                break;

                            // Vitamins, Niacin (mg), 406, vitamins-niacin
                            case "vitamins-niacin":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setVitamins_niacin_quantity(data);
                                food.setVitamins_niacin_nutr_no(nutr_no);
                                break;

                            // Vitamins, Pantothenic Acid (mg), 410,
                            // vitamins-pantothenic_acid
                            case "vitamins-pantothenic_acid":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setVitamins_pantothenic_acid_quantity(data);
                                food.setVitamins_pantothenic_acid_nutr_no(nutr_no);
                                break;

                            // Vitamins, Riboflavin (mg), 405,
                            // vitamins-riboflavin
                            case "vitamins-riboflavin":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setVitamins_riboflavin_quantity(data);
                                food.setVitamins_riboflavin_nutr_no(nutr_no);
                                break;

                            // Vitamins, Thiamin (mg), 404, vitamins-thiamin
                            case "vitamins-thiamin":
                                nutr_no = startElement
                                        .getAttributeByName(attribute)
                                        .getValue();
                                food.setVitamins_thiamin_quantity(data);
                                food.setVitamins_thiamin_nutr_no(nutr_no);
                                break;
                        }
                    }
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    endEvent = event.asEndElement().getName().getLocalPart();
                    switch (endEvent) {
                        case "mix":
                            try {

                                Future<Boolean> task = BackgroundExec.submit(new InsertMixTask(mix));
                                created = task.get();

                                if (!created) {

                                    Message.showMessage("Mix already exists.");
                                    return new MixDO("");
                                }

                            } catch (Exception e) {

                                LoggerImpl.INSTANCE.logProblem(e);
                            }
                            break;

                        case "food":
                            try {

                                String foodId = food.getFoodId();
                                String checkSum = food.getCheckSum();

                                if (!foodId.equals(checkSum)) {

                                    StringBuilder sb = new StringBuilder();
                                    sb.append(
                                                    " ---------------------------------------------------------------------------------- ")
                                            .append("\n");
                                    sb.append("        ***** IMPORT FILE HAS BEEN ALTERED *****         ")
                                            .append("\n");
                                    sb.append(" ").append(path).append("\n");
                                    sb.append(" ")
                                            .append(food.getFoodName())
                                            .append(": Nutrient values were modified.")
                                            .append("\n");
                                    sb.append(" ")
                                            .append("Original id: ")
                                            .append(foodId)
                                            .append("\n");
                                    sb.append(" ")
                                            .append("     New id: ")
                                            .append(checkSum)
                                            .append("\n");
                                    sb.append(
                                                    " ----------------------------------------------------------------------------------- ")
                                            .append("\n");
                                    System.out.println(sb.toString());
                                }

                                new FoodCreator(food).create();
                                Future<Boolean> task =
                                        BackgroundExec.submit(new InsertMixFoodTask(mix.getMixid(), checkSum));
                                task.get();

                            } catch (Exception e) {

                                LoggerImpl.INSTANCE.logProblem(e);
                            }
                            break;

                        case "category":
                            if (created) {

                                food.addCategory(category);
                            }
                            break;

                        case "nutrient_quantity":
                            if (created) {

                                try {

                                    Future<Boolean> task =
                                            BackgroundExec.submit(new MergeNutrientConstraintTask(
                                                    mix.getMixid(), nutrient_constraint.getNutrientid(),
                                                    nutrient_constraint.getRelationshipid(),
                                                            nutrient_constraint.getB()));
                                    task.get();

                                } catch (Exception e) {

                                    LoggerImpl.INSTANCE.logProblem(e);
                                }

                                break;
                            }
                        case "food_quantity":
                            if (created) {

                                try {

                                    Future<Boolean> task = BackgroundExec.submit(new MergeFoodConstraintTask(
                                            mix.getMixid(),
                                            food_nutrient_constraint.getFoodid(),
                                            food_nutrient_constraint.getNutrientid(),
                                            food_nutrient_constraint.getRelationshipid(),
                                            food_nutrient_constraint.getB()));
                                    task.get();

                                } catch (Exception e) {

                                    LoggerImpl.INSTANCE.logProblem(e);
                                }

                                break;
                            }
                        case "food_ratio":
                            if (created) {

                                try {

                                    Future<Boolean> task = BackgroundExec.submit(new MergeFoodRatioConstraintTask(
                                            mix.getMixid(),
                                            food_nutrient_ratio_constraint.getFoodid_a(),
                                            food_nutrient_ratio_constraint.getNutrientid_a(),
                                            food_nutrient_ratio_constraint.getFoodid_b(),
                                            food_nutrient_ratio_constraint.getNutrientid_b(),
                                            food_nutrient_ratio_constraint.getRelationshipid(),
                                            food_nutrient_ratio_constraint.getA(),
                                            food_nutrient_ratio_constraint.getB()));
                                    task.get();

                                } catch (Exception e) {

                                    LoggerImpl.INSTANCE.logProblem(e);
                                }

                                break;
                            }
                        case "nutrient_ratio":
                            if (created) {

                                try {

                                    Future<Boolean> task = BackgroundExec.submit(new MergeNutrientRatioConstraintTask(
                                            mix.getMixid(),
                                            nutrient_ratio_constraint.getNutrientid_a(),
                                            nutrient_ratio_constraint.getNutrientid_b(),
                                            nutrient_ratio_constraint.getRelationshipid(),
                                            nutrient_ratio_constraint.getA(),
                                            nutrient_ratio_constraint.getB()));
                                    task.get();

                                } catch (Exception e) {

                                    LoggerImpl.INSTANCE.logProblem(e);
                                }

                                break;
                            }
                        case "meal":
                            if (created) {

                                try {

                                    Future<Boolean> task = BackgroundExec.submit(new InsertMealTask(
                                            meal.getMixid(), meal.getMealid(), meal.getName(), meal.getMealOrder()));
                                    task.get();

                                } catch (Exception e) {

                                    LoggerImpl.INSTANCE.logProblem(e);
                                }
                            }
                            break;

                        case "meal_food_portion":
                            if (created) {

                                try {

                                    Future<Boolean> task = BackgroundExec.submit(new InsertFoodPortionTask(
                                            portion.getMixid(),
                                            portion.getMealid(),
                                            portion.getFoodid(),
                                            portion.getPct(),
                                            portion.getExpectedwt(),
                                            portion.getActualwt()));
                                    task.get();

                                } catch (Exception e) {

                                    LoggerImpl.INSTANCE.logProblem(e);
                                }
                            }
                            break;

                        case "group":
                            if (created) {

                                try {
                                    Future<String> task = BackgroundExec.submit(
                                            new InsertGroupTask(group.getMixid(), group.getGroupid(), group.getName()));
                                    task.get();

                                } catch (Exception e) {

                                    LoggerImpl.INSTANCE.logProblem(e);
                                }
                            }
                            break;

                        case "groupfood":
                            if (created) {

                                try {
                                    Future<String> task = BackgroundExec.submit(new InsertGroupFoodTask(
                                            groupfood.getMixid(), groupfood.getGroupid(), groupfood.getFoodid()));
                                    task.get();

                                } catch (Exception e) {

                                    LoggerImpl.INSTANCE.logProblem(e);
                                }
                            }
                            break;

                        case "group_quantity":
                            if (created) {

                                try {

                                    Future<Boolean> task = BackgroundExec.submit(new MergeGroupConstraintTask(
                                            mix.getMixid(),
                                            group_constraint.getGroupid(),
                                            group_constraint.getNutrientid(),
                                            group_constraint.getRelationshipid(),
                                            group_constraint.getB()));
                                    task.get();

                                } catch (Exception e) {

                                    LoggerImpl.INSTANCE.logProblem(e);
                                }

                                break;
                            }
                    }
                    break;
            }
        }

        try {

            reader.close();

        } catch (IOException e) {

            LoggerImpl.INSTANCE.logProblem(e);
        }

        return mix;
    }
}
