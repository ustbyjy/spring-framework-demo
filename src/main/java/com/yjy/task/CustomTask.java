package com.yjy.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 比较 fixedRate，fixedDelay，cron 三种定义任务，尤其是执行长度超过周期如何处理
 */
//@Component
@Slf4j
public class CustomTask {

    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    private int[] delays = new int[]{8, 3, 6, 2, 2};
    private int index = 0;

    /**
     * 不执行被超过的任务，下一个任务的开始点仍符合 cron 表达式
     */
//    @Scheduled(cron = "0/5 * * * * ?")
    private void cronTask() {
        process();
    }

    /**
     * 速率固定，若执行长度超过周期，则任务加入到队列，上一个任务执行完立刻执行
     */
//    @Scheduled(fixedRate = 5000)
    private void fixedRateTask() {
        process();
    }

    /**
     * 下一个任务的开始时间距上一个任务的结束时间之间的间隔固定
     */
    @Scheduled(fixedDelay = 5000)
    private void fixedDelayTask() {
        process();
    }

    private void process() {
        try {
            log.info("start，time={}", timeFormat.format(new Date()));
            Thread.sleep(delays[index] * 1000);
            if (index == delays.length - 1) {
                index = 0;
            } else {
                index++;
            }
            log.info("end，time={}", timeFormat.format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
