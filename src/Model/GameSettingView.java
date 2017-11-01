package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class GameSettingView {


    private final SimpleIntegerProperty optionID;
    private final SimpleStringProperty option;
    private final SimpleStringProperty catagory;

    public Option(int optionID, String option, String catagory){
        this.optionID = new SimpleIntegerProperty(optionID);
        this.option = new SimpleStringProperty(option);
        this.catagory = new SimpleStringProperty(catagory);
    }

    public int getOptionID() { return optionID.get(); }
    public void setOptionID(int optionID) { this.optionID.set(optionID); }

    public String getOption() { return option.get(); }
    public void setOption(String option) { this.option.set(option); }

    public String getCatagory() { return catagory.get(); }
    public void setCatagory(String catagory) { this.catagory.set(catagory); }
}
