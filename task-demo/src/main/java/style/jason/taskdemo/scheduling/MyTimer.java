package style.jason.taskdemo.scheduling;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimer {
    public static void main(String[] args) {
//        //1. 创建Timer实例
//        Timer timer = new Timer();
//        // 2. 创建TimerTask实例
//        TimerTask timerTask = new MyTimerTask("Jason Huang");
//        // 3. 使用Timer定时定频率调用timerTask业务逻辑
//        // 两秒后每秒执行一次
//        timer.schedule(timerTask, 2000L, 1000L);

        Timer timer = new Timer();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(calendar.getTime()));
//        calendar.add(Calendar.SECOND, -12);
//        System.out.println(simpleDateFormat.format(calendar.getTime()));
        // 使用当前时间3秒后执行一次
//        TimerTask timerTask = new MyTimerTask("Jason");
//        timer.schedule(timerTask, calendar.getTime());
        // 使用当前时间3秒后执行并每隔2秒执行一次
//        TimerTask timerTask = new MyTimerTask("Schedule2");
//        timer.schedule(timerTask, calendar.getTime(), 2000);
        // delay参数，延迟2秒执行一次
//        TimerTask timerTask = new MyTimerTask("Schedule3");
//        timer.schedule(timerTask, 2000);
        // delay参数，延迟2秒后执行，并每隔2秒执行一次
//        TimerTask timerTask = new MyTimerTask("Schedule3");
//        timer.schedule(timerTask, 2000, 2000);
        // 获取任务第一次执行的时间
//        c
//        timer.schedule(timerTask, 2000);
//        System.out.println("do schedule time is:" + simpleDateFormat.format(timerTask.scheduledExecutionTime()));
        // 首次计划执行时间早于当前时间的时候
        TimerTask timerTask = new MyTimerTask("total");
        // 1. schedule会立刻执行
//        timer.schedule(timerTask, calendar.getTime(), 2000);
        // 2. scheduleAtFixedRate会连续执行早于当前时间这段时间的执行任务，直到赶上当前时间
        timer.scheduleAtFixedRate(timerTask, calendar.getTime(), 2000);
    }
}
