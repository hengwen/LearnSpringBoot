package style.jason.quartzdemo.job;

import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class HelloJob implements Job {

    private String myJob;
    private Double myDoubleValue;


    public String getMyJob() {
        return myJob;
    }

    public void setMyJob(String myJob) {
        this.myJob = myJob;
    }

    public Double getMyDoubleValue() {
        return myDoubleValue;
    }

    public void setMyDoubleValue(Double myDoubleValue) {
        this.myDoubleValue = myDoubleValue;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("hello quartz job!!");
        JobKey key = jobExecutionContext.getJobDetail().getKey();
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
//        String jobSays = jobDataMap.getString("myJob");
//        Double myDoubleValue = jobDataMap.getDoubleValue("myDoubleValue");
        System.out.println("Instance" + key + " of HelloJob says: " + myJob + ", and val is: " + myDoubleValue);
    }
}
