package Model;

public class Configuration {

    private int configurationID;
    private int optionID;
    private String configurationType;

    public Configuration(int configurationID, int optionID, String configuration) {
        this.configurationID = configurationID;
        this.optionID = optionID;
        this.configurationType = configuration;
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

    public String getConfigurationType() {
        return configurationType;
    }

    public void setConfigurationType(String configurationType) {
        this.configurationType = configurationType;
    }
}
