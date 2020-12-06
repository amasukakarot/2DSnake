import javax.swing.*;
import java.io.IOException;

public class ScoresFrame extends JFrame {

    public ScoresFrame() throws IOException {
        //https://stackoverflow.com/questions/12216494/how-to-add-text-to-a-textarea-instead-of-replacing-it
        //create frame with text area
        JTextArea a = new JTextArea();
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        a.setEditable(false);
        setSize(250,200);

        this.setLocationRelativeTo(null);

        add(a);

        //create new object of Hiscores
        Hiscores hs = new Hiscores();
        //method to read scores from file and store in a descending order, sorted linked list.
        hs.displayScores();

        JOptionPane.showMessageDialog(this,"Game Over!\n Your score is: " + GameView.timeElapsed + "\n Your rank is: " + (hs.holdScores.indexOf(GameView.timeElapsed)+1));
        //a message dialog telling the user game over, and what position they placed in the all time top rankings.

        for (int i = 0; i < hs.holdScores.size(); i ++)
        {
            if(i < 10){ //only print top 10 scores
                a.append("Rank " + (i+1) + ": "  +  hs.holdScores.get(i) + "\n");
                //+1 so that it doesn't say "Rank 0", and starts at 1.
            }
        }




    }
}
