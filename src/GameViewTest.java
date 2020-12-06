// code copied from Simon Lucas
// code copied by Udo Kruschwitz
// code updated by Ian Daly

public class GameViewTest
{
    public static void main(String[] args)
    {
        // test the view component

        int w = 20;
        int h = 20;
        int[][] a = new int[w][h];

        GameView tv = new GameView(a);
        new JEasyFrame(tv);
    }
}