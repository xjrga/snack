package io.github.xjrga.snack.sql;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.other.Nutrient;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FoodSelectDetails implements SqlCall<Map<String, Object>> {

  private final Connection connection;

  public FoodSelectDetails() {
    connection = Connect.getInstance().getConnection();
  }

  @Override
  public List<Map<String, Object>> execute() {
    throw new UnsupportedOperationException("Not supported.");
  }

  @Override
  public List<Map<String, Object>> execute(Integer precision) {
    LinkedList<Map<String, Object>> list = new LinkedList<>();
    try (CallableStatement proc =
        connection.prepareCall("{CALL public.Food_Select_Details( ? )}")) {
      proc.setInt(1, precision);
      ResultSet rs = proc.executeQuery();
      while (rs.next()) {
        Map<String, Object> row = new HashMap<>();
        row.put("Name", rs.getObject(1));
        row.put(Nutrient.WEIGHT.getLabel(), rs.getObject(2));
        row.put(Nutrient.ENERGYGROSS.getLabel(), rs.getObject(3));
        row.put(Nutrient.ENERGYDIGESTIBLE.getLabel(), rs.getObject(4));
        row.put(Nutrient.ENERGYCARBOHYDRATE.getLabel(), rs.getObject(5));
        row.put(Nutrient.ENERGYPROTEIN.getLabel(), rs.getObject(6));
        row.put(Nutrient.ENERGYFAT.getLabel(), rs.getObject(7));
        row.put(Nutrient.ENERGYALCOHOL.getLabel(), rs.getObject(8));
        row.put(Nutrient.ENERGYFATCARBOHYDRATE.getLabel(), rs.getObject(9));
        row.put(Nutrient.FAT.getLabel(), rs.getObject(10));
        row.put(Nutrient.DIGESTIBLECARBOHYDRATE.getLabel(), rs.getObject(11));
        row.put(Nutrient.PROTEIN.getLabel(), rs.getObject(12));
        row.put(Nutrient.ALCOHOL.getLabel(), rs.getObject(13));
        row.put(Nutrient.COMPLETEPROTEIN.getLabel(), rs.getObject(14));
        row.put(Nutrient.CARBOHYDRATEBYDIFFERENCE.getLabel(), rs.getObject(15));
        row.put(Nutrient.FIBER.getLabel(), rs.getObject(16));
        row.put(Nutrient.CALCIUM.getLabel(), rs.getObject(17));
        row.put(Nutrient.IRON.getLabel(), rs.getObject(18));
        row.put(Nutrient.MAGNESIUM.getLabel(), rs.getObject(19));
        row.put(Nutrient.PHOSPHORUS.getLabel(), rs.getObject(20));
        row.put(Nutrient.POTASSIUM.getLabel(), rs.getObject(21));
        row.put(Nutrient.SODIUM.getLabel(), rs.getObject(22));
        row.put(Nutrient.ZINC.getLabel(), rs.getObject(23));
        row.put(Nutrient.COPPER.getLabel(), rs.getObject(24));
        row.put(Nutrient.MANGANESE.getLabel(), rs.getObject(25));
        row.put(Nutrient.SELENIUM.getLabel(), rs.getObject(26));
        row.put(Nutrient.VITAMINA.getLabel(), rs.getObject(27));
        row.put(Nutrient.VITAMINE.getLabel(), rs.getObject(28));
        row.put(Nutrient.VITAMIND.getLabel(), rs.getObject(29));
        row.put(Nutrient.VITAMINC.getLabel(), rs.getObject(30));
        row.put(Nutrient.THIAMIN.getLabel(), rs.getObject(31));
        row.put(Nutrient.RIBOFLAVIN.getLabel(), rs.getObject(32));
        row.put(Nutrient.NIACIN.getLabel(), rs.getObject(33));
        row.put(Nutrient.PANTOTHENICACID.getLabel(), rs.getObject(34));
        row.put(Nutrient.VITAMINB6.getLabel(), rs.getObject(35));
        row.put(Nutrient.VITAMINB12.getLabel(), rs.getObject(36));
        row.put(Nutrient.CHOLINE.getLabel(), rs.getObject(37));
        row.put(Nutrient.VITAMINK.getLabel(), rs.getObject(38));
        row.put(Nutrient.FOLATE.getLabel(), rs.getObject(39));
        row.put(Nutrient.CHOLESTEROL.getLabel(), rs.getObject(40));
        row.put(Nutrient.SFA.getLabel(), rs.getObject(41));
        row.put(Nutrient.DHA.getLabel(), rs.getObject(42));
        row.put(Nutrient.EPA.getLabel(), rs.getObject(43));
        row.put(Nutrient.MUFA.getLabel(), rs.getObject(44));
        row.put(Nutrient.PUFA.getLabel(), rs.getObject(45));
        row.put(Nutrient.LINOLEIC.getLabel(), rs.getObject(46));
        row.put(Nutrient.LINOLENIC.getLabel(), rs.getObject(47));
        row.put(Nutrient.LAURIC.getLabel(), rs.getObject(48));
        row.put(Nutrient.MYRISTIC.getLabel(), rs.getObject(49));
        row.put(Nutrient.PALMITIC.getLabel(), rs.getObject(50));
        row.put(Nutrient.STEARIC.getLabel(), rs.getObject(51));
        row.put(Nutrient.HCSFA.getLabel(), rs.getObject(52));
        row.put(Nutrient.GLYCEMICLOAD.getLabel(), rs.getObject(53));
        row.put(Nutrient.WATER.getLabel(), rs.getObject(54));
        row.put(Nutrient.COST.getLabel(), rs.getObject(55));
        row.put("FoodId", rs.getObject(56));
        list.add(row);
      }
    } catch (SQLException e) {
    }
    return list;
  }
}
