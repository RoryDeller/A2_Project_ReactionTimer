package Model;

public class Configuration {

    private int configurationID;
    private int optionID;
    private String configuration;

    public Configuration(int configurationID, int optionID, String configuration) {
        this.configurationID = configurationID;
        this.optionID = optionID;
        this.configuration = configuration;
    }


    public int getConfigurationID() {
        return configurationID;
    }

    public void setConfigurationID(int configurationID) {
        this.configurationID = configurationID;
    }

    public int getOptionID() {
        return optionID;
    }

    public void setOptionID(int optionID) {
        this.optionID = optionID;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }
}
