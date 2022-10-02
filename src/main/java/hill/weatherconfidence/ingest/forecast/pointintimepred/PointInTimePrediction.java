package hill.weatherconfidence.ingest.forecast.pointintimepred;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)
public class PointInTimePrediction {
    private int dt;
    private String dt_txt;
    private int visibility;
    private PointPredMain main;
    private PointPredWeather weather;
    private PointPredCloud cloud;
    private PointPredWind wind;

    public PointInTimePrediction(int dt, String dt_txt, int visibility, PointPredMain main,
            PointPredWeather weather, PointPredCloud cloud, PointPredWind wind) {
        this.dt = dt;
        this.dt_txt = dt_txt;
        this.visibility = visibility;
        this.main = main;
        this.weather = weather;
        this.cloud = cloud;
        this.wind = wind;
    }

    public int getDt() {
        return dt;
    }
    public void setDt(int dt) {
        this.dt = dt;
    }

    public String getDt_txt() {
        return dt_txt;
    }
    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    public int getVisibility() {
        return visibility;
    }
    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }


}
