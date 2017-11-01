package Model;

public class Dot {
    private int dotID;
    private int dotOrder;
    private String ShapeID;

    public Dot(int dotID, int dotOrder, String shapeID) {
        this.dotID = dotID;
        this.dotOrder = dotOrder;
        ShapeID = shapeID;
    }

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

    public String getShapeID() {
        return ShapeID;
    }

    public void setShapeID(String shapeID) {
        ShapeID = shapeID;
    }

    @Override
    public String toString() {
        return "Dot{" +
                "dotID=" + dotID +
                ", dotOrder=" + dotOrder +
                ", ShapeID='" + ShapeID + '\'' +
                '}';
    }
}
