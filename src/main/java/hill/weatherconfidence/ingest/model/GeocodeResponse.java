package hill.weatherconfidence.ingest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodeResponse extends ArrayList<GeocodeItem> {
    public GeocodeItem first() {
        if (this.size() > 0) {
            return this.get(0);
        } else {
            return GeocodeItem.defaultLocation(); // This is a bit lazy maybe, but means we won't get a null.
        }
    }
}
