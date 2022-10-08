package hill.weatherconfidence.repository.model;

import hill.weatherconfidence.ingest.forecast.ForecastItem;
import hill.weatherconfidence.ingest.forecast.ForecastResponse;
import hill.weatherconfidence.ingest.model.GeocodeItem;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PredictionData {

    private Map<Instant, List<ForecastItem>> forecasts = new HashMap<>();

    public static PredictionData forLocation(GeocodeItem loc, ForecastResponse forecast) {
        return new PredictionData();
    }

    public void addForecastResponse(ForecastResponse forecast) {
        forecast.getList().forEach(item -> {
            // TODO: Parse out the Instant from the date in the forecastItem
            // If forecasts.containsKey(instant) is null, put a new ArrayList as the value for that instant
            // Add the forecast item into that list
            item.getDt_txt();
            // Get an Instant from this
            Instant instant = null;
            if (forecasts.containsKey(instant)) {
                // Then you can add the forecasts to this (if the list is not null)
                List<ForecastItem> items = forecasts.get(instant);
                items.add(item);
                forecasts.put(instant, items);
            } else {
                // Definitely need to create a new list for this instant
                List<ForecastItem> items = new ArrayList<>();
                items.add(item);
                forecasts.put(instant, items);
            }
        });
    }
}
