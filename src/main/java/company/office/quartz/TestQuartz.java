package company.office.quartz;

import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestQuartz  {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //将需要定时的任务放在这里
                System.out.println("正常输出");
            }
        };
        //使用SchduledExecutorService进行定时任务的启动，这里最为合理
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(runnable,000000,0000001,TimeUnit.SECONDS);
    }

    /**
     * 这是一个工作逻辑类，把需要实现的方法，放在这里
     */
    public class TaskcJob{

        /**
         * 如果使用spring方式进行配置的方式调度任务，需要以下步骤
         * 1.是有线程注册
         * 2.指定业务调度对象
         * 3.调度业务
         * 4.增加调度触发器
         * 5.设置调度，比如10秒触发一次
         */
        public void ServiceTask(){
        System.out.println("这是业务逻辑代码！！");

        }

     }

}
