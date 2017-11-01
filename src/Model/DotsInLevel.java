package Model;

public class DotsInLevel {

    private int dotID;
    private int levelID;

    public DotsInLevel(int dotID, int levelID) {
        this.dotID = dotID;
        this.levelID = levelID;
    }

    public int getDotID() {
        return dotID;
    }

    public void setDotID(int dotID) {
        this.dotID = dotID;
    }

    public int getLevelID() {
        return levelID;
    }

    public void setLevelID(int levelID) {
        this.levelID = levelID;
    }

    @Override
    public String toString() {
        return "DotsInLevel{" +
                "dotID=" + dotID +
                ", levelID=" + levelID +
                '}';
    }
}
