import java.awt.*;

public class Squares extends Shape {

    protected int length;
    protected int x;
    protected int y;
    protected int angle;


    public Squares(int x,int y,int length,int angle)
    {
        this.length = length;
        this.x = x;
        this.y = y;
        this.angle = angle;

        Shape.allShapes.add(this);

    }

    public void draw(Graphics g){
        //https://stackoverflow.com/questions/7517688/rotate-a-java-graphics2d-rectangle
        Graphics2D sq = (Graphics2D) g ;
        sq.rotate(Math.toRadians(angle)); //rotate to angle provided by user
        sq.fillRect(x * length,y * length,length,length);
    }

    public int getX()
    {
        return x;
    } //returns x and y values which I needed in my game, I didn't make these abstract methods
    //as I only needed to use it for squares as I didn't use the rest of the shapes.

    public int getY()
    {
        return y;
    }





}
