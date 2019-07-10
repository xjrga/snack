package org.xjrga.snack2.data;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DbLink {
    private final Connection connection;

    public DbLink() {

        connection = Connect.getInstance().getConnection();

        /*try
        {
            Class.forName("org.hsqldb.jdbcDriver");
            connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/database", "SA", "");
            //connection = DriverManager.getConnection("jdbc.url=jdbc:hsqldb:file:data/database/snack2", "SA", "");
            //connection = DriverManager.getConnection("jdbc:hsqldb:mem:db", "SA", "");
        }
        catch (ClassNotFoundException | SQLException ex)
        {

        }*/

        /*try
        {
            connection.setAutoCommit(false);

            //call insert, update, delete or merge methodNames here

            connection.commit();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            try
            {
                connection.rollback();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
        finally
        {
            try
            {
                connection.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }*/
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

    public List<Map<String, Object>> Mix_Select_All_0() throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.Mix_Select_All_0()}");
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
        LinkedList<String> columnLabelList = new LinkedList();
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

    public void FoodConstraint_Merge(Integer MixId, String FoodId, Integer RelationshipId, Double b) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.FoodConstraint_Merge( ?, ?, ?, ? )}");
        proc.setInt(1, MixId);
        proc.setString(2, FoodId);
        proc.setInt(3, RelationshipId);
        proc.setDouble(4, b);
        proc.execute();
    }

    public List<Map<String, Object>> FoodConstraint_Select(Integer MixId) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        LinkedList<String> columnLabelList = new LinkedList();
        proc = connection.prepareCall("{CALL public.FoodConstraint_Select( ?)}");
        proc.setInt(1, MixId);
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("MIXID", rs.getObject(1));
            row.put("FOODID", rs.getObject(2));
            row.put("RELATIONSHIPID", rs.getObject(3));
            row.put("FOOD", rs.getObject(4));
            row.put("RELATIONSHIP", rs.getObject(5));
            row.put("B", rs.getObject(6));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public void FoodConstraint_Delete(Integer MixId, String FoodId, Integer RelationshipId) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.FoodConstraint_Delete( ?, ?, ? )}");
        proc.setInt(1, MixId);
        proc.setString(2, FoodId);
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
        LinkedList<String> columnLabelList = new LinkedList();
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

    public void FoodRatio_Merge(Integer MixId, String Food_Id_1, String Food_Id_2, Integer Relationship, Integer A, Integer B) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.FoodRatio_Merge( ?, ?, ?, ?, ?, ? )}");
        proc.setInt(1, MixId);
        proc.setString(2, Food_Id_1);
        proc.setString(3, Food_Id_2);
        proc.setInt(4, Relationship);
        proc.setInt(5, A);
        proc.setInt(6, B);
        proc.execute();
    }

    public List<Map<String, Object>> FoodRatio_Select(Integer MixId) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        LinkedList<String> columnLabelList = new LinkedList();
        proc = connection.prepareCall("{CALL public.FoodRatio_Select( ?)}");
        proc.setInt(1, MixId);
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("MIXID", rs.getObject(1));
            row.put("FOOD_ID_1", rs.getObject(2));
            row.put("FOOD_ID_2", rs.getObject(3));
            row.put("RELATIONSHIP", rs.getObject(4));
            row.put("FOODA", rs.getObject(5));
            row.put("FOODB", rs.getObject(6));
            row.put("A", rs.getObject(7));
            row.put("B", rs.getObject(8));
            list.add(row);
        }
        proc.close();
        return list;
    }

    public void FoodRatio_Delete(Integer MixId, String Food_Id_1, String Food_Id_2, Integer Relationship) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.FoodRatio_Delete( ?, ?, ?, ? )}");
        proc.setInt(1, MixId);
        proc.setString(2, Food_Id_1);
        proc.setString(3, Food_Id_2);
        proc.setInt(4, Relationship);
        proc.execute();
    }

    public List<Map<String, Object>> NutrientRatio_Select(Integer MixId) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        LinkedList<String> columnLabelList = new LinkedList();
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
            list.add(row);
        }
        proc.close();
        return list;
    }

    public void NutrientRatio_Merge(Integer MixId, String Nutrient_Id_1, String Nutrient_Id_2, Integer RelationshipId, Integer A, Integer B) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.NutrientRatio_Merge( ?, ?, ?, ?, ?, ? )}");
        proc.setInt(1, MixId);
        proc.setString(2, Nutrient_Id_1);
        proc.setString(3, Nutrient_Id_2);
        proc.setInt(4, RelationshipId);
        proc.setInt(5, A);
        proc.setInt(6, B);
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

    public void FoodNutrientRatio_Merge(Integer MixId, String Food_Id_1, String Nutrient_Id_1, String Food_Id_2, String Nutrient_Id_2, Integer RelationshipId, Integer A, Integer B) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.FoodNutrientRatio_Merge( ?, ?, ?, ?, ?, ?, ?, ? )}");
        proc.setInt(1, MixId);
        proc.setString(2, Food_Id_1);
        proc.setString(3, Nutrient_Id_1);
        proc.setString(4, Food_Id_2);
        proc.setString(5, Nutrient_Id_2);
        proc.setInt(6, RelationshipId);
        proc.setInt(7, A);
        proc.setInt(8, B);
        proc.execute();
    }

    public List<Map<String, Object>> FoodNutrientRatio_Select(Integer MixId) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        LinkedList<String> columnLabelList = new LinkedList();
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

    public List food_rhs(Integer mixid) throws SQLException {

        CallableStatement proc = connection.prepareCall("{CALL public.food_rhs(?)}");
        proc.setInt(1, mixid);
        ResultSet rs = proc.executeQuery();
        LinkedList<HashMap<String, Object>> list = new LinkedList<>();

        while (rs.next()) {
            HashMap<String, Object> row = new HashMap();
            //Integer mixid = rs.getString(1);
            String foodid = rs.getString(2);
            Integer relationshipid = rs.getInt(3);
            Double b = rs.getDouble(4);
            row.put("FOODID", foodid);
            row.put("RELATIONSHIPID", relationshipid);
            row.put("B", b);
            list.add(row);
        }

        proc.close();

        return list;
    }

    public double[] food_lhs(Integer mixid, String foodid, Integer relationshipid) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.food_lhs(?,?,?)}");
        proc.setInt(1, mixid);
        proc.setString(2, foodid);
        proc.setInt(3, relationshipid);

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

    public List foodratio_rhs(Integer mixid) throws SQLException {

        CallableStatement proc = connection.prepareCall("{CALL public.foodratio_rhs(?)}");
        proc.setInt(1, mixid);
        ResultSet rs = proc.executeQuery();
        LinkedList<HashMap<String, Object>> list = new LinkedList<>();

        while (rs.next()) {
            HashMap<String, Object> row = new HashMap();
            //Integer mixid = rs.getString(1);
            String food_id_1 = rs.getString(2);
            String food_id_2 = rs.getString(3);
            Integer relationshipid = rs.getInt(4);
            Double b = rs.getDouble(5);
            row.put("FOOD_ID_1", food_id_1);
            row.put("FOOD_ID_2", food_id_2);
            row.put("RELATIONSHIPID", relationshipid);
            row.put("B", b);
            list.add(row);
        }

        proc.close();

        return list;
    }


    public double[] foodratio_lhs(Integer mixid, String foodid1, String foodid2, Integer relationshipid) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.foodratio_lhs(?,?,?,?)}");
        proc.setInt(1, mixid);
        proc.setString(2, foodid1);
        proc.setString(3, foodid2);
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
        LinkedList<String> columnLabelList = new LinkedList();
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

    public void Mix_Update(Integer MixId, String Name) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.Mix_Update( ?, ?)}");
        proc.setInt(1, MixId);
        proc.setString(2, Name);
        proc.execute();
    }

    public void MixModel_Merge(Integer MixId, String NutrientId, String Model) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.MixModel_Merge( ?, ?, ? )}");
        proc.setInt(1, MixId);
        proc.setString(2, NutrientId);
        proc.setString(3, Model);
        proc.execute();
    }

    public List<Map<String, Object>> MixModel_Select(Integer MixId) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        LinkedList<String> columnLabelList = new LinkedList();
        proc = connection.prepareCall("{CALL public.MixModel_Select( ? )}");
        proc.setInt(1, MixId);
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("MIXID", rs.getObject(1));
            row.put("NUTRIENTID", rs.getObject(2));
            row.put("MODEL", rs.getObject(3));
            list.add(row);
        }
        proc.close();
        return list;
    }


    public List<Map<String, Object>> MixResultDW_Select(Integer MixId) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        LinkedList<String> columnLabelList = new LinkedList();
        proc = connection.prepareCall("{CALL public.MixResultDW_Select( ?)}");
        proc.setInt(1, MixId);
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("MIXID", rs.getObject(1));
            row.put("FOODID", rs.getObject(2));
            row.put("NAME", rs.getObject(3));
            row.put("PROTEIN", rs.getObject(4));
            row.put("FAT", rs.getObject(5));
            row.put("KCAL", rs.getObject(6));
            row.put("ALCOHOL", rs.getObject(7));
            row.put("FIBER", rs.getObject(8));
            row.put("CALCIUM", rs.getObject(9));
            row.put("MAGNESIUM", rs.getObject(10));
            row.put("POTASSIUM", rs.getObject(11));
            row.put("SODIUM", rs.getObject(12));
            row.put("CHOLESTEROL", rs.getObject(13));
            row.put("SATFAT", rs.getObject(14));
            row.put("MONOUFAT", rs.getObject(15));
            row.put("POLYUFAT", rs.getObject(16));
            row.put("QUANTITY", rs.getObject(17));
            row.put("COMPLETE", rs.getObject(18));
            row.put("INCOMPLETE", rs.getObject(19));
            row.put("CARBSDIGESTIBLE", rs.getObject(20));
            row.put("COST", rs.getObject(21));
            list.add(row);
        }
        proc.close();
        return list;
    }


    public List<Map<String, Object>> Food_Select_Details() throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        LinkedList<String> columnLabelList = new LinkedList();
        proc = connection.prepareCall("{CALL Food_Select_Details( )}");
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("CATEGORY", rs.getObject(1));
            row.put("FOOD", rs.getObject(2));
            row.put("PROTEIN", rs.getObject(3));
            row.put("FAT", rs.getObject(4));
            //row.put("CARBOHYDRATE", rs.getObject(5));
            row.put("CALORIES", rs.getObject(5));
            row.put("ALCOHOL", rs.getObject(6));
            row.put("FIBER", rs.getObject(7));
            row.put("CALCIUM", rs.getObject(8));
            row.put("MAGNESIUM", rs.getObject(9));
            row.put("POTASSIUM", rs.getObject(10));
            row.put("SODIUM", rs.getObject(11));
            row.put("CHOLESTEROL", rs.getObject(12));
            row.put("SATFAT", rs.getObject(13));
            row.put("MONOUFAT", rs.getObject(14));
            row.put("POLYUFAT", rs.getObject(15));
            row.put("QUANTITY", rs.getObject(16));
            row.put("COMPLETE", rs.getObject(17));
            row.put("INCOMPLETE", rs.getObject(18));
            row.put("CARBSDIGESTIBLE", rs.getObject(19));
            row.put("COST", rs.getObject(20));
            row.put("FOODCATEGORYID", rs.getObject(21));
            row.put("FOODID", rs.getObject(22));
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
        LinkedList<String> columnLabelList = new LinkedList();
        proc = connection.prepareCall("{CALL Food_Select_By_Category( ? )}");
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

    public void FoodCategory_Insert(String FoodCategoryId, String Name) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.FoodCategory_Insert( ?, ? )}");
        proc.setString(1, FoodCategoryId);
        proc.setString(2, Name);
        proc.execute();
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

    public void Food_Add_Details(String v_foodnom, Double v_serving_size, Double v_calories, Double v_protein, Double v_fat, Double v_carbohydrates, Double v_fiber, Double v_saturated_fat, Double v_monounsaturated_fat, Double v_polyunsaturated_fat, Double v_cholesterol, Double v_sodium, Double v_potassium, Double v_calcium, Double v_magnesium, Double v_cost, Double v_complete_protein, Double v_incomplete_protein, Double v_alcohol) throws SQLException {

        CallableStatement proc = connection.prepareCall("{CALL public.food_add_details(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        proc.setString(1, v_foodnom);
        proc.setDouble(2, v_serving_size);
        proc.setDouble(3, v_calories);
        proc.setDouble(4, v_protein);
        proc.setDouble(5, v_fat);
        proc.setDouble(6, v_carbohydrates);
        proc.setDouble(7, v_fiber);
        proc.setDouble(8, v_saturated_fat);
        proc.setDouble(9, v_monounsaturated_fat);
        proc.setDouble(10, v_polyunsaturated_fat);
        proc.setDouble(11, v_cholesterol);
        proc.setDouble(12, v_sodium);
        proc.setDouble(13, v_potassium);
        proc.setDouble(14, v_calcium);
        proc.setDouble(15, v_magnesium);
        proc.setDouble(16, v_cost);
        proc.setDouble(17, v_complete_protein);
        proc.setDouble(18, v_incomplete_protein);
        proc.setDouble(19, v_alcohol);
        proc.execute();
    }

    public void Food_Update_Details(String v_foodid, String v_foodnom, Double v_serving_size, Double v_calories, Double v_protein, Double v_fat, Double v_carbohydrates, Double v_fiber, Double v_saturated_fat, Double v_monounsaturated_fat, Double v_polyunsaturated_fat, Double v_cholesterol, Double v_sodium, Double v_potassium, Double v_calcium, Double v_magnesium, Double v_cost, Double v_complete_protein, Double v_incomplete_protein, Double v_alcohol) throws SQLException {
        //call Food_Update_Details('x4','2',3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
        CallableStatement proc = connection.prepareCall("{CALL public.food_update_details(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        proc.setString(1, v_foodid);
        proc.setString(2, v_foodnom);
        proc.setDouble(3, v_serving_size);
        proc.setDouble(4, v_calories);
        proc.setDouble(5, v_protein);
        proc.setDouble(6, v_fat);
        proc.setDouble(7, v_carbohydrates);
        proc.setDouble(8, v_fiber);
        proc.setDouble(9, v_saturated_fat);
        proc.setDouble(10, v_monounsaturated_fat);
        proc.setDouble(11, v_polyunsaturated_fat);
        proc.setDouble(12, v_cholesterol);
        proc.setDouble(13, v_sodium);
        proc.setDouble(14, v_potassium);
        proc.setDouble(15, v_calcium);
        proc.setDouble(16, v_magnesium);
        proc.setDouble(17, v_cost);
        proc.setDouble(18, v_complete_protein);
        proc.setDouble(19, v_incomplete_protein);
        proc.setDouble(20, v_alcohol);
        proc.execute();
    }

    public void Food_Delete(String FoodId) throws SQLException {
        CallableStatement proc = connection.prepareCall("{CALL public.Food_Delete( ? )}");
        proc.setString(1, FoodId);
        proc.execute();
    }

    public List<Map<String, Object>> MixResultDW_Select_Pct(Integer MixId) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        LinkedList<String> columnLabelList = new LinkedList();
        proc = connection.prepareCall("{CALL public.MixResultDW_Select_Pct( ?)}");
        proc.setInt(1, MixId);
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("CALORIES", rs.getObject(1));
            row.put("FAT", rs.getObject(2));
            row.put("CARBS", rs.getObject(3));
            row.put("PROTEIN", rs.getObject(4));
            row.put("ALCOHOL", rs.getObject(5));
            row.put("FQ", rs.getObject(6));
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

    public List<Map<String, Object>> Mix_GetDiff(Integer MixId1, Integer MixId2) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        LinkedList<String> columnLabelList = new LinkedList();
        proc = connection.prepareCall("{CALL public.Mix_getDiff( ?,?)}");
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

    public List<Map<String, Object>> Mix_GetFQDiff(Integer MixId1, Integer MixId2) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        LinkedList<String> columnLabelList = new LinkedList();
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

    public List<Map<String, Object>> Food_Exchange_List(String NutrientId, Double Quantity) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.Food_Exchange_List(?,?)}");
        proc.setString(1, NutrientId);
        proc.setDouble(2, Quantity);
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            row.put("NAME", rs.getObject(1));
            row.put("QUANTITY", rs.getObject(2));
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
            e.printStackTrace();
        }
    }

    public void PercentNutrientConstraint_Merge(Integer mixId, String foodid, String nutr_no, Integer b) throws SQLException {
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
}