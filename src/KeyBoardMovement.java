import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardMovement implements KeyListener{

    static boolean moveRight = false;
    static boolean moveLeft = false;
    static boolean moveUp = false;
    static boolean moveDown = true;
    static boolean start = false;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        //https://www.youtube.com/watch?v=153vHwQ9nzU

        if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE){
            start = true;
            GameView.timer.start();
            GameView.ct.start();
        }


        else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            //if the user presses D, set moveRight to true, so in GameView class if moveRight is true, will increase x coordinate
            //moveUp and moveDown are false otherwise it will travel in a diagonal direction
            //moveLeft is !, so that when it is going right, it can't move in the opposite direction and kill itself.
            if (!moveLeft) {
                moveRight = true;
                moveUp = false;
                moveDown = false;
            }


        }

        else if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            //if the user presses A, set moveLeft to true, so in GameView class if moveLeft is true, will decrease x coordinate
            //moveUp and moveDown are false otherwise it will travel in a diagonal direction
            //moveRight is !, so that when it is going left, it can't move in the opposite direction and kill itself.
            if (!moveRight) {
                moveLeft = true;
                moveUp = false;
                moveDown = false;
            }

        }

        else if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
            //if the user presses W, they will move up, as moveUp is set to true, so in the GameView class, it will decrease the Y coordinate
            //moveLeft and moveRight are false otherwise it will travel in a diagonal direction
            //moveDown is !, so that when it is going up, it can't move in the opposite direction and kill itself.
            if (!moveDown) {
                moveUp = true;
                moveLeft = false;
                moveRight = false;
            }

        }

        else if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
            /*if the user presses S, they will move down as moveDown is set to true, so in the Gameview class if moveDown is true, which in this case
            it is, the Y coordinate will increase
            */
            //moveLeft and moveRight are false otherwise it will travel in a diagonal direction
            //moveUp is !, so that when it is going down, it can't move in the opposite direction and kill itself.
            if (!moveUp) {
                moveDown = true;
                moveLeft = false;
                moveRight = false;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
