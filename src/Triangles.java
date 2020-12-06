import java.awt.*;

public class Triangles extends Shape {

    protected int[] xCoords,yCoords;
    protected int angle;

    public Triangles(int[] xCoords, int[] yCoords,int angle)
    {
        this.xCoords = xCoords;
        this.yCoords = yCoords;
        this.angle = angle;

        Shape.allShapes.add(this);

    }
    public void draw(Graphics g){
        //https://stackoverflow.com/questions/14124593/how-to-rotate-graphics-in-java
        Graphics2D tri=(Graphics2D)g;
        tri.rotate(Math.toRadians(angle)); //rotate to angle divided by user
        tri.fillPolygon(xCoords,yCoords,3); //3is the number of corners it will have, triangle has 3 corners
    }


}