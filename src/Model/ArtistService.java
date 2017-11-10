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
    //public static Artist selectByID(int id, DatabaseConnection database){}
    //public static void save(Artist artist, DatabaseConnection database){} //Insert and Update
    //public static void deleteByID(int id, DatabaseConnection database){}
}
