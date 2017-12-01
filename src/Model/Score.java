package Model;

public class Score {

    private int scoreID;
    private int totalScore;

    public Score(int scoreID, int score) {
        this.scoreID = scoreID;
        this.totalScore = score;
    }

    public int getScoreID() {
        return scoreID;
    }

    public int getScore() {
        return totalScore;
    }

    public void setScoreID(int scoreID) {
        this.scoreID = scoreID;
    }

    public void setScore(int score) {
        this.totalScore = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scoreID=" + scoreID +
                ", score=" + totalScore +
                '}';
    }
}
