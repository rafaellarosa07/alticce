package com.labs.alticci.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CleanCacheSchedule {

    private static final Logger log = LoggerFactory.getLogger(CleanCacheSchedule.class);

    @Scheduled(cron = "0 */30 * ? * *")
    @CacheEvict(value = "mapListSequence", allEntries = true)
    public void deleteCache() {
        log.info("Cleaning cache", LocalDate.now());
    }
}

