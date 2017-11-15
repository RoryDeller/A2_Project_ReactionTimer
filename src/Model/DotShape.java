package Model;

public class DotShape {

    private int shapeID;
    private int dotOrder;
    private String shapeType;


    public DotShape(int shapeID, int dotOrder, String shapeType) {
        this.shapeID = shapeID;
        this.dotOrder = dotOrder;
        this.shapeType = shapeType;
    }

    public int getShapeID() {
        return shapeID;
    }

    public void setShapeID(int shapeID) {
        this.shapeID = shapeID;
    }

    public int getDotOrder() {
        return dotOrder;
    }

    public void setDotOrder(int dotOrder) {
        this.dotOrder = dotOrder;
    }

    public String getShapeType() {
        return shapeType;
    }

    public void setShapeType(String shapeType) {
        this.shapeType = shapeType;
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
