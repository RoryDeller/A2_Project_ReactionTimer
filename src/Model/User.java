package Model;

public class User {

    private int userID;
    private String userNickname;
    private int scoreID;

    public User(int userID, String userNickname, int scoreID) {
        this.userID = userID;
        this.userNickname = userNickname;
        this.scoreID = scoreID;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public int getScoreID() {
        return scoreID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public void setScoreID(int scoreID) {
        this.scoreID = scoreID;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userNickname='" + userNickname + '\'' +
                ", scoreID=" + scoreID +
                '}';
    }



}
