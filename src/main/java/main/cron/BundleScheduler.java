package main.cron;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.service.RandomGeneratorService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class BundleScheduler {

    public RandomGeneratorService randomGeneratorService;

    @Scheduled(cron = "*/1 * * * * *")
    public void createRandomMessage() {
        log.info("createRandomMessage() started...");
        randomGeneratorService.generateData();
        log.info("createRandomMessage() finished...");
    }
}
