package Model;

public class Score {

    private int scoreID;
    private int score;

    public Score(int scoreID, int score) {
        this.scoreID = scoreID;
        this.score = score;
    }

    public int getScoreID() {
        return scoreID;
    }

    public int getScore() {
        return score;
    }

    public void setScoreID(int scoreID) {
        this.scoreID = scoreID;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scoreID=" + scoreID +
                ", score=" + score +
                '}';
    }
}
