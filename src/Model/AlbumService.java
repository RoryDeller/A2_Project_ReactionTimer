package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AlbumService {

    public static void selectAll(List<Album> targetList, DatabaseConnection database){

        PreparedStatement statement = database.newStatement("SELECT albumID, albumName FROM Albums ORDER BY albumID");

        try {
            if (statement != null) {

                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Album(results.getInt("albumID"), results.getString("albumName")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }



    }
    public static Album selectByID(int id, DatabaseConnection database){

        Album result = null;

        PreparedStatement statement = database.newStatement("SELECT albumID, albumName FROM Albums WHERE albumID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    result = new Album(results.getInt("albumID"), results.getString("albumName"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;


    }
    public static void save(Album itemToSave, DatabaseConnection database){

        Album existingItem = null;
        if (itemToSave.getAlbumID() != 0) existingItem = selectByID(itemToSave.getAlbumID(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO Albums (albumID, albumName) VALUES (?, ?, ?))");
                statement.setInt(1, itemToSave.getAlbumID());
                statement.setString(2, itemToSave.getAlbumName());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE Albums SET albumID = ?, albumName = ? WHERE albumID = ?");
                statement.setInt(1, itemToSave.getAlbumID());
                statement.setString(2, itemToSave.getAlbumName());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }


    } //Insert and Update
    public static void deleteByID(int id, DatabaseConnection database){

        PreparedStatement statement = database.newStatement("DELETE FROM Albums WHERE albumID = ?");

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
