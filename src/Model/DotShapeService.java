package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DotShapeService {

    public static void selectAll(List<DotShape> targetList, DatabaseConnection database){

        PreparedStatement statement = database.newStatement("SELECT shapeID, dotOrder, shapeType FROM DotShapes ORDER BY shapeID");

        try {
            if (statement != null) {

                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new DotShape(results.getInt("shapeID"), results.getInt("dotOrder"), results.getString("shapeType")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }

    public static DotShape selectByID(int id, DatabaseConnection database){


        DotShape result = null;

        PreparedStatement statement = database.newStatement("SELECT shapeID, dotOrder, shapeType FROM DotShapes WHERE shapeID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    result = new DotShape(results.getInt("shapeID"), results.getInt("dotOrder"), results.getString("shapeType"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;

    }

    public static void save(DotShape itemToSave, DatabaseConnection database){

        DotShape existingItem = null;
        if (itemToSave.getShapeID() != 0) existingItem = selectByID(itemToSave.getShapeID(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO DotShapes (shapeID, dotOrder, shapeType) VALUES (?, ?, ?))");
                statement.setInt(1, itemToSave.getShapeID());
                statement.setInt(2, itemToSave.getDotOrder());
                statement.setString(2, itemToSave.getShapeType());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE DotShapes SET shapeID = ?, DotOrder = ?, shapeType = ? WHERE shapeID = ?");
                statement.setInt(1, itemToSave.getShapeID());
                statement.setInt(2, itemToSave.getDotOrder());
                statement.setString(2, itemToSave.getShapeType());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }

    } //Insert and Update

     public static void deleteByID(int id, DatabaseConnection database){

         PreparedStatement statement = database.newStatement("DELETE FROM DotShapes WHERE ShapeID = ?");

         try {
             if (statement != null) {
                 statement.setInt(1, id);
                 database.executeUpdate(statement);
             }
         } catch (SQLException resultsException) {
             System.out.println("Database deletion error: " + resultsException.getMessage());
         }
     }




}
