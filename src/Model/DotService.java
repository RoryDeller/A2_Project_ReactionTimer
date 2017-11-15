package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DotService {


    public static void selectAll(List<Dot> targetList, DatabaseConnection database){

        PreparedStatement statement = database.newStatement("SELECT dotID, dotOrder, shapeID, colour, lifeTime, size, scoreValue FROM Dots ORDER BY dotID");

        try {
            if (statement != null) {

                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Dot(results.getInt("dotID"), results.getInt("dotOrder"),
                                results.getInt("shapeID"), results.getString("colour"), results.getDouble("lifeTime"),
                                results.getInt("size"), results.getInt("scoreValue")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }

    }

    public static Dot selectByID(int id, DatabaseConnection database){

        Dot result = null;

        PreparedStatement statement = database.newStatement("SELECT dotID, dotOrder, shapeID, colour, lifeTime, size, scoreValue FROM Dots WHERE dotID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    result = new Dot(results.getInt("dotID"), results.getInt("dotOrder"), results.getInt("shapeID"),
                            results.getString("colour"), results.getDouble("lifeTime"), results.getInt("size"), results.getInt("scoreValue"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }

    public static void save(Dot itemToSave, DatabaseConnection database){

        Dot existingItem = null;
        if (itemToSave.getDotID() != 0) existingItem = selectByID(itemToSave.getDotID(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO Dots (dotID, dotOrder, shapeID, colour, lifeTime, size, scoreValue) VALUES (?, ?, ?))");
                statement.setInt(1, itemToSave.getDotID());
                statement.setInt(2, itemToSave.getDotOrder());
                statement.setInt(2, itemToSave.getShapeID());
                statement.setString(1, itemToSave.getColour());
                statement.setInt(2, itemToSave.getSize());
                statement.setInt(2, itemToSave.getScoreValue());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE Dots SET dotID = ?, dotOrder = ?, shapeID = ? WHERE dotID = ?");
                statement.setInt(1, itemToSave.getDotID());
                statement.setInt(2, itemToSave.getDotOrder());
                statement.setInt(2, itemToSave.getShapeID());
                statement.setString(1, itemToSave.getColour());
                statement.setInt(2, itemToSave.getSize());
                statement.setInt(2, itemToSave.getScoreValue());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }

    } //Insert and Update

    public static void deleteByID(int id, DatabaseConnection database){

        PreparedStatement statement = database.newStatement("DELETE FROM Dots WHERE dotID = ?");

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
