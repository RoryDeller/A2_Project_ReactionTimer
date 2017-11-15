package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ConfigurationService {

    public static void selectAll(List<Configuration> targetList, DatabaseConnection database){


            PreparedStatement statement = database.newStatement("SELECT configurationID, optionID, configurationType FROM Configuration ORDER BY configurationID");

            try {
                if (statement != null) {

                    ResultSet results = database.runQuery(statement);

                    if (results != null) {
                        while (results.next()) {
                            targetList.add(new Configuration(results.getInt("configurationID"), results.getInt("optionID"), results.getString("configurationType")));
                        }
                    }
                }
            } catch (SQLException resultsException) {
                System.out.println("Database select all error: " + resultsException.getMessage());
            }

        }
    public static Configuration selectByID(int id, DatabaseConnection database){

        Configuration result = null;

        PreparedStatement statement = database.newStatement("SELECT configurationID, optionID, configurationType FROM Configuration WHERE configurationID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    result = new Configuration(results.getInt("configurationID"), results.getInt("optionID"), results.getString("configurationType"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }


    public static void save(Configuration itemToSave, DatabaseConnection database){

        Configuration existingItem = null;
        if (itemToSave.getConfigurationID() != 0) existingItem = selectByID(itemToSave.getConfigurationID(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO Configuration (configurationID, optionID, configurationType) VALUES (?, ?, ?))");
                statement.setInt(1, itemToSave.getConfigurationID());
                statement.setInt(2, itemToSave.getOptionID());
                statement.setString(2, itemToSave.getConfigurationType());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE Configuration SET configurationID = ?, configurationType = ? WHERE configurationID = ?");
                statement.setInt(1, itemToSave.getConfigurationID());
                statement.setInt(2, itemToSave.getOptionID());
                statement.setString(2, itemToSave.getConfigurationType());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }



    } //Insert and Update
    public static void deleteByID(int id, DatabaseConnection database){


        PreparedStatement statement = database.newStatement("DELETE FROM Configuration WHERE configurationID = ?");

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
