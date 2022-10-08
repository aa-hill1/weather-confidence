package hill.weatherconfidence.repository;

import hill.weatherconfidence.ingest.forecast.ForecastResponse;
import hill.weatherconfidence.repository.model.PredictionData;
import hill.weatherconfidence.ingest.forecast.ForecastItem;
import hill.weatherconfidence.ingest.model.GeocodeItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryForecastRepository implements ForecastRepository{

    private static Logger log = LoggerFactory.getLogger(InMemoryForecastRepository.class);

    private Map<GeocodeItem, PredictionData> data = new HashMap<>();

    @Override
    public void store(GeocodeItem loc, ForecastResponse forecast) {
        if (!data.containsKey(loc)) {
            data.put(loc, PredictionData.forLocation(loc, forecast));
        } else {
            data.get(loc).addForecastResponse(forecast);
        }

        log.info("Stored prediction in memory");
    }
}
