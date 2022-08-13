package hill.weatherconfidence.ingest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledCollector {

    private static Logger log = LoggerFactory.getLogger(ScheduledCollector.class);

    @Scheduled(cron = "${ingest.cron}")
    public void collectLatest() {
        log.info("Collecting data");
    }

}
