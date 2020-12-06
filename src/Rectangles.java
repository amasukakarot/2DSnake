import java.awt.*;


public class Rectangles extends Shape {

    protected int width;
    protected int length;
    protected int x;
    protected int y;
    protected int angle;


    public Rectangles(int x,int y,int width,int length,int angle)
    {
        this.width = width;
        this.length = length;
        this.x = x;
        this.y = y;
        this.angle = angle;

        allShapes.add(this);

    }

    public void draw(Graphics g){
        Graphics2D rec=(Graphics2D)g;
        rec.rotate(angle, x + width/2, y + length/2);
        rec.fillRect(x,y,width,length);
    }


}
