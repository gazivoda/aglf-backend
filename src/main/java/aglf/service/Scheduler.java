package aglf.service;

import aglf.migration.MigrationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class Scheduler {

    @Autowired
    private MigrationUtil migrationUtil;

    // IMPORT MATCH SCHEDULE EVERY DAY AT 23:23
    @Scheduled(cron = "0 23 23 * * ?")
    public void importMatchSchedule() {
        migrationUtil.importMatchSchedule();
    }

    // TODO create scheduler for updateMatchData()
}
