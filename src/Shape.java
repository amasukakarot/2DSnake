//referred to first lab

import java.awt.*;
import java.util.ArrayList;


public abstract class Shape
    //Lab one was used as reference.
{
    //https://stackoverflow.com/questions/16119102/automatically-adding-every-class-object-constructed-into-an-arraylist
    protected static ArrayList<Shape> allShapes = new ArrayList<Shape>(); //arraylist which holds all the shapes made in a collection


    public abstract void draw(Graphics g); //draw abstract method which all shapes must have
}



