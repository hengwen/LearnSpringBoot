package style.jason.taskdemo.scheduling.rebort;

import java.text.SimpleDateFormat;
import java.util.TimerTask;

public class DanceRebort extends TimerTask {
    @Override
    public void run() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Dancing at " + simpleDateFormat.format(scheduledExecutionTime()));
    }
}
