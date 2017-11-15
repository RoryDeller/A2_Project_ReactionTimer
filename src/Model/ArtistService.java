package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ArtistService {

    public static void selectAll(List<Artist> targetList, DatabaseConnection database){

        PreparedStatement statement = database.newStatement("SELECT artistID, albumID, artistFirstname, artistSurname, bandName FROM Artists ORDER BY artistID");

        try {
            if (statement != null) {

                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Artist(results.getInt("artistID"), results.getInt("albumID"), results.getString("artistFirstname"), results.getString("artistSurname"), results.getString("bandName")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }

    }
    public static Artist selectByID(int id, DatabaseConnection database){

        Artist result = null;

        PreparedStatement statement = database.newStatement("SELECT artistID, albumID, artistFirstname, artistSurname, bandName FROM Artists WHERE artistID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    result = new Artist(results.getInt("artistID"), results.getInt("albumID"), results.getString("artistFirstname"), results.getString("artistSurname"), results.getString("bandName"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;


    }


    public static void save(Artist itemToSave, DatabaseConnection database){

        Artist existingItem = null;
        if (itemToSave.getArtistID() != 0) existingItem = selectByID(itemToSave.getArtistID(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO Artists (artistID, albumID, artistFirstname, artistSurname, bandName) VALUES (?, ?, ?))");
                statement.setInt(1, itemToSave.getArtistID());
                statement.setInt(2, itemToSave.getAlbumID());
                statement.setString(2, itemToSave.getArtistFirstname());
                statement.setString(2, itemToSave.getArtistSurname());
                statement.setString(2, itemToSave.getBandName());



                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE Artists SET artistID = ?, albumID = ?, artistFirstname = ?, artistSurname = ?, bandName = ? WHERE albumID = ?");
                statement.setInt(1, itemToSave.getArtistID());
                statement.setInt(2, itemToSave.getAlbumID());
                statement.setString(2, itemToSave.getArtistFirstname());
                statement.setString(2, itemToSave.getArtistSurname());
                statement.setString(2, itemToSave.getBandName());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    } //Insert and Update

    public static void deleteByID(int id, DatabaseConnection database){

        PreparedStatement statement = database.newStatement("DELETE FROM Artists WHERE artistID = ?");

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
