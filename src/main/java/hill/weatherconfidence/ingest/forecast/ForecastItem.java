package hill.weatherconfidence.ingest.forecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hill.weatherconfidence.ingest.forecast.pointintimepred.PointInTimePrediction;

import java.util.ArrayList;

//TODO: This needs to reflect the fields that you'd get the top-level list.  Start off with just
//int dt;
//for now, then build up gradually.  Best to do this in a test.

@JsonIgnoreProperties (ignoreUnknown = true)
public class ForecastItem {
    private int dt;
    private String dt_txt;
    private ForecastItemMain main;
    //private ForecastWeather weather;
    //private ForecastClouds clouds;
    //private ForecastWind wind;
    //private int visibility;
    //private Double pop;

    public static ForecastItem defaultForecast() {
        ForecastItem item = new ForecastItem();
        item.setDt(0);
        item.setDt_txt("0000-00-00 00:00:00");
        item.setMain(ForecastItemMain.defaultForecast());
        return item;
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

    public ForecastItemMain getMain() {
        return main;
    }
    public void setMain(ForecastItemMain main) {
        this.main = main;
    }
}
