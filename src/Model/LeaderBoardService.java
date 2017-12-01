package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LeaderBoardService {

    public static void selectAll(List<LeaderBoard> targetList, DatabaseConnection database){
        PreparedStatement statement = database.newStatement("SELECT positionID, position, scoreID FROM LeaderBoard ORDER BY positionID");

        try {
            if (statement != null) {

                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new LeaderBoard(results.getInt("positionID"), results.getString("position"), results.getInt("scoreID")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }


    }
    public static LeaderBoard selectByID(int id, DatabaseConnection database){

        LeaderBoard result = null;

        PreparedStatement statement = database.newStatement("SELECT positionID, scoreID, position FROM LeaderBoard WHERE positionID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    result = new LeaderBoard(results.getInt("positionID"), results.getString("position"), results.getInt("scoreID"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }
    public static void save(LeaderBoard itemToSave, DatabaseConnection database){

        LeaderBoard existingItem = null;
        if (itemToSave.getPositionID() != 0) existingItem = selectByID(itemToSave.getPositionID(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO LeaderBoard (positionID, position, scoreID) VALUES (?, ?, ?))");
                statement.setInt(1, itemToSave.getPositionID());
                statement.setString(2, itemToSave.getPosition());
                statement.setInt(3, itemToSave.getScoreID());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE LeaderBoard SET positionID = ?, position = ? WHERE scoreID = ?");
                statement.setInt(1, itemToSave.getPositionID());
                statement.setString(2, itemToSave.getPosition());
                statement.setInt(3, itemToSave.getScoreID());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }

    } //Insert and Update
   // public static void deleteByID(int id, DatabaseConnection database){}

}
