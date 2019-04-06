package style.jason.taskdemo.scheduling.rebort;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

public class ExcuteTask {
    public static void main(String[] args) {
        Timer timer = new Timer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        System.out.println("current time is " + simpleDateFormat.format(calendar.getTime()));

        DanceRebort danceRebort = new DanceRebort();
        WaterRebort waterRebort = new WaterRebort(timer);
        timer.schedule(danceRebort, calendar.getTime(), 2000);
        timer.scheduleAtFixedRate(waterRebort, calendar.getTime(), 1000);
    }
}
