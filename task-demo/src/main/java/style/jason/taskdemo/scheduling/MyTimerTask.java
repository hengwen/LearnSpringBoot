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
        if (count < 3) {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(simpleDateFormat.format(calendar.getTime()));
            System.out.println("current name:" + name);
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
