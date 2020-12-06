import java.util.Timer;
import java.util.TimerTask;

public class CountTime {

    //https://www.youtube.com/watch?v=36jbBSQd3eU

    public CountTime(){

    }

    static int count = 0;
    static Timer timer = new Timer();
    static TimerTask task = new TimerTask(){

        @Override
        public void run() {
            count ++;
        }
    };

    public static void start(){
        timer.scheduleAtFixedRate(task,1000,1000);
    }

    public void stop(){
        timer.cancel();
    }


}
