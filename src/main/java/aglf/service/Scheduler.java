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

    // IMPORT TEAM INFO AND NEW PLAYERS EVERY SUNDAY AT 23:33
    @Scheduled(cron = "0 33 23 * * SUN")
    public void importTeamsAndPlayers() {
        migrationUtil.importTeams();
    }

    // SCORE MATCHES EVERY 60 MINUTES
    @Scheduled(fixedRate = 60 * 60 * 1000)
    public void scoreMatch() {
        migrationUtil.startMatchScoring();
    }
}
