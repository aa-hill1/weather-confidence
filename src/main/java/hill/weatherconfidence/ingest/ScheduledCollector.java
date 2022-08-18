package hill.weatherconfidence.ingest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ScheduledCollector {

    private static Logger log = LoggerFactory.getLogger(ScheduledCollector.class);

    @Autowired
    private WebClient webClient;

    @Scheduled(cron = "${ingest.cron}")
    public void collectLatest() {
        log.info("Collecting data");
        webClient.get();
    }

}
