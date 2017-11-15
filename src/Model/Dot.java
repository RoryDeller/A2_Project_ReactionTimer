package Model;

public class Dot {
    private int dotID;
    private int dotOrder;
    private int shapeID;
    private String colour;
    private double lifeTime;
    private int size;
    private int scoreValue;

    public Dot(int dotID, int dotOrder, int shapeID, String colour, double lifeTime, int size, int scoreValue) {
        this.dotID = dotID;
        this.dotOrder = dotOrder;
        this.shapeID = shapeID;
        this.colour = colour;
        this.lifeTime = lifeTime;
        this.size = size;
        this.scoreValue = scoreValue;
    }

    public String getColour() {return colour;}

    public void setColour(String colour) {this.colour = colour;}

    public double getLifeTime() {return lifeTime;}

    public void setLifeTime(double lifeTime) {this.lifeTime = lifeTime;}

    public int getSize() {return size;}

    public void setSize(int size) {this.size = size;}

    public int getScoreValue() {return scoreValue;}

    public void setScoreValue(int scoreValue) {this.scoreValue = scoreValue;}

    public int getDotID() {
        return dotID;
    }

    public void setDotID(int dotID) {
        this.dotID = dotID;
    }

    public int getDotOrder() {
        return dotOrder;
    }

    public void setDotOrder(int dotOrder) {
        this.dotOrder = dotOrder;
    }

    public int getShapeID() {
        return shapeID;
    }

    public void setShapeID(int shapeID) {
        this.shapeID = shapeID;
    }

    @Override
    public String toString() {
        return "Dot{" +
                "dotID=" + dotID +
                ", dotOrder=" + dotOrder +
                ", shapeID='" + shapeID + '\'' +
                '}';
    }
}
