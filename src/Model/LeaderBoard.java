package Model;

public class LeaderBoard{

    private int positionID;
    private String position;
    private int scoreID;

    public LeaderBoard(int positionID, String levelName, int difficulty) {
        this.positionID = positionID;
        this.position = levelName;
        this.scoreID = difficulty;
    }

    public int getPositionID() {
        return positionID;
    }

    public String getPosition() {
        return position;
    }

    public int getScoreID() {
        return scoreID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setScoreID(int scoreID) {
        this.scoreID = scoreID;
    }

    @Override
    public String toString() {
        return "Leaderboard{" +
                "positionID=" + positionID +
                ", position='" + position + '\'' +
                ", scoreID=" + scoreID +
                '}';
    }
}
