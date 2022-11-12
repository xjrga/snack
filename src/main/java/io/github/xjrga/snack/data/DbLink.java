package io.github.xjrga.snack.data;

import io.github.xjrga.snack.dataobject.FoodDataObject;
import io.github.xjrga.snack.dataobject.FoodFactSelectForCheckCoefficientsDataObject;
import io.github.xjrga.snack.dataobject.FoodFactSelectForDataInputDataObject;
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

    public void startTransaction() {
        try {
            connection.setAutoCommit( false );
        } catch( SQLException throwables ) {
        }
    }

    public void stopTransaction() {
        try {
            connection.commit();
            //connection.setAutoCommit(true);
        } catch( SQLException throwables ) {
        }
    }

    public void revertTransaction() {
        try {
            connection.rollback();
        } catch( SQLException throwables ) {
        }
    }

    public List<Map<String, Object>> Food_Select_All() throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.Food_Select_All()}" );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "CATEGORY", rs.getObject( 1 ) );
            row.put( "FOODID", rs.getObject( 2 ) );
            row.put( "FOOD", rs.getObject( 3 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Food_Select_All_2() throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.Food_Select_All_2()}" );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "FOODID", rs.getObject( 1 ) );
            row.put( "NAME", rs.getObject( 2 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Nutrient_Select_All() throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.Nutrient_Select_All()}" );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "NUTRIENTID", rs.getObject( 1 ) );
            row.put( "NAME", rs.getObject( 2 ) );
            row.put( "VISIBLE", rs.getObject( 3 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Nutrient_To_Pct_Select() throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.Nutrient_To_Pct_Select()}" );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "NUTRIENTID", rs.getObject( 1 ) );
            row.put( "NAME", rs.getObject( 2 ) );
            row.put( "q", rs.getObject( 3 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Nutrient_Select_All_Visible() throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.Nutrient_Select_All_Visible()}" );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "NUTRIENTID", rs.getObject( 1 ) );
            row.put( "NAME", rs.getObject( 2 ) );
            row.put( "VISIBLE", rs.getObject( 3 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> RdaLifeStage_Select_All() throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.RdaLifeStage_Select_All()}" );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "LIFESTAGEID", rs.getObject( 1 ) );
            row.put( "LABEL", rs.getObject( 2 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Meal_Select_All( String mixid ) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.Meal_Select_All( ? )}" );
        proc.setString( 1, mixid );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "MIXID", rs.getObject( 1 ) );
            row.put( "MEALID", rs.getObject( 2 ) );
            row.put( "NAME", rs.getObject( 3 ) );
            row.put( "NOTE", rs.getObject( 4 ) );
            row.put( "MEALORDER", rs.getObject( 5 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public Double calculate_remaining_allocation( String mixid, String foodid, Integer precision ) throws SQLException {
        Double out;
        try(  CallableStatement proc = connection.prepareCall( "{CALL public.calculate_remaining_allocation( ?, ?, ? )}" ) ) {
            proc.setString( 1, mixid );
            proc.setString( 2, foodid );
            proc.setInt( 3, precision );
            proc.execute();
            ResultSet resultSet = proc.getResultSet();
            resultSet.next();
            out = resultSet.getDouble( 1 );
        }
        return out;
    }

    public void MealFoodAllocation_update_pct( String mixid, Integer mealid, String foodid, Double pct ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.MealFoodAllocation_insert_and_calculate( ?, ?, ?, ? )}" );
        proc.setString( 1, mixid );
        proc.setInt( 2, mealid );
        proc.setString( 3, foodid );
        proc.setDouble( 4, pct );
        proc.execute();
    }

    public void MealFoodAllocation_update_actualwt( String mixid, Integer mealid, String foodid, Double actualwt ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.MealFoodAllocation_update_actualwt( ?, ?, ?, ? )}" );
        proc.setString( 1, mixid );
        proc.setInt( 2, mealid );
        proc.setString( 3, foodid );
        proc.setDouble( 4, actualwt );
        proc.execute();
    }

    public void MealFoodAllocation_delete( String mixid, Integer mealid, String foodid ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.MealFoodAllocation_delete( ?, ?, ? )}" );
        proc.setString( 1, mixid );
        proc.setInt( 2, mealid );
        proc.setString( 3, foodid );
        proc.execute();
    }

    public void MealFoodAllocation_insert_and_calculate( String mixid, Integer mealid, String foodid, Double pct ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.MealFoodAllocation_insert_and_calculate( ?, ?, ?, ? )}" );
        proc.setString( 1, mixid );
        proc.setInt( 2, mealid );
        proc.setString( 3, foodid );
        proc.setDouble( 4, pct );
        proc.execute();
    }

    public List<Map<String, Object>> MealFoodAllocation_select_all( String mixid, Integer precision ) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.MealFoodAllocation_select_all( ?, ? )}" );
        proc.setString( 1, mixid );
        proc.setInt( 2, precision );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "MIXID", rs.getObject( 1 ) );
            row.put( "MEALID", rs.getObject( 2 ) );
            row.put( "FOODID", rs.getObject( 3 ) );
            row.put( "MEAL", rs.getObject( 4 ) );
            row.put( "FOOD", rs.getObject( 5 ) );
            row.put( "PCT", rs.getObject( 6 ) );
            row.put( "EXPECTEDWT", rs.getObject( 7 ) );
            row.put( "ACTUALWT", rs.getObject( 8 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Relationship_Select_All() throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.Relationship_Select_All()}" );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "RELATIONSHIPID", rs.getObject( 1 ) );
            row.put( "NAME", rs.getObject( 2 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Mix_Select_All() throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.Mix_Select_All()}" );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "MIXID", rs.getObject( 1 ) );
            row.put( "NAME", rs.getObject( 2 ) );
            row.put( "STATUS", rs.getObject( 3 ) );
            row.put( "NUTRIENTID", rs.getObject( 4 ) );
            row.put( "MODEL", rs.getObject( 5 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Mix_Select_All_0() throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.Mix_Select_All_0()}" );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "MIXID", rs.getObject( 1 ) );
            row.put( "NAME", rs.getObject( 2 ) );
            row.put( "STATUS", rs.getObject( 3 ) );
            row.put( "NUTRIENTID", rs.getObject( 4 ) );
            row.put( "MODEL", rs.getObject( 5 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Mix_Select_All_1() throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.Mix_Select_All_1()}" );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "MIXID", rs.getObject( 1 ) );
            row.put( "NAME", rs.getObject( 2 ) );
            row.put( "STATUS", rs.getObject( 3 ) );
            row.put( "NUTRIENTID", rs.getObject( 4 ) );
            row.put( "MODEL", rs.getObject( 5 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public String Mix_Insert( String Name ) throws SQLException {
        String ident = null;
        CallableStatement proc = connection.prepareCall( "{CALL public.Mix_Insert( ?, ?)}" );
        proc.registerOutParameter( 1, Types.INTEGER );
        proc.setString( 2, Name );
        proc.execute();
        ident = proc.getString( 1 );
        return ident;
    }

    public void snack_mix_insertmix( String mixid, String name, Integer status, String nutrientid, String model ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.snack_mix_insertmix( ?, ?, ?, ?, ?)}" );
        proc.setString( 1, mixid );
        proc.setString( 2, name );
        proc.setInt( 3, status );
        proc.setString( 4, nutrientid );
        proc.setString( 5, model );
        proc.execute();
    }

    public void MixFood_Insert( String MixId, String FoodId ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.MixFood_Insert( ?, ? )}" );
        proc.setString( 1, MixId );
        proc.setString( 2, FoodId );
        proc.execute();
    }

    public List<Map<String, Object>> MixFood_Select_All_By_Foodid( String mixId ) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.MixFood_Select_All_By_FoodId(?)}" );
        proc.setString( 1, mixId );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "FOODID", rs.getObject( 1 ) );
            row.put( "NAME", rs.getObject( 2 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> MixFood_Select_All_By_Name( String mixId ) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.MixFood_Select_All_By_Name(?)}" );
        proc.setString( 1, mixId );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "FOODID", rs.getObject( 1 ) );
            row.put( "NAME", rs.getObject( 2 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public void MixFood_Delete( String MixId, String FoodId ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.MixFood_Delete( ?, ? )}" );
        proc.setString( 1, MixId );
        proc.setString( 2, FoodId );
        proc.execute();
    }

    public void Mix_Delete( String MixId ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.Mix_Delete( ? )}" );
        proc.setString( 1, MixId );
        proc.execute();
    }

    public void NutrientConstraint_Merge( String MixId, String NutrientId, Integer RelationshipId, Double b ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.NutrientConstraint_Merge( ?, ?, ?, ? )}" );
        proc.setString( 1, MixId );
        proc.setString( 2, NutrientId );
        proc.setInt( 3, RelationshipId );
        proc.setDouble( 4, b );
        proc.execute();
    }

    public List<Map<String, Object>> NutrientConstraint_Select( String MixId ) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.NutrientConstraint_Select( ?)}" );
        proc.setString( 1, MixId );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "MIXID", rs.getObject( 1 ) );
            row.put( "NUTRIENTID", rs.getObject( 2 ) );
            row.put( "RELATIONSHIPID", rs.getObject( 3 ) );
            row.put( "NUTRIENT", rs.getObject( 4 ) );
            row.put( "RELATIONSHIP", rs.getObject( 5 ) );
            row.put( "B", rs.getObject( 6 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public void NutrientConstraint_Delete( String MixId, String NutrientId, Integer RelationshipId ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.NutrientConstraint_Delete( ?, ?, ? )}" );
        proc.setString( 1, MixId );
        proc.setString( 2, NutrientId );
        proc.setInt( 3, RelationshipId );
        proc.execute();
    }

    public void FoodNutrientConstraint_Merge( String MixId, String FoodId, String NutrientId, Integer RelationshipId, Double b ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.FoodNutrientConstraint_Merge( ?, ?, ?, ?, ? )}" );
        proc.setString( 1, MixId );
        proc.setString( 2, FoodId );
        proc.setString( 3, NutrientId );
        proc.setInt( 4, RelationshipId );
        proc.setDouble( 5, b );
        proc.execute();
    }

    public List<Map<String, Object>> FoodNutrientConstraint_Select( String MixId ) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.FoodNutrientConstraint_Select( ?)}" );
        proc.setString( 1, MixId );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "MIXID", rs.getObject( 1 ) );
            row.put( "FOODID", rs.getObject( 2 ) );
            row.put( "NUTRIENTID", rs.getObject( 3 ) );
            row.put( "RELATIONSHIPID", rs.getObject( 4 ) );
            row.put( "FOOD", rs.getObject( 5 ) );
            row.put( "NUTRIENT", rs.getObject( 6 ) );
            row.put( "RELATIONSHIP", rs.getObject( 7 ) );
            row.put( "B", rs.getObject( 8 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public void Meal_insert( String MixId, String Name, String Note, Integer Order ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.Meal_insert( ?, ?, ?, ? )}" );
        proc.setString( 1, MixId );
        proc.setString( 2, Name );
        proc.setString( 3, Note );
        proc.setInt( 4, Order );
        proc.execute();
    }

    public void Meal_delete( String MixId, Integer MealId ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.Meal_Delete( ?, ? )}" );
        proc.setString( 1, MixId );
        proc.setInt( 2, MealId );
        proc.execute();
    }

    public void Meal_update( String mixid, Integer mealid, String name, String note, Integer order ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.Meal_update( ?, ?, ?, ?, ? )}" );
        proc.setString( 1, mixid );
        proc.setInt( 2, mealid );
        proc.setString( 3, name );
        proc.setString( 4, note );
        proc.setInt( 5, order );
        proc.execute();
    }

    public void FoodNutrientConstraint_Delete( String MixId, String FoodId, String NutrientId, Integer RelationshipId ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.FoodNutrientConstraint_Delete( ?, ?, ?, ? )}" );
        proc.setString( 1, MixId );
        proc.setString( 2, FoodId );
        proc.setString( 3, NutrientId );
        proc.setInt( 4, RelationshipId );
        proc.execute();
    }

    public List<Map<String, Object>> NutrientRatio_Select( String MixId ) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.NutrientRatio_Select( ?)}" );
        proc.setString( 1, MixId );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "MIXID", rs.getObject( 1 ) );
            row.put( "NUTRIENT_ID_1", rs.getObject( 2 ) );
            row.put( "NUTRIENT_ID_2", rs.getObject( 3 ) );
            row.put( "RELATIONSHIPID", rs.getObject( 4 ) );
            row.put( "NUTRIENTA", rs.getObject( 5 ) );
            row.put( "NUTRIENTB", rs.getObject( 6 ) );
            row.put( "A", rs.getObject( 7 ) );
            row.put( "B", rs.getObject( 8 ) );
            row.put( "RELATIONSHIP", rs.getObject( 9 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public void NutrientRatio_Merge( String MixId, String Nutrient_Id_1, String Nutrient_Id_2, Integer RelationshipId, Double A, Double B ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.NutrientRatio_Merge( ?, ?, ?, ?, ?, ? )}" );
        proc.setString( 1, MixId );
        proc.setString( 2, Nutrient_Id_1 );
        proc.setString( 3, Nutrient_Id_2 );
        proc.setInt( 4, RelationshipId );
        proc.setDouble( 5, A );
        proc.setDouble( 6, B );
        proc.execute();
    }

    public void NutrientRatio_Delete( String MixId, String Nutrient_Id_1, String Nutrient_Id_2, Integer RelationshipId ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.NutrientRatio_Delete( ?, ?, ?, ? )}" );
        proc.setString( 1, MixId );
        proc.setString( 2, Nutrient_Id_1 );
        proc.setString( 3, Nutrient_Id_2 );
        proc.setInt( 4, RelationshipId );
        proc.execute();
    }

    public void FoodNutrientRatio_Merge( String MixId, String Food_Id_1, String Nutrient_Id_1, String Food_Id_2, String Nutrient_Id_2, Integer RelationshipId, Double A, Double B ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.FoodNutrientRatio_Merge( ?, ?, ?, ?, ?, ?, ?, ? )}" );
        proc.setString( 1, MixId );
        proc.setString( 2, Food_Id_1 );
        proc.setString( 3, Nutrient_Id_1 );
        proc.setString( 4, Food_Id_2 );
        proc.setString( 5, Nutrient_Id_2 );
        proc.setInt( 6, RelationshipId );
        proc.setDouble( 7, A );
        proc.setDouble( 8, B );
        proc.execute();
    }

    public List<Map<String, Object>> FoodNutrientRatio_Select( String MixId ) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.FoodNutrientRatio_Select( ?)}" );
        proc.setString( 1, MixId );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "MIXID", rs.getObject( 1 ) );
            row.put( "FOOD_ID_1", rs.getObject( 2 ) );
            row.put( "NUTRIENT_ID_1", rs.getObject( 3 ) );
            row.put( "FOOD_ID_2", rs.getObject( 4 ) );
            row.put( "NUTRIENT_ID_2", rs.getObject( 5 ) );
            row.put( "RELATIONSHIPID", rs.getObject( 6 ) );
            row.put( "FOODA", rs.getObject( 7 ) );
            row.put( "NUTRIENTA", rs.getObject( 8 ) );
            row.put( "FOODB", rs.getObject( 9 ) );
            row.put( "NUTRIENTB", rs.getObject( 10 ) );
            row.put( "A", rs.getObject( 11 ) );
            row.put( "B", rs.getObject( 12 ) );
            row.put( "RELATIONSHIP", rs.getObject( 13 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public void FoodNutrientRatio_Delete( String MixId, String Food_Id_1, String Nutrient_Id_1, String Food_Id_2, String Nutrient_Id_2, Integer RelationshipId ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.FoodNutrientRatio_Delete( ?, ?, ?, ?, ?, ? )}" );
        proc.setString( 1, MixId );
        proc.setString( 2, Food_Id_1 );
        proc.setString( 3, Nutrient_Id_1 );
        proc.setString( 4, Food_Id_2 );
        proc.setString( 5, Nutrient_Id_2 );
        proc.setInt( 6, RelationshipId );
        proc.execute();
    }

    public double[] objective_lhs( String MixId ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.objective_lhs(?)}" );
        proc.setString( 1, MixId );
        ResultSet rs = proc.executeQuery();
        LinkedList<Double> list = new LinkedList<>();
        while( rs.next() ) {
            String foodid = rs.getString( 1 );
            double c = rs.getDouble( 2 );
            list.add( c );
        }
        proc.close();
        int size = list.size();
        double[] coefficients = new double[ size ];
        for( int i = 0; i < size; i++ ) {
            coefficients[ i ] = list.get( i ).doubleValue();
        }
        return coefficients;
    }

    public List nutrient_rhs( String mixid ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.nutrient_rhs(?)}" );
        proc.setString( 1, mixid );
        ResultSet rs = proc.executeQuery();
        LinkedList<HashMap<String, Object>> list = new LinkedList<>();
        while( rs.next() ) {
            HashMap<String, Object> row = new HashMap();
            //Integer mixid = rs.getString(1);
            String nutrientid = rs.getString( 2 );
            Integer relationshipid = rs.getInt( 3 );
            Double b = rs.getDouble( 4 );
            row.put( "NUTRIENTID", nutrientid );
            row.put( "RELATIONSHIPID", relationshipid );
            row.put( "B", b );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public double[] nutrient_lhs( String mixid, String nutrientid, Integer relationshipid ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.nutrient_lhs(?,?,?)}" );
        proc.setString( 1, mixid );
        proc.setString( 2, nutrientid );
        proc.setInt( 3, relationshipid );
        ResultSet rs = proc.executeQuery();
        LinkedList<Double> list = new LinkedList<>();
        while( rs.next() ) {
            String foodid = rs.getString( 1 );
            double c = rs.getDouble( 2 );
            list.add( c );
        }
        proc.close();
        int size = list.size();
        double[] coefficients = new double[ size ];
        for( int i = 0; i < size; i++ ) {
            coefficients[ i ] = list.get( i ).doubleValue();
        }
        return coefficients;
    }

    public List foodnutrient_rhs( String mixid ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.foodnutrient_rhs(?)}" );
        proc.setString( 1, mixid );
        ResultSet rs = proc.executeQuery();
        LinkedList<HashMap<String, Object>> list = new LinkedList<>();
        while( rs.next() ) {
            HashMap<String, Object> row = new HashMap();
            //Integer mixid = rs.getString(1);
            String foodid = rs.getString( 2 );
            String nutrientid = rs.getString( 3 );
            Integer relationshipid = rs.getInt( 4 );
            Double b = rs.getDouble( 5 );
            row.put( "FOODID", foodid );
            row.put( "NUTRIENTID", nutrientid );
            row.put( "RELATIONSHIPID", relationshipid );
            row.put( "B", b );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public double[] foodnutrient_lhs( String mixid, String foodid, String nutrientid, Integer relationshipid ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.foodnutrient_lhs(?,?,?,?)}" );
        proc.setString( 1, mixid );
        proc.setString( 2, foodid );
        proc.setString( 3, nutrientid );
        proc.setInt( 4, relationshipid );
        ResultSet rs = proc.executeQuery();
        LinkedList<Double> list = new LinkedList<>();
        while( rs.next() ) {
            //String foodid = rs.getString(1);
            double c = rs.getDouble( 3 );
            list.add( c );
        }
        proc.close();
        int size = list.size();
        double[] coefficients = new double[ size ];
        for( int i = 0; i < size; i++ ) {
            coefficients[ i ] = list.get( i ).doubleValue();
        }
        return coefficients;
    }

    public List foodnutrientratio_rhs( String mixid ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.foodnutrientratio_rhs(?)}" );
        proc.setString( 1, mixid );
        ResultSet rs = proc.executeQuery();
        LinkedList<HashMap<String, Object>> list = new LinkedList<>();
        while( rs.next() ) {
            HashMap<String, Object> row = new HashMap();
            //Integer mixid = rs.getString(1);
            String food_id_1 = rs.getString( 2 );
            String nutrient_id_1 = rs.getString( 3 );
            String food_id_2 = rs.getString( 4 );
            String nutrient_id_2 = rs.getString( 5 );
            Integer relationshipid = rs.getInt( 6 );
            Double b = rs.getDouble( 7 );
            row.put( "FOOD_ID_1", food_id_1 );
            row.put( "NUTRIENT_ID_1", nutrient_id_1 );
            row.put( "FOOD_ID_2", food_id_2 );
            row.put( "NUTRIENT_ID_2", nutrient_id_2 );
            row.put( "RELATIONSHIPID", relationshipid );
            row.put( "B", b );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public double[] foodnutrientratio_lhs( String mixid, String foodid1, String nutrientid1, String foodid2, String nutrientid2, Integer relationshipid ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.foodnutrientratio_lhs(?,?,?,?,?,?)}" );
        proc.setString( 1, mixid );
        proc.setString( 2, foodid1 );
        proc.setString( 3, nutrientid1 );
        proc.setString( 4, foodid2 );
        proc.setString( 5, nutrientid2 );
        proc.setInt( 6, relationshipid );
        ResultSet rs = proc.executeQuery();
        LinkedList<Double> list = new LinkedList<>();
        while( rs.next() ) {
            //String foodid = rs.getString(1);
            double c = rs.getDouble( 2 );
            list.add( c );
        }
        proc.close();
        int size = list.size();
        double[] coefficients = new double[ size ];
        for( int i = 0; i < size; i++ ) {
            coefficients[ i ] = list.get( i ).doubleValue();
        }
        return coefficients;
    }

    public List nutrientratio_rhs( String mixid ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.nutrientratio_rhs(?)}" );
        proc.setString( 1, mixid );
        ResultSet rs = proc.executeQuery();
        LinkedList<HashMap<String, Object>> list = new LinkedList<>();
        while( rs.next() ) {
            HashMap<String, Object> row = new HashMap();
            //Integer mixid = rs.getString(1);
            String nutrient_id_1 = rs.getString( 2 );
            String nutrient_id_2 = rs.getString( 3 );
            Integer relationshipid = rs.getInt( 4 );
            Double b = rs.getDouble( 5 );
            row.put( "NUTRIENT_ID_1", nutrient_id_1 );
            row.put( "NUTRIENT_ID_2", nutrient_id_2 );
            row.put( "RELATIONSHIPID", relationshipid );
            row.put( "B", b );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public double[] nutrientratio_lhs( String mixid, String nutrientid1, String nutrientid2, Integer relationshipid ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.nutrientratio_lhs(?,?,?,?)}" );
        proc.setString( 1, mixid );
        proc.setString( 2, nutrientid1 );
        proc.setString( 3, nutrientid2 );
        proc.setInt( 4, relationshipid );
        ResultSet rs = proc.executeQuery();
        LinkedList<Double> list = new LinkedList<>();
        while( rs.next() ) {
            //String foodid = rs.getString(1);
            double c = rs.getDouble( 2 );
            list.add( c );
        }
        proc.close();
        int size = list.size();
        double[] coefficients = new double[ size ];
        for( int i = 0; i < size; i++ ) {
            coefficients[ i ] = list.get( i ).doubleValue();
        }
        return coefficients;
    }

    public List<Map<String, Object>> MixFood_Select( String MixId ) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.MixFood_Select( ? )}" );
        proc.setString( 1, MixId );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "MIXID", rs.getObject( 1 ) );
            row.put( "FOODID", rs.getObject( 2 ) );
            row.put( "X", rs.getObject( 3 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public void MixFood_Update( String MixId, String FoodId, Double x ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.MixFood_Update( ?, ?, ? )}" );
        proc.setString( 1, MixId );
        proc.setString( 2, FoodId );
        proc.setDouble( 3, x );
        proc.execute();
    }

    public void Mix_Update_Name( String MixId, String Name ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.Mix_Update_Name( ?, ?)}" );
        proc.setString( 1, MixId );
        proc.setString( 2, Name );
        proc.execute();
    }

    public void Mix_Update_NutrientId( String MixId, String NutrientId ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.Mix_Update_NutrientId( ?, ?)}" );
        proc.setString( 1, MixId );
        proc.setString( 2, NutrientId );
        proc.execute();
    }

    public void Mix_Update_Other( String MixId, String Model ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.Mix_Update_Other( ?, ?)}" );
        proc.setString( 1, MixId );
        proc.setString( 2, Model );
        proc.execute();
    }

    public List<Map<String, Object>> MixResult_Select( String MixId, Integer Precision ) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.MixResult_Select(?,?)}" );
        proc.setString( 1, MixId );
        proc.setInt( 2, Precision );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "MixId", rs.getObject( 1 ) );
            row.put( "FoodId", rs.getObject( 2 ) );
            row.put( "Name", rs.getObject( 3 ) );
            //
            row.put( Nutrient.WEIGHT.getLabel(), rs.getObject( 4 ) );
            row.put( Nutrient.COMPLETEPROTEIN.getLabel(), rs.getObject( 5 ) );
            row.put( Nutrient.DIGESTIBLECARBOHYDRATE.getLabel(), rs.getObject( 6 ) );
            row.put( Nutrient.COST.getLabel(), rs.getObject( 7 ) );
            row.put( Nutrient.PROTEIN.getLabel(), rs.getObject( 8 ) );
            row.put( Nutrient.FAT.getLabel(), rs.getObject( 9 ) );
            row.put( Nutrient.CARBOHYDRATEBYDIFFERENCE.getLabel(), rs.getObject( 10 ) );
            row.put( Nutrient.ENERGYGROSS.getLabel(), rs.getObject( 11 ) );
            row.put( Nutrient.ALCOHOL.getLabel(), rs.getObject( 12 ) );
            row.put( Nutrient.WATER.getLabel(), rs.getObject( 13 ) );
            row.put( Nutrient.FIBER.getLabel(), rs.getObject( 14 ) );
            row.put( Nutrient.CALCIUM.getLabel(), rs.getObject( 15 ) );
            row.put( Nutrient.IRON.getLabel(), rs.getObject( 16 ) );
            row.put( Nutrient.MAGNESIUM.getLabel(), rs.getObject( 17 ) );
            row.put( Nutrient.PHOSPHORUS.getLabel(), rs.getObject( 18 ) );
            row.put( Nutrient.POTASSIUM.getLabel(), rs.getObject( 19 ) );
            row.put( Nutrient.SODIUM.getLabel(), rs.getObject( 20 ) );
            row.put( Nutrient.ZINC.getLabel(), rs.getObject( 21 ) );
            row.put( Nutrient.COPPER.getLabel(), rs.getObject( 22 ) );
            row.put( Nutrient.MANGANESE.getLabel(), rs.getObject( 23 ) );
            row.put( Nutrient.SELENIUM.getLabel(), rs.getObject( 24 ) );
            row.put( Nutrient.VITAMINA.getLabel(), rs.getObject( 25 ) );
            row.put( Nutrient.VITAMINE.getLabel(), rs.getObject( 26 ) );
            row.put( Nutrient.VITAMIND.getLabel(), rs.getObject( 27 ) );
            row.put( Nutrient.VITAMINC.getLabel(), rs.getObject( 28 ) );
            row.put( Nutrient.THIAMIN.getLabel(), rs.getObject( 29 ) );
            row.put( Nutrient.RIBOFLAVIN.getLabel(), rs.getObject( 30 ) );
            row.put( Nutrient.NIACIN.getLabel(), rs.getObject( 31 ) );
            row.put( Nutrient.PANTOTHENICACID.getLabel(), rs.getObject( 32 ) );
            row.put( Nutrient.VITAMINB6.getLabel(), rs.getObject( 33 ) );
            row.put( Nutrient.VITAMINB12.getLabel(), rs.getObject( 34 ) );
            row.put( Nutrient.CHOLINE.getLabel(), rs.getObject( 35 ) );
            row.put( Nutrient.VITAMINK.getLabel(), rs.getObject( 36 ) );
            row.put( Nutrient.FOLATE.getLabel(), rs.getObject( 37 ) );
            row.put( Nutrient.CHOLESTEROL.getLabel(), rs.getObject( 38 ) );
            row.put( Nutrient.SFA.getLabel(), rs.getObject( 39 ) );
            row.put( Nutrient.DHA.getLabel(), rs.getObject( 40 ) );
            row.put( Nutrient.EPA.getLabel(), rs.getObject( 41 ) );
            row.put( Nutrient.MUFA.getLabel(), rs.getObject( 42 ) );
            row.put( Nutrient.PUFA.getLabel(), rs.getObject( 43 ) );
            row.put( Nutrient.LINOLEIC.getLabel(), rs.getObject( 44 ) );
            row.put( Nutrient.LINOLENIC.getLabel(), rs.getObject( 45 ) );
            row.put( Nutrient.GLYCEMICLOAD.getLabel(), rs.getObject( 46 ) );
            row.put( Nutrient.ENERGYDIGESTIBLE.getLabel(), rs.getObject( 47 ) );
            row.put( Nutrient.ENERGYCARBOHYDRATE.getLabel(), rs.getObject( 48 ) );
            row.put( Nutrient.ENERGYPROTEIN.getLabel(), rs.getObject( 49 ) );
            row.put( Nutrient.ENERGYFAT.getLabel(), rs.getObject( 50 ) );
            row.put( Nutrient.ENERGYALCOHOL.getLabel(), rs.getObject( 51 ) );
            row.put( Nutrient.ENERGYFATCARBOHYDRATE.getLabel(), rs.getObject( 52 ) );
            //
            list.add( row );
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Food_Select_Details( Integer Precision ) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.Food_Select_Details(?)}" );
        proc.setInt( 1, Precision );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "Name", rs.getObject( 1 ) );
            row.put( Nutrient.WEIGHT.getLabel(), rs.getObject( 2 ) );
            row.put( Nutrient.ENERGYGROSS.getLabel(), rs.getObject( 3 ) );
            row.put( Nutrient.ENERGYDIGESTIBLE.getLabel(), rs.getObject( 4 ) );
            row.put( Nutrient.ENERGYCARBOHYDRATE.getLabel(), rs.getObject( 5 ) );
            row.put( Nutrient.ENERGYPROTEIN.getLabel(), rs.getObject( 6 ) );
            row.put( Nutrient.ENERGYFAT.getLabel(), rs.getObject( 7 ) );
            row.put( Nutrient.ENERGYALCOHOL.getLabel(), rs.getObject( 8 ) );
            row.put( Nutrient.ENERGYFATCARBOHYDRATE.getLabel(), rs.getObject( 9 ) );
            row.put( Nutrient.FAT.getLabel(), rs.getObject( 10 ) );
            row.put( Nutrient.DIGESTIBLECARBOHYDRATE.getLabel(), rs.getObject( 11 ) );
            row.put( Nutrient.PROTEIN.getLabel(), rs.getObject( 12 ) );
            row.put( Nutrient.ALCOHOL.getLabel(), rs.getObject( 13 ) );
            row.put( Nutrient.COMPLETEPROTEIN.getLabel(), rs.getObject( 14 ) );
            row.put( Nutrient.CARBOHYDRATEBYDIFFERENCE.getLabel(), rs.getObject( 15 ) );
            row.put( Nutrient.FIBER.getLabel(), rs.getObject( 16 ) );
            row.put( Nutrient.CALCIUM.getLabel(), rs.getObject( 17 ) );
            row.put( Nutrient.IRON.getLabel(), rs.getObject( 18 ) );
            row.put( Nutrient.MAGNESIUM.getLabel(), rs.getObject( 19 ) );
            row.put( Nutrient.PHOSPHORUS.getLabel(), rs.getObject( 20 ) );
            row.put( Nutrient.POTASSIUM.getLabel(), rs.getObject( 21 ) );
            row.put( Nutrient.SODIUM.getLabel(), rs.getObject( 22 ) );
            row.put( Nutrient.ZINC.getLabel(), rs.getObject( 23 ) );
            row.put( Nutrient.COPPER.getLabel(), rs.getObject( 24 ) );
            row.put( Nutrient.MANGANESE.getLabel(), rs.getObject( 25 ) );
            row.put( Nutrient.SELENIUM.getLabel(), rs.getObject( 26 ) );
            row.put( Nutrient.VITAMINA.getLabel(), rs.getObject( 27 ) );
            row.put( Nutrient.VITAMINE.getLabel(), rs.getObject( 28 ) );
            row.put( Nutrient.VITAMIND.getLabel(), rs.getObject( 29 ) );
            row.put( Nutrient.VITAMINC.getLabel(), rs.getObject( 30 ) );
            row.put( Nutrient.THIAMIN.getLabel(), rs.getObject( 31 ) );
            row.put( Nutrient.RIBOFLAVIN.getLabel(), rs.getObject( 32 ) );
            row.put( Nutrient.NIACIN.getLabel(), rs.getObject( 33 ) );
            row.put( Nutrient.PANTOTHENICACID.getLabel(), rs.getObject( 34 ) );
            row.put( Nutrient.VITAMINB6.getLabel(), rs.getObject( 35 ) );
            row.put( Nutrient.VITAMINB12.getLabel(), rs.getObject( 36 ) );
            row.put( Nutrient.CHOLINE.getLabel(), rs.getObject( 37 ) );
            row.put( Nutrient.VITAMINK.getLabel(), rs.getObject( 38 ) );
            row.put( Nutrient.FOLATE.getLabel(), rs.getObject( 39 ) );
            row.put( Nutrient.CHOLESTEROL.getLabel(), rs.getObject( 40 ) );
            row.put( Nutrient.SFA.getLabel(), rs.getObject( 41 ) );
            row.put( Nutrient.DHA.getLabel(), rs.getObject( 42 ) );
            row.put( Nutrient.EPA.getLabel(), rs.getObject( 43 ) );
            row.put( Nutrient.MUFA.getLabel(), rs.getObject( 44 ) );
            row.put( Nutrient.PUFA.getLabel(), rs.getObject( 45 ) );
            row.put( Nutrient.LINOLEIC.getLabel(), rs.getObject( 46 ) );
            row.put( Nutrient.LINOLENIC.getLabel(), rs.getObject( 47 ) );
            row.put( Nutrient.GLYCEMICLOAD.getLabel(), rs.getObject( 48 ) );
            row.put( Nutrient.WATER.getLabel(), rs.getObject( 49 ) );
            row.put( Nutrient.COST.getLabel(), rs.getObject( 50 ) );
            row.put( "FoodId", rs.getObject( 51 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> FoodCategory_Select_All() throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.FoodCategory_Select_All()}" );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "FOODCATEGORYID", rs.getObject( 1 ) );
            row.put( "NAME", rs.getObject( 2 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Food_Select_By_Category( String FoodCategoryId ) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.Food_Select_By_Category( ? )}" );
        proc.setString( 1, FoodCategoryId );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "FOODID", rs.getObject( 1 ) );
            row.put( "NAME", rs.getObject( 2 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public void FoodCategory_Insert( String categoryid, String categoryname ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.FoodCategory_Insert( ?, ? )}" );
        proc.setString( 1, categoryid );
        proc.setString( 2, categoryname );
        proc.execute();
    }

    public void FoodCategory_Insert_2( String Name ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.FoodCategory_Insert_2(  ? )}" );
        proc.setString( 1, Name );
        proc.execute();
    }

    public void FoodCategory_Delete( String FoodCategoryId ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.FoodCategory_Delete( ? )}" );
        proc.setString( 1, FoodCategoryId );
        proc.execute();
    }

    public void FoodCategory_Update( String FoodCategoryId, String Name ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.FoodCategory_Update( ?, ? )}" );
        proc.setString( 1, FoodCategoryId );
        proc.setString( 2, Name );
        proc.execute();
    }

    public void CategoryLink_Insert( String FoodCategoryId, String FoodId ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.CategoryLink_Insert( ?, ? )}" );
        //Different order in procedure
        proc.setString( 1, FoodId );
        proc.setString( 2, FoodCategoryId );
        proc.execute();
    }

    public void CategoryLink_Delete( String FoodCategoryId, String FoodId ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.CategoryLink_Delete( ?, ? )}" );
        proc.setString( 1, FoodCategoryId );
        proc.setString( 2, FoodId );
        proc.execute();
    }

    public void Food_Delete( String FoodId ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.Food_Delete( ? )}" );
        proc.setString( 1, FoodId );
        proc.execute();
    }

    public List<Map<String, Object>> MixResult_Select_Pct( String MixId, Integer Precision ) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.MixResult_Select_Pct( ?,?)}" );
        proc.setString( 1, MixId );
        proc.setInt( 2, Precision );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "CALORIES", rs.getObject( 1 ) );
            row.put( "FAT", rs.getObject( 2 ) );
            row.put( "CARBS", rs.getObject( 3 ) );
            row.put( "PROTEIN", rs.getObject( 4 ) );
            row.put( "ALCOHOL", rs.getObject( 5 ) );
            row.put( "FQ", rs.getObject( 6 ) );
            row.put( "SATFAT", rs.getObject( 7 ) );
            row.put( "MONOUFAT", rs.getObject( 8 ) );
            row.put( "POLYUFAT", rs.getObject( 9 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public void Mix_Duplicate( String MixId ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.Mix_Duplicate( ? )}" );
        proc.setString( 1, MixId );
        proc.execute();
    }

    public void Mix_Update_Time( String MixId ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.Mix_Update_Time( ? )}" );
        proc.setString( 1, MixId );
        proc.execute();
    }

    public void Mix_Update_Status( String MixId, Integer Status ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.Mix_Update_Status( ?,? )}" );
        proc.setString( 1, MixId );
        proc.setInt( 2, Status );
        proc.execute();
    }

    public List<Map<String, Object>> get_food_differences( String food_id_a, String food_id_b, Integer precision ) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.food_differences_procedure( ?,?,?)}" );
        proc.setString( 1, food_id_a );
        proc.setString( 2, food_id_b );
        proc.setInt( 3, precision );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "CATEGORY", rs.getObject( 1 ) );
            row.put( "NUTRIENT", rs.getObject( 2 ) );
            row.put( "FOODA", rs.getObject( 3 ) );
            row.put( "FOODB", rs.getObject( 4 ) );
            row.put( "DIFF", rs.getObject( 5 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Mix_GetDiff( String MixId1, String MixId2, Integer Precision ) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.Mix_getDiff( ?,?,?)}" );
        proc.setString( 1, MixId1 );
        proc.setString( 2, MixId2 );
        proc.setInt( 3, Precision );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "CATEGORY", rs.getObject( 1 ) );
            row.put( "NUTRIENT", rs.getObject( 2 ) );
            row.put( "MIXA", rs.getObject( 3 ) );
            row.put( "MIXB", rs.getObject( 4 ) );
            row.put( "DIFF", rs.getObject( 5 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Mix_GetRdaDiff( String MixId, Integer LifeStage, Integer Precision ) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.Mix_getRdaDiff(?,?,?)}" );
        proc.setString( 1, MixId );
        proc.setInt( 2, LifeStage );
        proc.setInt( 3, Precision );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "NUTRIENTID", rs.getObject( 1 ) );
            row.put( "NAME", rs.getObject( 2 ) );
            row.put( "MIX", rs.getObject( 3 ) );
            row.put( "RDA", rs.getObject( 4 ) );
            row.put( "PCTRDA", rs.getObject( 5 ) );
            row.put( "UL", rs.getObject( 6 ) );
            row.put( "PCTUL", rs.getObject( 7 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Mix_GetFQDiff( String MixId1, String MixId2 ) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.Mix_getFQDiff( ?,?)}" );
        proc.setString( 1, MixId1 );
        proc.setString( 2, MixId2 );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "NUTRIENT", rs.getObject( 1 ) );
            row.put( "MIX1", rs.getObject( 2 ) );
            row.put( "MIX2", rs.getObject( 3 ) );
            row.put( "DIFF", rs.getObject( 4 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Mix_GetMealGIDiff( String MixId1, String MixId2, Integer Precision ) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.Mix_getMealGIDiff( ?,?,?)}" );
        proc.setString( 1, MixId1 );
        proc.setString( 2, MixId2 );
        proc.setInt( 3, Precision );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "NUTRIENT", rs.getObject( 1 ) );
            row.put( "MIX1", rs.getObject( 2 ) );
            row.put( "MIX2", rs.getObject( 3 ) );
            row.put( "DIFF", rs.getObject( 4 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Nutrient_Lookup_List( String NutrientId, Double value, Integer Precision ) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.Nutrient_Lookup_List(?,?,?)}" );
        proc.setString( 1, NutrientId );
        proc.setDouble( 2, value );
        proc.setInt( 3, Precision );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "NAME", rs.getObject( 1 ) );
            row.put( "CALORIES", rs.getObject( 2 ) );
            row.put( "WEIGHT", rs.getObject( 3 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public void Food_Put( String MixId ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.Food_Put( ? )}" );
        proc.setString( 1, MixId );
        proc.execute();
    }

    public Integer CategoryLink_Count( String FoodId, String FoodCategoryId ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.CategoryLink_Count(?,?)}" );
        proc.setString( 1, FoodId );
        proc.setString( 2, FoodCategoryId );
        proc.execute();
        ResultSet resultSet = proc.getResultSet();
        resultSet.next();
        Integer out = resultSet.getInt( 1 );
        proc.close();
        return out;
    }

    public List<Map<String, Object>> Food_Select_All_Like( String txt ) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.Food_Select_All_Like(?)}" );
        proc.setString( 1, txt );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "FOODID", rs.getObject( 1 ) );
            row.put( "NAME", rs.getObject( 2 ) );
            list.add( row );
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
            stmt.executeUpdate( sql );
            stmt.close();
        } catch( SQLException e ) {

        }
    }

    public void NutrientPercentConstraint_Merge( String mixId, String foodid, String nutr_no, Integer relationshipId, Double b ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.PercentNutrientConstraint_Merge( ?, ?, ?, ?, ? )}" );
        proc.setString( 1, mixId );
        proc.setString( 2, foodid );
        proc.setString( 3, nutr_no );
        proc.setInt( 4, relationshipId );
        proc.setDouble( 5, b );
        proc.execute();
    }

    public void PercentNutrientConstraint_Delete( String mixid, String foodid, String nutrientid, Integer relationshipid ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.PercentNutrientConstraint_Delete( ?, ?, ?, ?)}" );
        proc.setString( 1, mixid );
        proc.setString( 2, foodid );
        proc.setString( 3, nutrientid );
        proc.setInt( 4, relationshipid );
        proc.execute();
    }

    public List<Map<String, Object>> PercentNutrientConstraint_Select( String mixid ) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.PercentNutrientConstraint_Select( ?)}" );
        proc.setString( 1, mixid );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            row.put( "MIXID", rs.getObject( 1 ) );
            row.put( "FOODID", rs.getObject( 2 ) );
            row.put( "NUTRIENTID", rs.getObject( 3 ) );
            row.put( "RELATIONSHIPID", rs.getObject( 4 ) );
            row.put( "FOOD", rs.getObject( 5 ) );
            row.put( "NUTRIENT", rs.getObject( 6 ) );
            row.put( "B", rs.getObject( 7 ) );
            row.put( "RELATIONSHIP", rs.getObject( 8 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public List percentnutrient_rhs( String mixId ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.percentnutrient_rhs(?)}" );
        proc.setString( 1, mixId );
        ResultSet rs = proc.executeQuery();
        LinkedList<HashMap<String, Object>> list = new LinkedList<>();
        while( rs.next() ) {
            HashMap<String, Object> row = new HashMap();
            //Integer mixid = rs.getString(1);
            String foodid = rs.getString( 2 );
            String nutrientid = rs.getString( 3 );
            Integer relationshipid = rs.getInt( 4 );
            Double b = rs.getDouble( 5 );
            row.put( "FOODID", foodid );
            row.put( "NUTRIENTID", nutrientid );
            row.put( "RELATIONSHIPID", relationshipid );
            row.put( "B", b );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public double[] percentnutrient_lhs( String mixId, String foodid, String nutrientid, Double b ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.percentnutrient_lhs(?,?,?,?)}" );
        proc.setString( 1, mixId );
        proc.setString( 2, foodid );
        proc.setString( 3, nutrientid );
        proc.setDouble( 4, b );
        ResultSet rs = proc.executeQuery();
        LinkedList<Double> list = new LinkedList<>();
        while( rs.next() ) {
            //String foodid = rs.getString(1);
            double c = rs.getDouble( 2 );
            list.add( c );
        }
        proc.close();
        int size = list.size();
        double[] coefficients = new double[ size ];
        for( int i = 0; i < size; i++ ) {
            coefficients[ i ] = list.get( i ).doubleValue();
        }
        return coefficients;
    }

    public void Nutrient_Update( String NutrientId, Integer Visible ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.Nutrient_Update( ?, ?)}" );
        proc.setString( 1, NutrientId );
        proc.setInt( 2, Visible );
        proc.execute();
    }

    public String Food_Insert_Temp( String foodName ) throws SQLException {
        CallableStatement proc;
        String out = null;
        proc = connection.prepareCall( "{CALL public.Food_Insert_Temp (?,?)}" );
        proc.registerOutParameter( 1, Types.LONGVARCHAR );
        proc.setString( 2, foodName );
        proc.execute();
        out = proc.getString( 1 );
        proc.close();
        return out;
    }

    public String snack_food_insertfood( String foodid, String foodName ) throws SQLException {
        CallableStatement proc;
        String out = null;
        proc = connection.prepareCall( "{CALL public.snack_food_insertfood(?, ?)}" );
        proc.setString( 1, foodid );
        proc.setString( 2, foodName );
        proc.execute();
        proc.close();
        return out;
    }

    public void Food_Update( FoodDataObject foodDataObject ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.Food_Update( ?, ? )}" );
        proc.setString( 1, foodDataObject.getFoodId() );
        proc.setString( 2, foodDataObject.getFoodName() );
        proc.execute();
        proc.close();
    }

    public List<FoodDataObject> Food_Select( FoodDataObject foodDataObject ) throws SQLException {
        LinkedList<FoodDataObject> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.Food_Select( ? )}" );
        proc.setString( 1, foodDataObject.getFoodId() );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            foodDataObject.setFoodId( rs.getString( 1 ) );
            foodDataObject.setFoodName( rs.getString( 2 ) );
            list.add( foodDataObject );
        }
        proc.close();
        return list;
    }

    public List<FoodFactSelectForDataInputDataObject> FoodFact_Select_ForDataInput( String FoodId, Integer Precision ) throws SQLException {
        LinkedList<FoodFactSelectForDataInputDataObject> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.FoodFact_Select_ForDataInput( ?,? )}" );
        proc.setString( 1, FoodId );
        proc.setInt( 2, Precision );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            FoodFactSelectForDataInputDataObject foodFactSelectForDataInputDataObject = new FoodFactSelectForDataInputDataObject();
            foodFactSelectForDataInputDataObject.setNutrientId( rs.getString( 1 ) );
            foodFactSelectForDataInputDataObject.setCategory( rs.getString( 2 ) );
            foodFactSelectForDataInputDataObject.setNutrient( rs.getString( 3 ) );
            foodFactSelectForDataInputDataObject.setQ( rs.getDouble( 4 ) );
            list.add( foodFactSelectForDataInputDataObject );
        }
        proc.close();
        return list;
    }

    public List<FoodFactSelectForCheckCoefficientsDataObject> FoodFact_Select_ForCheckCoefficients( String FoodId, Integer Precision ) throws SQLException {
        LinkedList<FoodFactSelectForCheckCoefficientsDataObject> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.FoodFact_Select_ForCheckCoefficient( ?,? )}" );
        proc.setString( 1, FoodId );
        proc.setInt( 2, Precision );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            FoodFactSelectForCheckCoefficientsDataObject foodFactSelectForCheckCoefficientsDataObject = new FoodFactSelectForCheckCoefficientsDataObject();
            foodFactSelectForCheckCoefficientsDataObject.setNutrientId( rs.getString( 1 ) );
            foodFactSelectForCheckCoefficientsDataObject.setCategory( rs.getString( 2 ) );
            foodFactSelectForCheckCoefficientsDataObject.setNutrient( rs.getString( 3 ) );
            foodFactSelectForCheckCoefficientsDataObject.setQ( rs.getDouble( 4 ) );
            foodFactSelectForCheckCoefficientsDataObject.setC( rs.getDouble( 5 ) );
            list.add( foodFactSelectForCheckCoefficientsDataObject );
        }
        proc.close();
        return list;
    }

    public void FoodFact_Merge( String foodid, String nutrientid, Double q ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.FoodFact_Merge( ?, ?, ?)}" );
        proc.setString( 1, foodid );
        proc.setString( 2, nutrientid );
        proc.setDouble( 3, q );
        proc.execute();
    }

    public void DuplicateFoodItem( String foodId ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.DuplicateFoodItem( ? )}" );
        proc.setString( 1, foodId );
        proc.execute();
    }

    public List Mix_GetMealGi( String mixid, Integer precision ) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.Mix_getMealGI( ?,?)}" );
        proc.setString( 1, mixid );
        proc.setInt( 2, precision );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            String name = rs.getString( 1 );
            Double weight = rs.getDouble( 2 );
            Double carbs = rs.getDouble( 3 );
            Double pct = rs.getDouble( 4 );
            Double gl = rs.getDouble( 5 );
            Double gi = rs.getDouble( 6 );
            Double mealgi = rs.getDouble( 7 );
            row.put( "name", name );
            row.put( "weight", weight );
            row.put( "carbs", carbs );
            row.put( "pct", pct );
            row.put( "gl", gl );
            row.put( "gi", gi );
            row.put( "mealgi", mealgi );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public void fill_mixresult( String mixId ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.fill_mixresult( ? )}" );
        proc.setString( 1, mixId );
        proc.execute();
    }

    public void fill_mixresultdn( String mixId ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.fill_mixresultdn( ? )}" );
        proc.setString( 1, mixId );
        proc.execute();
    }

    public List<Map<String, Object>> Select_mixfood_foodfacts( Integer mix_id ) throws SQLException {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.Select_mixfood_foodfacts(?)}" );
        proc.setInt( 1, mix_id );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            Map<String, Object> row = new HashMap<>();
            //Mix id
            row.put( "mix_id", rs.getObject( 1 ) );
            //Mix food quantity
            row.put( "mix_x", rs.getObject( 2 ) );
            //Mix food name
            row.put( "food_name", rs.getObject( 3 ) );
            //Weight
            row.put( Nutrient.WEIGHT.getLabel(), rs.getObject( 4 ) );
            //EnergyGross
            row.put( Nutrient.ENERGYGROSS.getLabel(), rs.getObject( 5 ) );
            //EnergyDigestible
            row.put( Nutrient.ENERGYDIGESTIBLE.getLabel(), rs.getObject( 6 ) );
            //EnergyCarbohydrate
            row.put( Nutrient.ENERGYCARBOHYDRATE.getLabel(), rs.getObject( 7 ) );
            //EnergyProtein
            row.put( Nutrient.ENERGYPROTEIN.getLabel(), rs.getObject( 8 ) );
            //EnergyFat
            row.put( Nutrient.ENERGYFAT.getLabel(), rs.getObject( 9 ) );
            //EnergyAlcohol
            row.put( Nutrient.ENERGYALCOHOL.getLabel(), rs.getObject( 10 ) );
            //Fat
            row.put( Nutrient.FAT.getLabel(), rs.getObject( 11 ) );
            //DigestibleCarbs
            row.put( Nutrient.DIGESTIBLECARBOHYDRATE.getLabel(), rs.getObject( 12 ) );
            //Protein
            row.put( Nutrient.PROTEIN.getLabel(), rs.getObject( 13 ) );
            //Alcohol
            row.put( Nutrient.ALCOHOL.getLabel(), rs.getObject( 14 ) );
            //CompleteProtein
            row.put( Nutrient.COMPLETEPROTEIN.getLabel(), rs.getObject( 15 ) );
            //CarbsByDiff
            row.put( Nutrient.CARBOHYDRATEBYDIFFERENCE.getLabel(), rs.getObject( 16 ) );
            //Fiber
            row.put( Nutrient.FIBER.getLabel(), rs.getObject( 17 ) );
            //Calcium
            row.put( Nutrient.CALCIUM.getLabel(), rs.getObject( 18 ) );
            //Iron
            row.put( Nutrient.IRON.getLabel(), rs.getObject( 19 ) );
            //Magnesium
            row.put( Nutrient.MAGNESIUM.getLabel(), rs.getObject( 20 ) );
            //Phosphorus
            row.put( Nutrient.PHOSPHORUS.getLabel(), rs.getObject( 21 ) );
            //Potassium
            row.put( Nutrient.POTASSIUM.getLabel(), rs.getObject( 22 ) );
            //Sodium
            row.put( Nutrient.SODIUM.getLabel(), rs.getObject( 23 ) );
            //Zinc
            row.put( Nutrient.ZINC.getLabel(), rs.getObject( 24 ) );
            //Copper
            row.put( Nutrient.COPPER.getLabel(), rs.getObject( 25 ) );
            //Manganese
            row.put( Nutrient.MANGANESE.getLabel(), rs.getObject( 26 ) );
            //Selenium
            row.put( Nutrient.SELENIUM.getLabel(), rs.getObject( 27 ) );
            //VitaminA
            row.put( Nutrient.VITAMINA.getLabel(), rs.getObject( 28 ) );
            //VitaminE
            row.put( Nutrient.VITAMINE.getLabel(), rs.getObject( 29 ) );
            //VitaminD
            row.put( Nutrient.VITAMIND.getLabel(), rs.getObject( 30 ) );
            //VitaminC
            row.put( Nutrient.VITAMINC.getLabel(), rs.getObject( 31 ) );
            //Thiamin
            row.put( Nutrient.THIAMIN.getLabel(), rs.getObject( 32 ) );
            //Riboflavin
            row.put( Nutrient.RIBOFLAVIN.getLabel(), rs.getObject( 33 ) );
            //Niacin
            row.put( Nutrient.NIACIN.getLabel(), rs.getObject( 34 ) );
            //Pantothenic
            row.put( Nutrient.PANTOTHENICACID.getLabel(), rs.getObject( 35 ) );
            //VitaminB6
            row.put( Nutrient.VITAMINB6.getLabel(), rs.getObject( 36 ) );
            //VitaminB12
            row.put( Nutrient.VITAMINB12.getLabel(), rs.getObject( 37 ) );
            //Choline
            row.put( Nutrient.CHOLINE.getLabel(), rs.getObject( 38 ) );
            //VitaminK
            row.put( Nutrient.VITAMINK.getLabel(), rs.getObject( 39 ) );
            //Folate
            row.put( Nutrient.FOLATE.getLabel(), rs.getObject( 40 ) );
            //Cholesterol
            row.put( Nutrient.CHOLESTEROL.getLabel(), rs.getObject( 41 ) );
            //Saturated
            row.put( Nutrient.SFA.getLabel(), rs.getObject( 42 ) );
            //DHA
            row.put( Nutrient.DHA.getLabel(), rs.getObject( 43 ) );
            //EPA
            row.put( Nutrient.EPA.getLabel(), rs.getObject( 44 ) );
            //Monounsaturated
            row.put( Nutrient.MUFA.getLabel(), rs.getObject( 45 ) );
            //Polyunsaturated
            row.put( Nutrient.PUFA.getLabel(), rs.getObject( 46 ) );
            //Linoleic
            row.put( Nutrient.LINOLEIC.getLabel(), rs.getObject( 47 ) );
            //AlphaLinolenic
            row.put( Nutrient.LINOLENIC.getLabel(), rs.getObject( 48 ) );
            //GlycemicLoad
            row.put( Nutrient.GLYCEMICLOAD.getLabel(), rs.getObject( 49 ) );
            //Water
            row.put( Nutrient.WATER.getLabel(), rs.getObject( 50 ) );
            //Cost
            row.put( Nutrient.COST.getLabel(), rs.getObject( 51 ) );
            //Foodid
            row.put( "FoodId", rs.getObject( 52 ) );
            list.add( row );
        }
        proc.close();
        return list;
    }

    public String export_mix( String mixid ) throws SQLException {
        String doc = "";
        CallableStatement proc;
        proc = connection.prepareCall( "{CALL public.Export_xml( ? )}" );
        proc.setString( 1, mixid );
        ResultSet rs = proc.executeQuery();
        while( rs.next() ) {
            doc = rs.getString( 1 );
        }
        proc.close();
        return doc;
    }

    public void delete_mixresultdn( String mixid ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.mixresultdn_delete( ? )}" );
        proc.setString( 1, mixid );
        proc.execute();
    }

    public void pin_mix( String MixId ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.pin_mix( ? )}" );
        proc.setString( 1, MixId );
        proc.execute();
    }

    public void allocate( String MixId ) throws SQLException {
        CallableStatement proc = connection.prepareCall( "{CALL public.allocate( ? )}" );
        proc.setString( 1, MixId );
        proc.execute();
    }
}
