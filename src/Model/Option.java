package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Option {

    private int optionID;
    private String levelName;
    private int difficltyRatio;

    public int getOptionID() {
        return optionID;
    }

    public void setOptionID(int optionID) {
        this.optionID = optionID;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public int getDifficltyRatio() {
        return difficltyRatio;
    }

    public void setDifficltyRatio(int difficltyRatio) {
        this.difficltyRatio = difficltyRatio;
    }

    public Option(int optionID, String levelName, int difficltyRatio) {
        this.optionID = optionID;
        this.levelName = levelName;
        this.difficltyRatio = difficltyRatio;
    }
}
