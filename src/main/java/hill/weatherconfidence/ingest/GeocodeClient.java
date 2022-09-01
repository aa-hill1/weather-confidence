package hill.weatherconfidence.ingest;

import hill.weatherconfidence.ingest.model.GeocodeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class GeocodeClient {

    private static final Logger log = LoggerFactory.getLogger(GeocodeClient.class);

    private final WebClient webClient;
    private final String baseUrl;
    private final String appId;

    public GeocodeClient(String baseUrl, String appId) {
        this.baseUrl = baseUrl;
        this.appId = appId;
        this.webClient = WebClient.create();
    }

    public Mono<GeocodeResponse> geocode(String location) {
        log.info("Geocoding location " + location);
        return webClient.get()
                .uri(baseUrl + "/geo/1.0/direct?q={location}&limit=1&appid={appId}", location, appId)
                .retrieve()
                .bodyToMono(GeocodeResponse.class);
    }

}
