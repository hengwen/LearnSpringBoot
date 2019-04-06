package style.jason.taskdemo.scheduling.rebort;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class WaterRebort extends TimerTask {

    private int currentWeight = 1;

    private Timer timer;

    public WaterRebort(Timer timer) {
        this.timer = timer;
    }

    @Override
    public void run() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (currentWeight < 5) {
            System.out.println("Add water to bucket, current is :" + currentWeight + "; execute time is：" + simpleDateFormat.format(scheduledExecutionTime()));
            currentWeight++;
        } else {
            System.out.println("cancled number is " + timer.purge() + " and weight is " + currentWeight);
            cancel();
            System.out.println("cancled number is " + timer.purge() + " and weight is " + currentWeight);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timer.cancel();
            System.out.println("cancled all");
        }
    }
}
