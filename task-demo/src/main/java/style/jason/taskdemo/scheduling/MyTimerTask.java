package style.jason.taskdemo.scheduling;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
    private String name;
    private Integer count = 0;
    public MyTimerTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (count < 10) {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("excute timer is :" + simpleDateFormat.format(scheduledExecutionTime()));
            System.out.println("current name:" + name + " and count is " + count);
            count++;
        } else {
            cancel();
            System.out.println("cancel schedule");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
