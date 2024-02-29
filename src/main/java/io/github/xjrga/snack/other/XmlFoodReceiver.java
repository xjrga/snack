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
package io.github.xjrga.snack.other;

import io.github.xjrga.snack.database.DbLink;
import io.github.xjrga.snack.dataobject.Xml_food;
import io.github.xjrga.snack.gui.Message;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
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
public class XmlFoodReceiver {
  private final XMLInputFactory inputFactory;
  private XMLEventReader eventReader;
  private String start_event;
  private String end_event;
  private String main_event;
  private final DbLink dbLink;

  /** Constructs Xml_receive class */
  public XmlFoodReceiver(DbLink dbLink) {
    inputFactory = XMLInputFactory.newInstance();
    inputFactory.setProperty("javax.xml.stream.isCoalescing", true);
    this.dbLink = dbLink;
  }

  public boolean import_snack_data(String path) {
    boolean was_food_inserted = false;
    StringBuilder exceptionMsgBuild = new StringBuilder();
    File schemaFile = new File("resources/schemas/food_v2.xsd");
    Source xmlFile = new StreamSource(new File(path));
    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    try {
      Schema schema = schemaFactory.newSchema(schemaFile);
      Validator validator = schema.newValidator();
      validator.validate(xmlFile);
      File file = new File(path);
      BufferedReader reader = new BufferedReader(new FileReader(file));
      eventReader = inputFactory.createXMLEventReader(reader);
      Xml_food food = null;
      while (eventReader.hasNext()) {
        XMLEvent event = eventReader.nextEvent();
        switch (event.getEventType()) {
          case XMLEvent.START_ELEMENT:
            start_event = event.asStartElement().getName().getLocalPart();
            switch (start_event) {
              case "food":
                // System.out.println( "Start food" );
                food = new Xml_food();
                main_event = start_event;
                break;
            }
            break;
          case XMLEvent.CHARACTERS:
            String data = event.asCharacters().getData().strip();
            if (!data.isBlank()) {
              switch (start_event) {
                case "food-name":
                  switch (main_event) {
                    case "food":
                      food.setName(data);
                      break;
                  }
                  break;
                case "food-id":
                  switch (main_event) {
                    case "food":
                      food.setFoodid(data);
                      break;
                  }
                  break;
                  // food
                case "other-alcohol":
                  food.setAlcohol(Double.valueOf(data));
                  break;
                case "minerals-calcium":
                  food.setCalcium(Double.valueOf(data));
                  break;
                case "carbohydrates-carbs_by_diff":
                  food.setCarbohydrate_by_difference(Double.valueOf(data));
                  break;
                case "fats-cholesterol":
                  food.setCholesterol(Double.valueOf(data));
                  break;
                case "vitamins-choline":
                  food.setCholine(Double.valueOf(data));
                  break;
                case "protein-complete":
                  food.setComplete_protein(Double.valueOf(data));
                  break;
                case "minerals-copper":
                  food.setCopper(Double.valueOf(data));
                  break;
                case "other-cost":
                  food.setCost(Double.valueOf(data));
                  break;
                case "fats-dha":
                  food.setDha(Double.valueOf(data));
                  break;
                case "energy-gross":
                  food.setEnergy_gross(Double.valueOf(data));
                  break;
                case "fats-epa":
                  food.setEpa(Double.valueOf(data));
                  break;
                case "fats-total":
                  food.setFat(Double.valueOf(data));
                  break;
                case "carbohydrates-fiber":
                  food.setFiber(Double.valueOf(data));
                  break;
                case "vitamins-folate":
                  food.setFolate(Double.valueOf(data));
                  break;
                case "minerals-iron":
                  food.setIron(Double.valueOf(data));
                  break;
                case "fats-linoleic":
                  food.setLinoleic(Double.valueOf(data));
                  break;
                case "fats-linolenic":
                  food.setLinolenic(Double.valueOf(data));
                  break;
                case "minerals-magnesium":
                  food.setMagnesium(Double.valueOf(data));
                  break;
                case "minerals-manganese":
                  food.setManganese(Double.valueOf(data));
                  break;
                case "fats-monounsaturated":
                  food.setMufa(Double.valueOf(data));
                  break;
                case "vitamins-niacin":
                  food.setNiacin(Double.valueOf(data));
                  break;
                case "vitamins-pantothenic_acid":
                  food.setPantothenic_acid(Double.valueOf(data));
                  break;
                case "minerals-phosphorus":
                  food.setPhosphorus(Double.valueOf(data));
                  break;
                case "minerals-potassium":
                  food.setPotassium(Double.valueOf(data));
                  break;
                case "protein-total":
                  food.setProtein(Double.valueOf(data));
                  break;
                case "fats-polyunsaturated":
                  food.setPufa(Double.valueOf(data));
                  break;
                case "vitamins-riboflavin":
                  food.setRiboflavin(Double.valueOf(data));
                  break;
                case "minerals-selenium":
                  food.setSelenium(Double.valueOf(data));
                  break;
                case "fats-saturated":
                  food.setSfa(Double.valueOf(data));
                  break;
                case "minerals-sodium":
                  food.setSodium(Double.valueOf(data));
                  break;
                case "vitamins-thiamin":
                  food.setThiamin(Double.valueOf(data));
                  break;
                case "vitamins-vitamin_a":
                  food.setVitamin_a(Double.valueOf(data));
                  break;
                case "vitamins-vitamin_b12":
                  food.setVitamin_b12(Double.valueOf(data));
                  break;
                case "vitamins-vitamin_b6":
                  food.setVitamin_b6(Double.valueOf(data));
                  break;
                case "vitamins-vitamin_c":
                  food.setVitamin_c(Double.valueOf(data));
                  break;
                case "vitamins-vitamin_d":
                  food.setVitamin_d(Double.valueOf(data));
                  break;
                case "vitamins-vitamin_e":
                  food.setVitamin_e(Double.valueOf(data));
                  break;
                case "vitamins-vitamin_k":
                  food.setVitamin_k(Double.valueOf(data));
                  break;
                case "other-water":
                  food.setWater(Double.valueOf(data));
                  break;
                case "other-weight":
                  food.setWeight(Double.valueOf(data));
                  break;
                case "minerals-zinc":
                  food.setZinc(Double.valueOf(data));
                  break;
                case "carbohydrates-glycemicindex":
                  food.setGlycemicindex(Double.valueOf(data));
                  break;
                case "fats-lauric":
                  food.setLauric(Double.valueOf(data));
                  break;
                case "fats-myristic":
                  food.setMyristic(Double.valueOf(data));
                  break;
                case "fats-palmitic":
                  food.setPalmitic(Double.valueOf(data));
                  break;
                case "fats-stearic":
                  food.setStearic(Double.valueOf(data));
                  break;
              }
            }
            break;
          case XMLEvent.END_ELEMENT:
            end_event = event.asEndElement().getName().getLocalPart();
            switch (end_event) {
              case "food":
                was_food_inserted = dbLink.snack_food_insertfood(food.getFoodid(), food.getName());
                if (was_food_inserted) {
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.ALCOHOL.getNumber(), food.getAlcohol());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.CALCIUM.getNumber(), food.getCalcium());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(),
                      Nutrient.CARBOHYDRATEBYDIFFERENCE.getNumber(),
                      food.getCarbohydrate_by_difference());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.CHOLESTEROL.getNumber(), food.getCholesterol());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.CHOLINE.getNumber(), food.getCholine());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(),
                      Nutrient.COMPLETEPROTEIN.getNumber(),
                      food.getComplete_protein());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.COPPER.getNumber(), food.getCopper());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.COST.getNumber(), food.getCost());
                  dbLink.FoodFact_Merge(food.getFoodid(), Nutrient.DHA.getNumber(), food.getDha());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.ENERGYGROSS.getNumber(), food.getEnergy_gross());
                  dbLink.FoodFact_Merge(food.getFoodid(), Nutrient.EPA.getNumber(), food.getEpa());
                  dbLink.FoodFact_Merge(food.getFoodid(), Nutrient.FAT.getNumber(), food.getFat());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.FIBER.getNumber(), food.getFiber());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.FOLATE.getNumber(), food.getFolate());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.IRON.getNumber(), food.getIron());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.LINOLEIC.getNumber(), food.getLinoleic());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.LINOLENIC.getNumber(), food.getLinolenic());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.MAGNESIUM.getNumber(), food.getMagnesium());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.MANGANESE.getNumber(), food.getManganese());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.MUFA.getNumber(), food.getMufa());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.NIACIN.getNumber(), food.getNiacin());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(),
                      Nutrient.PANTOTHENICACID.getNumber(),
                      food.getPantothenic_acid());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.PHOSPHORUS.getNumber(), food.getPhosphorus());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.POTASSIUM.getNumber(), food.getPotassium());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.PROTEIN.getNumber(), food.getProtein());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.PUFA.getNumber(), food.getPufa());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.RIBOFLAVIN.getNumber(), food.getRiboflavin());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.SELENIUM.getNumber(), food.getSelenium());
                  dbLink.FoodFact_Merge(food.getFoodid(), Nutrient.SFA.getNumber(), food.getSfa());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.SODIUM.getNumber(), food.getSodium());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.THIAMIN.getNumber(), food.getThiamin());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.VITAMINA.getNumber(), food.getVitamin_a());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.VITAMINB12.getNumber(), food.getVitamin_b12());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.VITAMINB6.getNumber(), food.getVitamin_b6());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.VITAMINC.getNumber(), food.getVitamin_c());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.VITAMIND.getNumber(), food.getVitamin_d());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.VITAMINE.getNumber(), food.getVitamin_e());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.VITAMINK.getNumber(), food.getVitamin_k());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.WATER.getNumber(), food.getWater());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.WEIGHT.getNumber(), food.getWeight());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.ZINC.getNumber(), food.getZinc());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.LAURIC.getNumber(), food.getLauric());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.MYRISTIC.getNumber(), food.getMyristic());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.PALMITIC.getNumber(), food.getPalmitic());
                  dbLink.FoodFact_Merge(
                      food.getFoodid(), Nutrient.STEARIC.getNumber(), food.getStearic());
                  dbLink.GlycemicIndex_Merge(food.getFoodid(), food.getGlycemicindex());
                  dbLink.foodfact_calculated_quantities_update(food.getFoodid());
                  dbLink.CategoryLink_Insert("5000", food.getFoodid());
                } else {
                  StringBuilder sb = new StringBuilder();
                  sb.append("Food item already exists.");
                  sb.append("\n");
                  sb.append("-------------------------");
                  sb.append("\n");
                  sb.append("Foodid: ");
                  sb.append(food.getFoodid());
                  sb.append("\n");
                  sb.append("Name: ");
                  sb.append(food.getName());
                  sb.append("\n");
                  Message.showMessagePadW510H150("Message", sb.toString());
                }
                break;
            }
            break;
        }
      }
      reader.close();
    } catch (SAXException e) {
      exceptionMsgBuild.append(xmlFile.getSystemId());
      exceptionMsgBuild.append(" is NOT valid");
      exceptionMsgBuild.append("\n\n");
      exceptionMsgBuild.append("Reason: ");
      exceptionMsgBuild.append(e);
    } catch (IOException | XMLStreamException e) {
      exceptionMsgBuild.append(e);
    } finally {
      if (exceptionMsgBuild.length() > 0) {
        Message.showMessagePadW510H150("Message", exceptionMsgBuild.toString());
      }
    }
    return was_food_inserted;
  }
}
