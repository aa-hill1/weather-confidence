package hill.weatherconfidence.ingest;

import hill.weatherconfidence.IKmsDecrypter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ScheduledCollector {

    private static final Logger log = LoggerFactory.getLogger(ScheduledCollector.class);

    private final IKmsDecrypter kmsDecrypter;

    private final WebClient webClient;

    public ScheduledCollector(IKmsDecrypter kmsDecrypter, WebClient webClient) {
        this.kmsDecrypter = kmsDecrypter;
        this.webClient = webClient;
    }

    @Scheduled(cron = "${ingest.cron}")
    public void collectLatest() {
        log.info("Collecting data");
        webClient.get();
    }

}
