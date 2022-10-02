package hill.weatherconfidence.ingest.forecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastResponse extends ArrayList<ForecastItem> {
    public ForecastItem first() {
        if (this.size() > 0) {
            return this.get(0);
        } else {
            return ForecastItem.defaultForecast();
        }
    }
}
