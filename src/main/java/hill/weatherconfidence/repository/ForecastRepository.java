package hill.weatherconfidence.repository;

import hill.weatherconfidence.ingest.forecast.ForecastResponse;
import hill.weatherconfidence.ingest.model.GeocodeItem;

public interface ForecastRepository {
    public void store(GeocodeItem loc, ForecastResponse forecast);
}
