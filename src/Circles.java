import java.awt.*;

public class Circles extends Shape {

    //referred to first lab


    protected int centerX;
    protected int centerY;
    protected int radius;
    protected int angle;


    public Circles(int centerX,int centerY,int radius,int angle)
    {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.angle = angle;

        Shape.allShapes.add(this);

    }


    public void draw(Graphics g){
        Graphics2D c = (Graphics2D) g;
        c.rotate(Math.toRadians(angle)); //wasn't sure if I should still put this in, as how can u rotate a circle?
        c.fillOval(centerX,centerY,radius,radius);
    }



}
