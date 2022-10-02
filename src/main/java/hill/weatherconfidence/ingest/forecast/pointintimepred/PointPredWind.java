package hill.weatherconfidence.ingest.forecast.pointintimepred;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PointPredWind {
    private Double speed;
    private int deg;
    private Double gust;

    public PointPredWind(Double speed, int deg, Double gust) {
        this.speed = speed;
        this.deg = deg;
        this.gust = gust;
    }

    public Double getSpeed() {
        return speed;
    }
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }
    public void setDeg(int deg) {
        this.deg = deg;
    }

    public Double getGust() {
        return gust;
    }
    public void setGust(Double gust) {
        this.gust = gust;
    }
}
