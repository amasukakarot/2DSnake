// code copied from Simon Lucas
// code copied by Udo Kruschwitz


import javax.swing.*;
import java.awt.*;

public class JEasyFrame extends JFrame { //this class creates the frame
    public Component comp;
    public static String title = "Usama Javed 1503660";
    public JEasyFrame(Component comp) {
        setTitle(title);
        this.comp = comp;
        getContentPane().add(BorderLayout.CENTER, comp);
        pack();
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false); //can't resize the screen
        this.setLocationRelativeTo(null);
    }
}




