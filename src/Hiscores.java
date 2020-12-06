import javax.lang.model.element.AnnotationValue;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Hiscores {
    static Path path = Paths.get("hiscores.txt");
    static File file = new File(path.toUri());
    LinkedList<Integer> holdScores = new LinkedList<Integer>();
    //list to hold the all scores



    public static void writeScores(int score) throws IOException {
        //https://stackoverflow.com/questions/18549704/java-filewriter-create-a-new-line
        FileWriter writer = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write(String.valueOf(score)); //open a file and write score to file
        bw.newLine(); //write each score on a new line
        bw.flush();
        bw.close();



    }


    public void displayScores() throws IOException {
        Scanner input;
        input = new Scanner(file);

        //read file and add contents to the list
        while(input.hasNextInt()) {
            int line = input.nextInt();
            holdScores.add(line);
        }

        Collections.sort(holdScores); //sort in ascending order
        Collections.reverse(holdScores); //sort in descending order, so can do top 10 scores.
    }



}
