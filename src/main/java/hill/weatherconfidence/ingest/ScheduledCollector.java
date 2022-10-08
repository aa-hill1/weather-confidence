package hill.weatherconfidence.ingest;

import hill.weatherconfidence.IKmsDecrypter;
import hill.weatherconfidence.ingest.forecast.ForecastResponse;
import hill.weatherconfidence.ingest.model.GeocodeItem;
import hill.weatherconfidence.ingest.model.GeocodeResponse;
import hill.weatherconfidence.repository.ForecastRepository;
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
    private final ForecastRepository repository;

    private ForecastClient forecastClient;

    private final List<GeocodeItem> locations = new ArrayList<>();

    public ScheduledCollector(IKmsDecrypter kmsDecrypter, @Value("${weatherApi.baseUrl}") String baseUrl, ForecastRepository repository) {
        this.kmsDecrypter = kmsDecrypter;
        this.baseUrl = baseUrl;
        this.repository = repository;
    }

    private void init() {
        String apiKey = kmsDecrypter.getDecryptedApiKey();
        GeocodeClient geocodeClient = new GeocodeClient(baseUrl, apiKey);
        GeocodeResponse geocodeResponse = geocodeClient.geocode("Hemel Hempstead").block();
        if (geocodeResponse != null) {
            locations.add(geocodeResponse.first());
        }
        forecastClient = new ForecastClient(baseUrl, apiKey);
    }


    @Scheduled(cron = "${ingest.cron}")
    public void collectLatest() {
        log.info("Collecting data");
        if (locations.size() == 0) {
            init();
        }
        locations.forEach(loc -> {
            log.info("Collecting forecast data for location " + loc.getName());
            forecastClient.forecast(loc).doOnSuccess((forecast) -> {
                repository.store(loc, forecast);
                log.info("Stored");
            });
        });

    }

}
