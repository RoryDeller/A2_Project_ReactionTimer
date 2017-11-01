package Model;

public class Level {

    private int levelID;
    private String levelName;
    private int difficultyRatio;

    public Level(int levelID, String levelName, int difficultyRatio) {
        this.levelID = levelID;
        this.levelName = levelName;
        this.difficultyRatio = difficultyRatio;
    }

    public int getLevelID() {
        return levelID;
    }

    public String getLevelName() {
        return levelName;
    }

    public int getDifficultyRatio() {
        return difficultyRatio;
    }

    public void setLevelID(int levelID) {
        this.levelID = levelID;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public void setDifficultyRatio(int difficultyRatio) {
        this.difficultyRatio = difficultyRatio;
    }

    @Override
    public String toString() {
        return "Level{" +
                "levelID=" + levelID +
                ", levelName='" + levelName + '\'' +
                ", difficultyRatio=" + difficultyRatio +
                '}';
    }


}
