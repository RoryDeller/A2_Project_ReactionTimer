package Model;

public class Dot {
    private int dotID;
    private int dotOrder;
    private int ShapeID;

    public Dot(int dotID, int dotOrder, int shapeID) {
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

    public int getShapeID() {
        return ShapeID;
    }

    public void setShapeID(int shapeID) {
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
