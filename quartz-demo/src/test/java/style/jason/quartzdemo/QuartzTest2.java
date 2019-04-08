package style.jason.quartzdemo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import style.jason.quartzdemo.job.HelloJob;

public class QuartzTest2 {

    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("my-job", "group1")
                .usingJobData("myJob", "string")
                .usingJobData("myDoubleValue", 1.0d)
                .build();
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("my-trigger", "group1")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? *"))
                .build();
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }
}
