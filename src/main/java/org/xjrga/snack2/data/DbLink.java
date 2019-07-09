package org.xjrga.snack2.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DbLink
{
    private Connection connection;

    public DbLink()
    {

        connection = Connect.getInstance().getConnection();

        /*try
        {
            Class.forName("org.hsqldb.jdbcDriver");
            connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/database", "SA", "");
            //connection = DriverManager.getConnection("jdbc.url=jdbc:hsqldb:file:data/database/sr28", "SA", "");
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

    /*public static void main(String[] args)
    {
        DbLink2 test = new DbLink2();
    }*/


    public List<Map<String, Object>> Food_Select_All() throws SQLException
    {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.Food_Select_All()}");
        ResultSet rs = proc.executeQuery();
        while (rs.next())
        {
            Map<String, Object> row = new HashMap<>();
            for (int columnPos = 0; columnPos < 2; columnPos++)
            {
                row.put("CATEGORY", rs.getObject(1));
                row.put("FOOD", rs.getObject(2));
            }
            list.add(row);
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Nutrient_Select_All() throws SQLException
    {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.Nutrient_Select_All()}");
        ResultSet rs = proc.executeQuery();
        while (rs.next())
        {
            Map<String, Object> row = new HashMap<>();
            for (int columnPos = 0; columnPos < 2; columnPos++)
            {
                row.put("NUTRIENTID", rs.getObject(1));
                row.put("NAME", rs.getObject(2));
            }
            list.add(row);
        }
        proc.close();
        return list;
    }

    public List<Map<String, Object>> Relationship_Select_All() throws SQLException
    {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        CallableStatement proc;
        proc = connection.prepareCall("{CALL public.Relationship_Select_All()}");
        ResultSet rs = proc.executeQuery();
        while (rs.next())
        {
            Map<String, Object> row = new HashMap<>();
            for (int columnPos = 0; columnPos < 2; columnPos++)
            {
                row.put("RELATIONSHIPID", rs.getObject(1));
                row.put("NAME", rs.getObject(2));
            }
            list.add(row);
        }
        proc.close();
        return list;
    }


}



