package hill.weatherconfidence.ingest;

import hill.weatherconfidence.ingest.forecast.ForecastResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class ForecastClient {

    private static final Logger log = LoggerFactory.getLogger(ForecastClient.class);
    private final WebClient webClient;
    private final String baseUrl;
    private final String appId;

    public ForecastClient(String baseUrl, String appId) {
        this.baseUrl = baseUrl;
        this.appId = appId;
        this.webClient = WebClient.create();
    }
    private Mono<ForecastResponse> forecast() {
        log.info("Forecasting");
        return webClient.get()
                .uri(baseUrl+"/data/2.5/forecast?id=524901&appid={appId}", appId)
                .retrieve()
                .bodyToMono(ForecastResponse.class);
    }
}
