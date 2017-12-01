package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GenreService {

    public static void selectAll(List<Genre> targetList, DatabaseConnection database){

        PreparedStatement statement = database.newStatement("SELECT genreID, genreName FROM Genres ORDER BY genreID");

        try {
            if (statement != null) {

                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Genre(results.getInt("genreID"), results.getString("genreName")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }

    }
    public static Genre selectByID(int id, DatabaseConnection database){


        Genre result = null;

        PreparedStatement statement = database.newStatement("SELECT genreID, genreName FROM Genres WHERE genreID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    result = new Genre(results.getInt("genreID"), results.getString("genreID"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }
    public static void save(Genre itemToSave, DatabaseConnection database){

        Genre existingItem = null;
        if (itemToSave.getGenreID() != 0) existingItem = selectByID(itemToSave.getGenreID(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO Genres (genreID, genreName) VALUES (?, ?))");
                statement.setInt(1, itemToSave.getGenreID());
                statement.setString(2, itemToSave.getGenreName());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE Genres SET genreID = ?, genreName = ? WHERE genreID = ?");
                statement.setInt(1, itemToSave.getGenreID());
                statement.setString(2, itemToSave.getGenreName());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }


    } //Insert and Update
    public static void deleteByID(int id, DatabaseConnection database){

        PreparedStatement statement = database.newStatement("DELETE FROM Genres WHERE genreID = ?");

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
