package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class GameSettingView {


    private final SimpleIntegerProperty optionID;
    private final SimpleStringProperty option;
    private final SimpleStringProperty category;

    public Option(int optionID, String option, String category){
        this.optionID = new SimpleIntegerProperty(optionID);
        this.option = new SimpleStringProperty(option);
        this.category = new SimpleStringProperty(category);
    }

    public int getOptionID() { return optionID.get(); }
    public void setOptionID(int optionID) { this.optionID.set(optionID); }

    public String getOption() { return option.get(); }
    public void setOption(String option) { this.option.set(option); }

    public String getCategory() { return category.get(); }
    public void setCategory(String category) { this.category.set(category); }
}
