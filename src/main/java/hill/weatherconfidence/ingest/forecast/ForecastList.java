package hill.weatherconfidence.ingest.forecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties (ignoreUnknown = true)
public class ForecastList extends ArrayList<ForecastItem> {


}
