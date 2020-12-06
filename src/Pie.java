import java.awt.*;

public class Pie extends Shape {

    // Lecture 5 with shape drawing


    protected int x;
    protected int y;
    protected int length;
    protected int width;
    protected int startAngle;
    protected int arcAngle;
    protected int angle;

    public Pie(int x, int y, int width, int length, int startAngle, int arcAngle,int angle) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
        this.startAngle = startAngle;
        this.arcAngle = arcAngle;

        allShapes.add(this);
    }


    public void draw(Graphics g) {
        Graphics2D pie = (Graphics2D) g;
        pie.rotate(Math.toRadians(angle));
        pie.fillArc(x, y, width, length, startAngle, arcAngle);
    }





}
