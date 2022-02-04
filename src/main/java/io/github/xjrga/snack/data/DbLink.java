package io.github.xjrga.snack.data;

import io.github.xjrga.snack.dataobject.FoodDataObject;
import io.github.xjrga.snack.dataobject.FoodFactSelectForCheckCoefficientsDataObject;
import io.github.xjrga.snack.dataobject.FoodFactSelectForDataInputDataObject;
import io.github.xjrga.snack.other.Log;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DbLink {

    private final Connection connection;

    public DbLink() {
        connection = Connect.getInstance().getConnection();
    }

    public List<Map<String, Object>> Food_Select_All() throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.Food_Select_All()}");
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("CATEGORY", rs.getObject(1));
            row.put("FOODID", rs.getObject(2));
            row.put("FOOD", rs.getObject(3));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Food_Select_All_2() throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.Food_Select_All_2()}");
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("FOODID", rs.getObject(1));
            row.put("NAME", rs.getObject(2));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Nutrient_Select_All() throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.Nutrient_Select_All()}");
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("NUTRIENTID", rs.getObject(1));
            row.put("NAME", rs.getObject(2));
            row.put("VISIBLE", rs.getObject(3));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Nutrient_To_Pct_Select() throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.Nutrient_To_Pct_Select()}");
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("NUTRIENTID", rs.getObject(1));
            row.put("NAME", rs.getObject(2));
            row.put("q", rs.getObject(3));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Nutrient_Select_All_Visible() throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.Nutrient_Select_All_Visible()}");
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("NUTRIENTID", rs.getObject(1));
            row.put("NAME", rs.getObject(2));
            row.put("VISIBLE", rs.getObject(3));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> RdaLifeStage_Select_All() throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.RdaLifeStage_Select_All()}");
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("LIFESTAGEID", rs.getObject(1));
            row.put("LABEL", rs.getObject(2));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Relationship_Select_All() throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.Relationship_Select_All()}");
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("RELATIONSHIPID", rs.getObject(1));
            row.put("NAME", rs.getObject(2));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Mix_Select_All() throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.Mix_Select_All()}");
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("MIXID", rs.getObject(1));
            row.put("NAME", rs.getObject(2));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Mix_Select_All_1() throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.Mix_Select_All_1()}");
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("MIXID", rs.getObject(1));
            row.put("NAME", rs.getObject(2));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public Integer Mix_Insert(String Name) throws SQLException {
        Integer ident = null;
        CallableStatement proc = connection.prepareCall("{CALL public.Mix_Insert( ?, ?)}");
        proc.registerOutParameter(1, Types.INTEGER);
        proc.setString(2, Name);
        proc.execute();
        ident = proc.getInt(1);
        return ident;
    }

    public void MixFood_Insert(Integer MixId, String FoodId) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.MixFood_Insert( ?, ? )}");
        proc.setInt(1, MixId);
        proc.setString(2, FoodId);
        proc.execute();
    }

    public List<Map<String, Object>> MixFood_Select_All(Integer mixId) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.MixFood_Select_All(?)}");
        proc.setInt(1, mixId);
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("FOODID", rs.getObject(1));
            row.put("NAME", rs.getObject(2));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public void MixFood_Delete(Integer MixId, String FoodId) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.MixFood_Delete( ?, ? )}");
        proc.setInt(1, MixId);
        proc.setString(2, FoodId);
        proc.execute();
    }

    public void Mix_Delete(Integer MixId) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.Mix_Delete( ? )}");
        proc.setInt(1, MixId);
        proc.execute();
    }

    public void NutrientConstraint_Merge(Integer MixId, String NutrientId, Integer RelationshipId, Double b) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.NutrientConstraint_Merge( ?, ?, ?, ? )}");
        proc.setInt(1, MixId);
        proc.setString(2, NutrientId);
        proc.setInt(3, RelationshipId);
        proc.setDouble(4, b);
        proc.execute();
    }

    public List<Map<String, Object>> NutrientConstraint_Select(Integer MixId) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.NutrientConstraint_Select( ?)}");
        proc.setInt(1, MixId);
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("MIXID", rs.getObject(1));
            row.put("NUTRIENTID", rs.getObject(2));
            row.put("RELATIONSHIPID", rs.getObject(3));
            row.put("NUTRIENT", rs.getObject(4));
            row.put("RELATIONSHIP", rs.getObject(5));
            row.put("B", rs.getObject(6));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public void NutrientConstraint_Delete(Integer MixId, String NutrientId, Integer RelationshipId) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.NutrientConstraint_Delete( ?, ?, ? )}");
        proc.setInt(1, MixId);
        proc.setString(2, NutrientId);
        proc.setInt(3, RelationshipId);
        proc.execute();
    }

    public void FoodNutrientConstraint_Merge(Integer MixId, String FoodId, String NutrientId, Integer RelationshipId, Double b) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.FoodNutrientConstraint_Merge( ?, ?, ?, ?, ? )}");
        proc.setInt(1, MixId);
        proc.setString(2, FoodId);
        proc.setString(3, NutrientId);
        proc.setInt(4, RelationshipId);
        proc.setDouble(5, b);
        proc.execute();
    }

    public List<Map<String, Object>> FoodNutrientConstraint_Select(Integer MixId) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.FoodNutrientConstraint_Select( ?)}");
        proc.setInt(1, MixId);
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("MIXID", rs.getObject(1));
            row.put("FOODID", rs.getObject(2));
            row.put("NUTRIENTID", rs.getObject(3));
            row.put("RELATIONSHIPID", rs.getObject(4));
            row.put("FOOD", rs.getObject(5));
            row.put("NUTRIENT", rs.getObject(6));
            row.put("RELATIONSHIP", rs.getObject(7));
            row.put("B", rs.getObject(8));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public void FoodNutrientConstraint_Delete(Integer MixId, String FoodId, String NutrientId, Integer RelationshipId) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.FoodNutrientConstraint_Delete( ?, ?, ?, ? )}");
        proc.setInt(1, MixId);
        proc.setString(2, FoodId);
        proc.setString(3, NutrientId);
        proc.setInt(4, RelationshipId);
        proc.execute();
    }

    public List<Map<String, Object>> NutrientRatio_Select(Integer MixId) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.NutrientRatio_Select( ?)}");
        proc.setInt(1, MixId);
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("MIXID", rs.getObject(1));
            row.put("NUTRIENT_ID_1", rs.getObject(2));
            row.put("NUTRIENT_ID_2", rs.getObject(3));
            row.put("RELATIONSHIPID", rs.getObject(4));
            row.put("NUTRIENTA", rs.getObject(5));
            row.put("NUTRIENTB", rs.getObject(6));
            row.put("A", rs.getObject(7));
            row.put("B", rs.getObject(8));
            row.put("RELATIONSHIP", rs.getObject(9));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public void NutrientRatio_Merge(Integer MixId, String Nutrient_Id_1, String Nutrient_Id_2, Integer RelationshipId, Double A, Double B) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.NutrientRatio_Merge( ?, ?, ?, ?, ?, ? )}");
        proc.setInt(1, MixId);
        proc.setString(2, Nutrient_Id_1);
        proc.setString(3, Nutrient_Id_2);
        proc.setInt(4, RelationshipId);
        proc.setDouble(5, A);
        proc.setDouble(6, B);
        proc.execute();
    }

    public void NutrientRatio_Delete(Integer MixId, String Nutrient_Id_1, String Nutrient_Id_2, Integer RelationshipId) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.NutrientRatio_Delete( ?, ?, ?, ? )}");
        proc.setInt(1, MixId);
        proc.setString(2, Nutrient_Id_1);
        proc.setString(3, Nutrient_Id_2);
        proc.setInt(4, RelationshipId);
        proc.execute();
    }

    public void FoodNutrientRatio_Merge(Integer MixId, String Food_Id_1, String Nutrient_Id_1, String Food_Id_2, String Nutrient_Id_2, Integer RelationshipId, Double A, Double B) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.FoodNutrientRatio_Merge( ?, ?, ?, ?, ?, ?, ?, ? )}");
        proc.setInt(1, MixId);
        proc.setString(2, Food_Id_1);
        proc.setString(3, Nutrient_Id_1);
        proc.setString(4, Food_Id_2);
        proc.setString(5, Nutrient_Id_2);
        proc.setInt(6, RelationshipId);
        proc.setDouble(7, A);
        proc.setDouble(8, B);
        proc.execute();
    }

    public List<Map<String, Object>> FoodNutrientRatio_Select(Integer MixId) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.FoodNutrientRatio_Select( ?)}");
        proc.setInt(1, MixId);
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("MIXID", rs.getObject(1));
            row.put("FOOD_ID_1", rs.getObject(2));
            row.put("NUTRIENT_ID_1", rs.getObject(3));
            row.put("FOOD_ID_2", rs.getObject(4));
            row.put("NUTRIENT_ID_2", rs.getObject(5));
            row.put("RELATIONSHIPID", rs.getObject(6));
            row.put("FOODA", rs.getObject(7));
            row.put("NUTRIENTA", rs.getObject(8));
            row.put("FOODB", rs.getObject(9));
            row.put("NUTRIENTB", rs.getObject(10));
            row.put("A", rs.getObject(11));
            row.put("B", rs.getObject(12));
            row.put("RELATIONSHIP", rs.getObject(13));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public void FoodNutrientRatio_Delete(Integer MixId, String Food_Id_1, String Nutrient_Id_1, String Food_Id_2, String Nutrient_Id_2, Integer RelationshipId) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.FoodNutrientRatio_Delete( ?, ?, ?, ?, ?, ? )}");
        proc.setInt(1, MixId);
        proc.setString(2, Food_Id_1);
        proc.setString(3, Nutrient_Id_1);
        proc.setString(4, Food_Id_2);
        proc.setString(5, Nutrient_Id_2);
        proc.setInt(6, RelationshipId);
        proc.execute();
    }

    public double[] objective_lhs(Integer MixId) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.objective_lhs(?)}");
        proc.setInt(1, MixId);
        ResultSet rs = proc.executeQuery();
        LinkedList<Double> list = new LinkedList<>();
        while (rs.next()) {
            String foodid = rs.getString(1);
            double c = rs.getDouble(2);
            list.add(c);
        }
        proc.close();
        int size = list.size();
        double[] coefficients = new double[size];
        for (int i = 0; i < size; i++) {
            coefficients[i] = list.get(i).doubleValue();
        }
        return coefficients;
    }

    public List nutrient_rhs(Integer mixid) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.nutrient_rhs(?)}");
        proc.setInt(1, mixid);
        ResultSet rs = proc.executeQuery();
        LinkedList<HashMap<String, Object>> list = new LinkedList<>();
        while (rs.next()) {
            HashMap<String, Object> row = new HashMap();
            //Integer mixid = rs.getString(1);
            String nutrientid = rs.getString(2);
            Integer relationshipid = rs.getInt(3);
            Double b = rs.getDouble(4);
            row.put("NUTRIENTID", nutrientid);
            row.put("RELATIONSHIPID", relationshipid);
            row.put("B", b);
            list.add(row);
        }
        proc.close();
        return list;
    }

    public double[] nutrient_lhs(Integer mixid, String nutrientid, Integer relationshipid) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.nutrient_lhs(?,?,?)}");
        proc.setInt(1, mixid);
        proc.setString(2, nutrientid);
        proc.setInt(3, relationshipid);
        ResultSet rs = proc.executeQuery();
        LinkedList<Double> list = new LinkedList<>();
        while (rs.next()) {
            String foodid = rs.getString(1);
            double c = rs.getDouble(2);
            list.add(c);
        }
        proc.close();
        int size = list.size();
        double[] coefficients = new double[size];
        for (int i = 0; i < size; i++) {
            coefficients[i] = list.get(i).doubleValue();
        }
        return coefficients;
    }

    public List foodnutrient_rhs(Integer mixid) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.foodnutrient_rhs(?)}");
        proc.setInt(1, mixid);
        ResultSet rs = proc.executeQuery();
        LinkedList<HashMap<String, Object>> list = new LinkedList<>();
        while (rs.next()) {
            HashMap<String, Object> row = new HashMap();
            //Integer mixid = rs.getString(1);
            String foodid = rs.getString(2);
            String nutrientid = rs.getString(3);
            Integer relationshipid = rs.getInt(4);
            Double b = rs.getDouble(5);
            row.put("FOODID", foodid);
            row.put("NUTRIENTID", nutrientid);
            row.put("RELATIONSHIPID", relationshipid);
            row.put("B", b);
            list.add(row);
        }
        proc.close();
        return list;
    }

    public double[] foodnutrient_lhs(Integer mixid, String foodid, String nutrientid, Integer relationshipid) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.foodnutrient_lhs(?,?,?,?)}");
        proc.setInt(1, mixid);
        proc.setString(2, foodid);
        proc.setString(3, nutrientid);
        proc.setInt(4, relationshipid);
        ResultSet rs = proc.executeQuery();
        LinkedList<Double> list = new LinkedList<>();
        while (rs.next()) {
            //String foodid = rs.getString(1);
            double c = rs.getDouble(3);
            list.add(c);
        }
        proc.close();
        int size = list.size();
        double[] coefficients = new double[size];
        for (int i = 0; i < size; i++) {
            coefficients[i] = list.get(i).doubleValue();
        }
        return coefficients;
    }

    public List foodnutrientratio_rhs(Integer mixid) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.foodnutrientratio_rhs(?)}");
        proc.setInt(1, mixid);
        ResultSet rs = proc.executeQuery();
        LinkedList<HashMap<String, Object>> list = new LinkedList<>();
        while (rs.next()) {
            HashMap<String, Object> row = new HashMap();
            //Integer mixid = rs.getString(1);
            String food_id_1 = rs.getString(2);
            String nutrient_id_1 = rs.getString(3);
            String food_id_2 = rs.getString(4);
            String nutrient_id_2 = rs.getString(5);
            Integer relationshipid = rs.getInt(6);
            Double b = rs.getDouble(7);
            row.put("FOOD_ID_1", food_id_1);
            row.put("NUTRIENT_ID_1", nutrient_id_1);
            row.put("FOOD_ID_2", food_id_2);
            row.put("NUTRIENT_ID_2", nutrient_id_2);
            row.put("RELATIONSHIPID", relationshipid);
            row.put("B", b);
            list.add(row);
        }
        proc.close();
        return list;
    }

    public double[] foodnutrientratio_lhs(Integer mixid, String foodid1, String nutrientid1, String foodid2, String nutrientid2, Integer relationshipid) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.foodnutrientratio_lhs(?,?,?,?,?,?)}");
        proc.setInt(1, mixid);
        proc.setString(2, foodid1);
        proc.setString(3, nutrientid1);
        proc.setString(4, foodid2);
        proc.setString(5, nutrientid2);
        proc.setInt(6, relationshipid);
        ResultSet rs = proc.executeQuery();
        LinkedList<Double> list = new LinkedList<>();
        while (rs.next()) {
            //String foodid = rs.getString(1);
            double c = rs.getDouble(2);
            list.add(c);
        }
        proc.close();
        int size = list.size();
        double[] coefficients = new double[size];
        for (int i = 0; i < size; i++) {
            coefficients[i] = list.get(i).doubleValue();
        }
        return coefficients;
    }

    public List nutrientratio_rhs(Integer mixid) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.nutrientratio_rhs(?)}");
        proc.setInt(1, mixid);
        ResultSet rs = proc.executeQuery();
        LinkedList<HashMap<String, Object>> list = new LinkedList<>();
        while (rs.next()) {
            HashMap<String, Object> row = new HashMap();
            //Integer mixid = rs.getString(1);
            String nutrient_id_1 = rs.getString(2);
            String nutrient_id_2 = rs.getString(3);
            Integer relationshipid = rs.getInt(4);
            Double b = rs.getDouble(5);
            row.put("NUTRIENT_ID_1", nutrient_id_1);
            row.put("NUTRIENT_ID_2", nutrient_id_2);
            row.put("RELATIONSHIPID", relationshipid);
            row.put("B", b);
            list.add(row);
        }
        proc.close();
        return list;
    }

    public double[] nutrientratio_lhs(Integer mixid, String nutrientid1, String nutrientid2, Integer relationshipid) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.nutrientratio_lhs(?,?,?,?)}");
        proc.setInt(1, mixid);
        proc.setString(2, nutrientid1);
        proc.setString(3, nutrientid2);
        proc.setInt(4, relationshipid);
        ResultSet rs = proc.executeQuery();
        LinkedList<Double> list = new LinkedList<>();
        while (rs.next()) {
            //String foodid = rs.getString(1);
            double c = rs.getDouble(2);
            list.add(c);
        }
        proc.close();
        int size = list.size();
        double[] coefficients = new double[size];
        for (int i = 0; i < size; i++) {
            coefficients[i] = list.get(i).doubleValue();
        }
        return coefficients;
    }

    public List<Map<String, Object>> MixFood_Select(Integer MixId) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.MixFood_Select( ? )}");
        proc.setInt(1, MixId);
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("MIXID", rs.getObject(1));
            row.put("FOODID", rs.getObject(2));
            row.put("X", rs.getObject(3));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public void MixFood_Update(Integer MixId, String FoodId, Double x) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.MixFood_Update( ?, ?, ? )}");
        proc.setInt(1, MixId);
        proc.setString(2, FoodId);
        proc.setDouble(3, x);
        proc.execute();
    }

    public void Mix_Update_Name(Integer MixId, String Name) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.Mix_Update_Name( ?, ?)}");
        proc.setInt(1, MixId);
        proc.setString(2, Name);
        proc.execute();
    }

    public void Mix_Update_NutrientId(Integer MixId, String NutrientId) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.Mix_Update_NutrientId( ?, ?)}");
        proc.setInt(1, MixId);
        proc.setString(2, NutrientId);
        proc.execute();
    }

    public void Mix_Update_Other(Integer MixId, String Model, String Note) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.Mix_Update_Other( ?, ?, ?)}");
        proc.setInt(1, MixId);
        proc.setString(2, Model);
        proc.setString(3, Note);
        proc.execute();
    }

    public List<Map<String, Object>> Mix_Select_Other(Integer MixId) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.Mix_Select_Other( ? )}");
        proc.setInt(1, MixId);
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("MIXID", rs.getObject(1));
            row.put("NUTRIENTID", rs.getObject(2));
            row.put("MODEL", rs.getObject(3));
            row.put("NOTE", rs.getObject(4));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> MixResult_Select(Integer MixId, Integer Precision) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.MixResult_Select(?,?)}");
        proc.setInt(1, MixId);
        proc.setInt(2, Precision);
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("MixId", rs.getObject(1));
            row.put("FoodId", rs.getObject(2));
            row.put("Name", rs.getObject(3));
            //
            row.put(Nutrient.WEIGHT.getLabel(), rs.getObject(4));
            row.put(Nutrient.COMPLETEPROTEIN.getLabel(), rs.getObject(5));
            row.put(Nutrient.DIGESTIBLECARBOHYDRATE.getLabel(), rs.getObject(6));
            row.put(Nutrient.COST.getLabel(), rs.getObject(7));
            row.put(Nutrient.PROTEIN.getLabel(), rs.getObject(8));
            row.put(Nutrient.FAT.getLabel(), rs.getObject(9));
            row.put(Nutrient.CARBOHYDRATEBYDIFFERENCE.getLabel(), rs.getObject(10));
            row.put(Nutrient.ENERGYGROSS.getLabel(), rs.getObject(11));
            row.put(Nutrient.ALCOHOL.getLabel(), rs.getObject(12));
            row.put(Nutrient.WATER.getLabel(), rs.getObject(13));
            row.put(Nutrient.FIBER.getLabel(), rs.getObject(14));
            row.put(Nutrient.CALCIUM.getLabel(), rs.getObject(15));
            row.put(Nutrient.IRON.getLabel(), rs.getObject(16));
            row.put(Nutrient.MAGNESIUM.getLabel(), rs.getObject(17));
            row.put(Nutrient.PHOSPHORUS.getLabel(), rs.getObject(18));
            row.put(Nutrient.POTASSIUM.getLabel(), rs.getObject(19));
            row.put(Nutrient.SODIUM.getLabel(), rs.getObject(20));
            row.put(Nutrient.ZINC.getLabel(), rs.getObject(21));
            row.put(Nutrient.COPPER.getLabel(), rs.getObject(22));
            row.put(Nutrient.FLUORIDE.getLabel(), rs.getObject(23));
            row.put(Nutrient.MANGANESE.getLabel(), rs.getObject(24));
            row.put(Nutrient.SELENIUM.getLabel(), rs.getObject(25));
            row.put(Nutrient.VITAMINA.getLabel(), rs.getObject(26));
            row.put(Nutrient.VITAMINE.getLabel(), rs.getObject(27));
            row.put(Nutrient.VITAMIND.getLabel(), rs.getObject(28));
            row.put(Nutrient.VITAMINC.getLabel(), rs.getObject(29));
            row.put(Nutrient.THIAMIN.getLabel(), rs.getObject(30));
            row.put(Nutrient.RIBOFLAVIN.getLabel(), rs.getObject(31));
            row.put(Nutrient.NIACIN.getLabel(), rs.getObject(32));
            row.put(Nutrient.PANTOTHENIC.getLabel(), rs.getObject(33));
            row.put(Nutrient.VITAMINB6.getLabel(), rs.getObject(34));
            row.put(Nutrient.VITAMINB12.getLabel(), rs.getObject(35));
            row.put(Nutrient.CHOLINE.getLabel(), rs.getObject(36));
            row.put(Nutrient.VITAMINK.getLabel(), rs.getObject(37));
            row.put(Nutrient.FOLATE.getLabel(), rs.getObject(38));
            row.put(Nutrient.CHOLESTEROL.getLabel(), rs.getObject(39));
            row.put(Nutrient.SATURATED.getLabel(), rs.getObject(40));
            row.put(Nutrient.DHA.getLabel(), rs.getObject(41));
            row.put(Nutrient.EPA.getLabel(), rs.getObject(42));
            row.put(Nutrient.MONOUNSATURATED.getLabel(), rs.getObject(43));
            row.put(Nutrient.POLYUNSATURATED.getLabel(), rs.getObject(44));
            row.put(Nutrient.LINOLEIC.getLabel(), rs.getObject(45));
            row.put(Nutrient.ALPHALINOLENIC.getLabel(), rs.getObject(46));
            row.put(Nutrient.GLYCEMICLOAD.getLabel(), rs.getObject(47));
            row.put(Nutrient.ENERGYDIGESTIBLE.getLabel(), rs.getObject(48));            
            row.put(Nutrient.ENERGYCARBOHYDRATE.getLabel(), rs.getObject(49));
            row.put(Nutrient.ENERGYPROTEIN.getLabel(), rs.getObject(50));
            row.put(Nutrient.ENERGYFAT.getLabel(), rs.getObject(51));
            row.put(Nutrient.ENERGYALCOHOL.getLabel(), rs.getObject(52));
            //
            list.add(row);
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Food_Select_Details(Integer Precision) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.Food_Select_Details(?)}");
        proc.setInt(1, Precision);
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
            row.put(Nutrient.FAT.getLabel(), rs.getObject(9));
            row.put(Nutrient.DIGESTIBLECARBOHYDRATE.getLabel(), rs.getObject(10));
            row.put(Nutrient.PROTEIN.getLabel(), rs.getObject(11));
            row.put(Nutrient.ALCOHOL.getLabel(), rs.getObject(12));
            row.put(Nutrient.COMPLETEPROTEIN.getLabel(), rs.getObject(13));
            row.put(Nutrient.CARBOHYDRATEBYDIFFERENCE.getLabel(), rs.getObject(14));
            row.put(Nutrient.FIBER.getLabel(), rs.getObject(15));
            row.put(Nutrient.CALCIUM.getLabel(), rs.getObject(16));
            row.put(Nutrient.IRON.getLabel(), rs.getObject(17));
            row.put(Nutrient.MAGNESIUM.getLabel(), rs.getObject(18));
            row.put(Nutrient.PHOSPHORUS.getLabel(), rs.getObject(19));
            row.put(Nutrient.POTASSIUM.getLabel(), rs.getObject(20));
            row.put(Nutrient.SODIUM.getLabel(), rs.getObject(21));
            row.put(Nutrient.ZINC.getLabel(), rs.getObject(22));
            row.put(Nutrient.COPPER.getLabel(), rs.getObject(23));
            row.put(Nutrient.FLUORIDE.getLabel(), rs.getObject(24));
            row.put(Nutrient.MANGANESE.getLabel(), rs.getObject(25));
            row.put(Nutrient.SELENIUM.getLabel(), rs.getObject(26));
            row.put(Nutrient.VITAMINA.getLabel(), rs.getObject(27));
            row.put(Nutrient.VITAMINE.getLabel(), rs.getObject(28));
            row.put(Nutrient.VITAMIND.getLabel(), rs.getObject(29));
            row.put(Nutrient.VITAMINC.getLabel(), rs.getObject(30));
            row.put(Nutrient.THIAMIN.getLabel(), rs.getObject(31));
            row.put(Nutrient.RIBOFLAVIN.getLabel(), rs.getObject(32));
            row.put(Nutrient.NIACIN.getLabel(), rs.getObject(33));
            row.put(Nutrient.PANTOTHENIC.getLabel(), rs.getObject(34));
            row.put(Nutrient.VITAMINB6.getLabel(), rs.getObject(35));
            row.put(Nutrient.VITAMINB12.getLabel(), rs.getObject(36));
            row.put(Nutrient.CHOLINE.getLabel(), rs.getObject(37));
            row.put(Nutrient.VITAMINK.getLabel(), rs.getObject(38));
            row.put(Nutrient.FOLATE.getLabel(), rs.getObject(39));
            row.put(Nutrient.CHOLESTEROL.getLabel(), rs.getObject(40));
            row.put(Nutrient.SATURATED.getLabel(), rs.getObject(41));
            row.put(Nutrient.DHA.getLabel(), rs.getObject(42));
            row.put(Nutrient.EPA.getLabel(), rs.getObject(43));
            row.put(Nutrient.MONOUNSATURATED.getLabel(), rs.getObject(44));
            row.put(Nutrient.POLYUNSATURATED.getLabel(), rs.getObject(45));
            row.put(Nutrient.LINOLEIC.getLabel(), rs.getObject(46));
            row.put(Nutrient.ALPHALINOLENIC.getLabel(), rs.getObject(47));
            row.put(Nutrient.GLYCEMICLOAD.getLabel(), rs.getObject(48));
            row.put(Nutrient.WATER.getLabel(), rs.getObject(49));
            row.put(Nutrient.COST.getLabel(), rs.getObject(50));
            row.put("FoodId", rs.getObject(51));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> FoodCategory_Select_All() throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.FoodCategory_Select_All()}");
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("FOODCATEGORYID", rs.getObject(1));
            row.put("NAME", rs.getObject(2));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Food_Select_By_Category(String FoodCategoryId) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.Food_Select_By_Category( ? )}");
        proc.setString(1, FoodCategoryId);
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("FOODID", rs.getObject(1));
            row.put("NAME", rs.getObject(2));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public void FoodCategory_Insert_2(String Name) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.FoodCategory_Insert_2(  ? )}");
        proc.setString(1, Name);
        proc.execute();
    }

    public void FoodCategory_Delete(String FoodCategoryId) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.FoodCategory_Delete( ? )}");
        proc.setString(1, FoodCategoryId);
        proc.execute();
    }

    public void FoodCategory_Update(String FoodCategoryId, String Name) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.FoodCategory_Update( ?, ? )}");
        proc.setString(1, FoodCategoryId);
        proc.setString(2, Name);
        proc.execute();
    }

    public void CategoryLink_Insert(String FoodCategoryId, String FoodId) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.CategoryLink_Insert( ?, ? )}");
        //Different order in procedure
        proc.setString(2, FoodCategoryId);
        proc.setString(1, FoodId);
        proc.execute();
    }

    public void CategoryLink_Delete(String FoodCategoryId, String FoodId) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.CategoryLink_Delete( ?, ? )}");
        proc.setString(1, FoodCategoryId);
        proc.setString(2, FoodId);
        proc.execute();
    }

    public void Food_Delete(String FoodId) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.Food_Delete( ? )}");
        proc.setString(1, FoodId);
        proc.execute();
    }

    public List<Map<String, Object>> MixResult_Select_Pct(Integer MixId, Integer Precision) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.MixResult_Select_Pct( ?,?)}");
        proc.setInt(1, MixId);
        proc.setInt(2, Precision);
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("CALORIES", rs.getObject(1));
            row.put("FAT", rs.getObject(2));
            row.put("CARBS", rs.getObject(3));
            row.put("PROTEIN", rs.getObject(4));
            row.put("ALCOHOL", rs.getObject(5));
            row.put("FQ", rs.getObject(6));
            row.put("SATFAT", rs.getObject(7));
            row.put("MONOUFAT", rs.getObject(8));
            row.put("POLYUFAT", rs.getObject(9));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public void Mix_Duplicate(Integer MixId) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.Mix_Duplicate( ? )}");
        proc.setInt(1, MixId);
        proc.execute();
    }

    public void Mix_Update_Time(Integer MixId) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.Mix_Update_Time( ? )}");
        proc.setInt(1, MixId);
        proc.execute();
    }

    public void Mix_Update_Status(Integer MixId, Integer Status) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.Mix_Update_Status( ?,? )}");
        proc.setInt(1, MixId);
        proc.setInt(2, Status);
        proc.execute();
    }

    public List<Map<String, Object>> Mix_GetDiff(Integer MixId1, Integer MixId2, Integer Precision) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.Mix_getDiff( ?,?,?)}");
        proc.setInt(1, MixId1);
        proc.setInt(2, MixId2);
        proc.setInt(3, Precision);
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("NUTRIENT", rs.getObject(1));
            row.put("MIX1", rs.getObject(2));
            row.put("MIX2", rs.getObject(3));
            row.put("DIFF", rs.getObject(4));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Mix_GetRdaDiff(Integer MixId, Integer LifeStage, Integer Precision) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.Mix_getRdaDiff(?,?,?)}");
        proc.setInt(1, MixId);
        proc.setInt(2, LifeStage);
        proc.setInt(3, Precision);
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("NUTRIENTID", rs.getObject(1));
            row.put("NAME", rs.getObject(2));
            row.put("MIX", rs.getObject(3));
            row.put("RDA", rs.getObject(4));
            row.put("PCTRDA", rs.getObject(5));
            row.put("UL", rs.getObject(6));
            row.put("PCTUL", rs.getObject(7));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Mix_GetFQDiff(Integer MixId1, Integer MixId2) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.Mix_getFQDiff( ?,?)}");
        proc.setInt(1, MixId1);
        proc.setInt(2, MixId2);
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("NUTRIENT", rs.getObject(1));
            row.put("MIX1", rs.getObject(2));
            row.put("MIX2", rs.getObject(3));
            row.put("DIFF", rs.getObject(4));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Mix_GetMealGIDiff(Integer MixId1, Integer MixId2, Integer Precision) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.Mix_getMealGIDiff( ?,?,?)}");
        proc.setInt(1, MixId1);
        proc.setInt(2, MixId2);
        proc.setInt(3, Precision);
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("NUTRIENT", rs.getObject(1));
            row.put("MIX1", rs.getObject(2));
            row.put("MIX2", rs.getObject(3));
            row.put("DIFF", rs.getObject(4));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Nutrient_Lookup_List(String NutrientId, Double Weight, Integer Precision) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.Nutrient_Lookup_List(?,?,?)}");
        proc.setString(1, NutrientId);
        proc.setDouble(2, Weight);
        proc.setInt(3, Precision);
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("NAME", rs.getObject(1));
            row.put("WEIGHT", rs.getObject(2));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public void Food_Put(Integer MixId) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.Food_Put( ? )}");
        proc.setInt(1, MixId);
        proc.execute();
    }

    public Integer CategoryLink_Count(String FoodId, String FoodCategoryId) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.CategoryLink_Count(?,?)}");
        proc.setString(1, FoodId);
        proc.setString(2, FoodCategoryId);
        proc.execute();
        ResultSet resultSet = proc.getResultSet();
        resultSet.next();
        Integer out = resultSet.getInt(1);
        proc.close();
        return out;
    }

    public List<Map<String, Object>> Food_Select_All_Like(String txt) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.Food_Select_All_Like(?)}");
        proc.setString(1, txt);
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("FOODID", rs.getObject(1));
            row.put("NAME", rs.getObject(2));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public void Shutdown() {
        //SHUTDOWN COMPACT
        String sql = "SHUTDOWN COMPACT;";
        Statement stmt;
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            Log.getLog().start("files/exception.log");
            Log.getLog().logMessage(e.toString());
            Log.getLog().write();
            Log.getLog().close();
        }
    }

    public void PercentNutrientConstraint_Merge(Integer mixId, String foodid, String nutr_no, Double b) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.PercentNutrientConstraint_Merge( ?, ?, ?, ? )}");
        proc.setInt(1, mixId);
        proc.setString(2, foodid);
        proc.setString(3, nutr_no);
        proc.setDouble(4, b);
        proc.execute();
    }

    public void PercentNutrientConstraint_Delete(Integer mixid, String foodid, String nutrientid) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.PercentNutrientConstraint_Delete( ?, ?, ?)}");
        proc.setInt(1, mixid);
        proc.setString(2, foodid);
        proc.setString(3, nutrientid);
        proc.execute();
    }

    public List<Map<String, Object>> PercentNutrientConstraint_Select(Integer mixid) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.PercentNutrientConstraint_Select( ?)}");
        proc.setInt(1, mixid);
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("MIXID", rs.getObject(1));
            row.put("FOODID", rs.getObject(2));
            row.put("NUTRIENTID", rs.getObject(3));
            row.put("FOOD", rs.getObject(4));
            row.put("NUTRIENT", rs.getObject(5));
            row.put("B", rs.getObject(6));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public List percentnutrient_rhs(Integer mixId) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.percentnutrient_rhs(?)}");
        proc.setInt(1, mixId);
        ResultSet rs = proc.executeQuery();
        LinkedList<HashMap<String, Object>> list = new LinkedList<>();
        while (rs.next()) {
            HashMap<String, Object> row = new HashMap();
            //Integer mixid = rs.getString(1);
            String foodid = rs.getString(2);
            String nutrientid = rs.getString(3);
            Double b = rs.getDouble(4);
            row.put("FOODID", foodid);
            row.put("NUTRIENTID", nutrientid);
            row.put("B", b);
            list.add(row);
        }
        proc.close();
        return list;
    }

    public double[] percentnutrient_lhs(Integer mixId, String foodid, String nutrientid, Double b) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.percentnutrient_lhs(?,?,?,?)}");
        proc.setInt(1, mixId);
        proc.setString(2, foodid);
        proc.setString(3, nutrientid);
        proc.setDouble(4, b);
        ResultSet rs = proc.executeQuery();
        LinkedList<Double> list = new LinkedList<>();
        while (rs.next()) {
            //String foodid = rs.getString(1);
            double c = rs.getDouble(2);
            list.add(c);
        }
        proc.close();
        int size = list.size();
        double[] coefficients = new double[size];
        for (int i = 0; i < size; i++) {
            coefficients[i] = list.get(i).doubleValue();
        }
        return coefficients;
    }

    public void Nutrient_Update(String NutrientId, Integer Visible) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.Nutrient_Update( ?, ?)}");
        proc.setString(1, NutrientId);
        proc.setInt(2, Visible);
        proc.execute();
    }

    public String Food_Insert_Temp(String foodName) throws SQLException {
        CallableStatement proc;
        String out = null;
        proc = connection.prepareCall("{CALL public.Food_Insert_Temp (?,?)}");
        proc.registerOutParameter(1, Types.LONGVARCHAR);
        proc.setString(2, foodName);
        proc.execute();
        out = proc.getString(1);
        proc.close();
        return out;
    }

    public void startTransaction() {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void stopTransaction() {
        try {
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void revertTransaction() {
        try {
            connection.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void Food_Update(FoodDataObject foodDataObject) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.Food_Update( ?, ? )}");
        proc.setString(1, foodDataObject.getFoodId());
        proc.setString(2, foodDataObject.getFoodName());
        proc.execute();
        proc.close();
    }

    public List<FoodDataObject> Food_Select(FoodDataObject foodDataObject) throws SQLException {
        LinkedList<FoodDataObject> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.Food_Select( ? )}");
        proc.setString(1, foodDataObject.getFoodId());
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            foodDataObject.setFoodId(rs.getString(1));
            foodDataObject.setFoodName(rs.getString(2));
            list.add(foodDataObject);
        }
        proc.close();
        return list;
    }

    public List<FoodFactSelectForDataInputDataObject> FoodFact_Select_ForDataInput(String FoodId, Integer Precision) throws SQLException {
        LinkedList<FoodFactSelectForDataInputDataObject> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.FoodFact_Select_ForDataInput( ?,? )}");
        proc.setString(1, FoodId);
        proc.setInt(2, Precision);
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            FoodFactSelectForDataInputDataObject foodFactSelectForDataInputDataObject = new FoodFactSelectForDataInputDataObject();
            foodFactSelectForDataInputDataObject.setNutrientId(rs.getString(1));
            foodFactSelectForDataInputDataObject.setCategory(rs.getString(2));
            foodFactSelectForDataInputDataObject.setNutrient(rs.getString(3));
            foodFactSelectForDataInputDataObject.setQ(rs.getDouble(4));
            list.add(foodFactSelectForDataInputDataObject);
        }
        proc.close();
        return list;
    }

    public List<FoodFactSelectForCheckCoefficientsDataObject> FoodFact_Select_ForCheckCoefficients(String FoodId, Integer Precision) throws SQLException {
        LinkedList<FoodFactSelectForCheckCoefficientsDataObject> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.FoodFact_Select_ForCheckCoefficient( ?,? )}");
        proc.setString(1, FoodId);
        proc.setInt(2, Precision);
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            FoodFactSelectForCheckCoefficientsDataObject foodFactSelectForCheckCoefficientsDataObject = new FoodFactSelectForCheckCoefficientsDataObject();
            foodFactSelectForCheckCoefficientsDataObject.setNutrientId(rs.getString(1));
            foodFactSelectForCheckCoefficientsDataObject.setCategory(rs.getString(2));
            foodFactSelectForCheckCoefficientsDataObject.setNutrient(rs.getString(3));
            foodFactSelectForCheckCoefficientsDataObject.setQ(rs.getDouble(4));
            foodFactSelectForCheckCoefficientsDataObject.setC(rs.getDouble(5));
            list.add(foodFactSelectForCheckCoefficientsDataObject);
        }
        proc.close();
        return list;
    }

    public void FoodFact_Merge(String foodid, String nutrientid, Double q) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.FoodFact_Merge( ?, ?, ?)}");
        proc.setString(1, foodid);
        proc.setString(2, nutrientid);
        proc.setDouble(3, q);
        proc.execute();
    }

    public void DuplicateFoodItem(String foodId) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.DuplicateFoodItem( ? )}");
        proc.setString(1, foodId);
        proc.execute();
    }

    public List Mix_GetMealGi(Integer mixid, Integer precision) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.Mix_getMealGI( ?,?)}");
        proc.setInt(1, mixid);
        proc.setInt(2, precision);
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            String name = rs.getString(1);
            Double weight = rs.getDouble(2);
            Double carbs = rs.getDouble(3);
            Double pct = rs.getDouble(4);
            Double gl = rs.getDouble(5);
            Double gi = rs.getDouble(6);
            Double mealgi = rs.getDouble(7);
            row.put("name", name);
            row.put("weight", weight);
            row.put("carbs", carbs);
            row.put("pct", pct);
            row.put("gl", gl);
            row.put("gi", gi);
            row.put("mealgi", mealgi);
            list.add(row);
        }
        proc.close();
        return list;
    }

    public void FillMixResults(Integer mixId) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.FillMixResults( ? )}");
        proc.setInt(1, mixId);
        proc.execute();
    }
}
