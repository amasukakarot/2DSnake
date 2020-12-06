// code copied from Simon Lucas
// code copied by Udo Kruschwitz

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class GameView  extends JComponent implements ActionListener {


    int[][] a;
    int w, h;
    static int size = 20;
    static int timeElapsed = 0;


    static int x = 2; //starting coordinates of the snake
    static int y = 2;

    public static Timer timer; //create timer object
    public static CountTime ct;

    private KeyBoardMovement arrowKey; //access KeyBoardMovement class
    private Squares sq;
    public static ArrayList<Squares> square = new ArrayList<Squares>(); //arraylist to hold the squares
    int delay = 100; //speed of squares, the higher it is the slower the square.


    public GameView(int[][] a) {
        setFocusable(true); //so that the keys can be used
        arrowKey = new KeyBoardMovement(); //create an object of class KeyBoardMovement
        addKeyListener(arrowKey);
        this.a = a;
        w = 20;
        h = 20;

        timer = new Timer(delay, this);
        ct = new CountTime(); //CountTime, which counts the time the program has been running for until player dies.



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        if (KeyBoardMovement.start) {

            //if the timer delay is greater than 30, and time is greater than 5, keep decrease delay by -3
            //this makes the game go faster and decreases the delay.
            if (timer.getDelay() > 30) {
                if (ct.count > 5) {
                    timer.setDelay(timer.getDelay() - 3);
                    timer.restart();
                }
            }


            if (KeyBoardMovement.moveRight) {
                x++; //if the user presses D, the x coordinate of the shape will increase, so it will move to the right
            }
            if (KeyBoardMovement.moveLeft) {
                x--; //if the user presses A, the x coordinate will decrease, so that it moves to the left
            }
            if (KeyBoardMovement.moveUp) {
                y--; //if the user presses W the y coordinate decreases, so moves up
            }
            if (KeyBoardMovement.moveDown) {
                y++; //if user presses s, y coordinate increases, so it goes down.
            }

            //create square object as game is running
            sq = new Squares(x, y, 9, 0);
            square.add(sq); //add to arrayList called sq


        /*
        * If the snake goes out of the bounds of the frame, then the game will stop and so will the timer.
        * Using the writeScores method from Hiscores, it writes score to the text file.
        * */
            if (x < 1 || x > 45) {
                timer.stop();
                ct.stop();
                timeElapsed = ct.count;
                try {
                    Hiscores.writeScores(ct.count);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                ScoresFrame s = null;  //creates frame with score.
                try {
                    s = new ScoresFrame();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                s.setTitle("Top 10");

                System.out.println("Time elapsed: " + timeElapsed);
                System.out.println("GAME OVER");
            }

            if (y < 1 || y > 45) {
                timer.stop();
                ct.stop();
                timeElapsed = ct.count;
                try {
                    Hiscores.writeScores(ct.count);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                ScoresFrame s = null;
                try {
                    s = new ScoresFrame();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                s.setTitle("Top 10");


                System.out.println("Time elapsed: " + timeElapsed);
                System.out.println("GAME OVER");
            }



            //if the snake hits itself, the game will end.
            for (int i = 0; i < square.size() - 1; i++) {
                if (x == square.get(i).getX() && y == square.get(i).getY()) {
                        timer.stop();
                        ct.stop();
                        timeElapsed = ct.count;
                        try {
                            Hiscores.writeScores(ct.count);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }

                        ScoresFrame s = null;
                        try {
                            s = new ScoresFrame();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        s.setTitle("Top 10");

                        System.out.println("Time elapsed: " + timeElapsed);
                    }
                }
            }
        }


    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for (int i = 0; i < w; i++)
        {
            for (int j = 0; j < h; j++)
            {

            }
        }

        if(!(KeyBoardMovement.start)){
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial",0, 18));
            g.drawString("Press enter or space to start the game" ,50,150);
        }
        //Shows the time the user has been alive for in real time
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial",0, 25));
        g.drawString("Time:" + ct.count ,320,24);


        for (int i = 0; i < square.size(); i++){
            g.setColor(Color.BLUE); //draw the square parts onto the screen from the list
            square.get(i).draw(g);
        }

    }


    public Dimension getPreferredSize() {
        return new Dimension(w  * size, h * size);
    }


}
