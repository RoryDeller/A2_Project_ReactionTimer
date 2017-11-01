package Model;

public class DotShape {

    private int shapeID;
    private String shapeType;
    private int dotOrder;


    public DotShape(int shapeID) {
        this.shapeID = shapeID;
    }

    public int getShapeID() {
        return shapeID;
    }

    public void setShapeID(int shapeID) {
        this.shapeID = shapeID;
    }

    public String getShapeType() {
        return shapeType;
    }

    public void setShapeType(String shapeType) {
        this.shapeType = shapeType;
    }

    public int getDotOrder() {
        return dotOrder;
    }

    public void setDotOrder(int dotOrder) {
        this.dotOrder = dotOrder;
    }

    @Override
    public String toString() {
        return "DotShape{" +
                "shapeID=" + shapeID +
                ", shapeType='" + shapeType + '\'' +
                ", dotOrder=" + dotOrder +
                '}';
    }
}
