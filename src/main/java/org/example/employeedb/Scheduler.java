package org.example.employeedb;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    private static final Logger logger =
            LoggerFactory.getLogger(Scheduler.class);


    @Scheduled(fixedRate = 5000)
    public void task() throws InterruptedException {
        logger.info("FixedRateScheduler");
        Thread.sleep(3000);
        logger.info("Delayed 3s Fixed rate Scheduler");

    }

    @Scheduled(fixedDelay = 5000)
    public void Mytask() throws InterruptedException {
        logger.info("Fixed Delay Scheduler");
        Thread.sleep(3000);
        logger.info("Delayed 3s Fixed Delay Scheduler");
    }

    private int count = 0;

    @Scheduled(fixedDelay = 1000)
    void countTask() {
        if (count <= 3) {
            logger.info("Count :" + count++);
        }
    }

    @Scheduled(cron="*/10 * * * * *")
    void cronPattern(){
        logger.info("Cron Expression");
    }
}











