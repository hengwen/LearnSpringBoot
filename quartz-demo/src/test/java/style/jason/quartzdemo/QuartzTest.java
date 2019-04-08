package style.jason.quartzdemo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import style.jason.quartzdemo.job.HelloJob;

public class QuartzTest {

    public static void main(String[] args) throws InterruptedException {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            System.out.println("start");
            scheduler.start();
            JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                    .withIdentity("job1", "group1")
                    .usingJobData("myJob", "Hello my job")
                    .usingJobData("myDoubleValue", 3.141d)
                    .build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever()).build();
//            Trigger trigger1 = TriggerBuilder.newTrigger()
//                    .withIdentity("trigger2", "group1")
//                    .startNow()
//                    .withSchedule();
            scheduler.scheduleJob(jobDetail, trigger);
            Thread.sleep(60000);
            scheduler.shutdown();
            System.out.println("shutdown");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
