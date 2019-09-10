package company.office.quartz;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 2.使用spring的定时器:
 * spring自带支持定时器的任务实现。其可通过简单配置来使用到简单的定时任务。
 *  author 吴应平
 */
    @ComponentScan//注解扫描
    @Configurable//开启配置
    @EnableScheduling//EnableScheduling注解，开启spring的自动定时任务注解
    public class ScheduledTasks{

        @Scheduled(fixedRate = 1000 * 30)
        public void reportCurrentTime(){
            System.out.println ("Scheduling Tasks Examples: The time is now " + dateFormat().format(new Date()));
        }

        //每1分钟执行一次
        @Scheduled(cron = "0 */1 *  * * * ")
        public void reportCurrentByCron(){
            System.out.println ("Scheduling Tasks Examples By Cron: The time is now " + dateFormat().format(new Date()));
            System.out.println("每分钟只醒一次");
        }

    /**
     * 时间格式化方法函数
     * @return SimpleDateFormat
     */
    private SimpleDateFormat dateFormat(){
            return new SimpleDateFormat ("HH:mm:ss");
        }

    }



