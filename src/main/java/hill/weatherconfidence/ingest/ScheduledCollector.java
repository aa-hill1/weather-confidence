package hill.weatherconfidence.ingest;

import hill.weatherconfidence.IKmsDecrypter;
import hill.weatherconfidence.ingest.model.GeocodeItem;
import hill.weatherconfidence.ingest.model.GeocodeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduledCollector {

    private static final Logger log = LoggerFactory.getLogger(ScheduledCollector.class);
    private final IKmsDecrypter kmsDecrypter;
    private final String baseUrl;

    private final List<GeocodeItem> locations = new ArrayList<>();

    public ScheduledCollector(IKmsDecrypter kmsDecrypter, @Value("${weatherApi.baseUrl}") String baseUrl) {
        this.kmsDecrypter = kmsDecrypter;
        this.baseUrl = baseUrl;
    }

    private void init() {
        String apiKey = kmsDecrypter.getDecryptedApiKey();
        GeocodeClient geocodeClient = new GeocodeClient(baseUrl, apiKey);
        GeocodeResponse geocodeResponse = geocodeClient.geocode("Hemel Hempstead").block();
        if (geocodeResponse != null) {
            locations.add(geocodeResponse.first());
        }
    }


    @Scheduled(cron = "${ingest.cron}")
    public void collectLatest() {
        log.info("Collecting data");
        if (locations.size() == 0) {
            init();
        }
        locations.forEach(loc -> {
            log.info("Collecting forecast data for location " + loc.getName());
            // TODO: Create a ForecastClient or PredictionClient a bit like the GeocodeClient and call it to get data
        });

    }

}
