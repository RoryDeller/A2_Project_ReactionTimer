package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Option {

    private int optionID;
    private String option;
    private int catagory;

    public Option(int optionID, String option, int catagory) {
        this.optionID = optionID;
        this.option = option;
        this.catagory = catagory;
    }

    public int getOptionID() {return optionID;}

    public void setOptionID(int optionID) {this.optionID = optionID;}

    public String getOption() {return option;}

    public void setOption(String option) {this.option = option;}

    public int getCatagory() {return catagory;}

    public void setCatagory(int catagory) {this.catagory = catagory;}
}
