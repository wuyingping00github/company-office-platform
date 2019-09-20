package company.office.quartz;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 这是直接处理的定时任务
 *  * 只需要讲业务逻辑代码卸载这里就可以了丙炔启动
 */
public class TestQuartz  {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //将需要定时的任务放在这里
                System.out.println("这里是代码逻辑处理！！");
            }
        };
        //使用SchduledExecutorService进行定时任务的启动，这里最为合理
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(runnable,000000,60*60*24,TimeUnit.SECONDS);
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
