package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LevelService {

    public static void selectAll(List<Level> destination, DatabaseConnection database){}
    //public static Level selectByID(int id, DatabaseConnection database){}
    //public static void save(Level level, DatabaseConnection database){} //Insert and Update
    //public static void deleteByID(int id, DatabaseConnection database){}

    public static void selectLevelDots(Level selectedItem, List<DotsInLevel> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT levelID, dotID FROM DotsInLevels WHERE levelID = ?");

        try {
            if (statement != null) {
                statement.setInt(1, selectedItem.getLevelID());

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new DotsInLevel(
                                results.getInt("levelID"),
                                results.getInt("dotID")
                        ));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }

}
