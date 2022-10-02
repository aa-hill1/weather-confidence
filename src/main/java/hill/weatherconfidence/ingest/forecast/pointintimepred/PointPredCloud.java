package hill.weatherconfidence.ingest.forecast.pointintimepred;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)
public class PointPredCloud {
    private int all;
    public PointPredCloud(int all) {
        this.all = all;
    }
    public int getAll() {
        return all;
    }
    public void setAll(int all) {
        this.all = all;
    }
}
