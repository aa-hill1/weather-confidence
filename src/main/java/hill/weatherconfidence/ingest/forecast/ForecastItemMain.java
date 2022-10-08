package hill.weatherconfidence.ingest.forecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)
public class ForecastItemMain {
    private Double temp;
    private Double feels_like;
    private Double temp_min;
    private Double temp_max;
    private int pressure;
    private int sea_level;
    private int grnd_level;
    private int humidity;
    private Double temp_kf;

    public static ForecastItemMain defaultForecast() {
        ForecastItemMain item = new ForecastItemMain();
        item.setTemp(0.0d);
        item.setFeels_like(0.0d);
        item.setTemp_min(0.0d);
        item.setTemp_max(0.0d);
        item.setPressure(0);
        item.setSea_level(0);
        item.setGrnd_level(0);
        item.setHumidity(0);
        item.setTemp_kf(0.0d);
        return item;
    }

    public Double getTemp() {
        return temp;
    }
    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getFeels_like() {
        return feels_like;
    }
    public void setFeels_like(Double feels_like) {
        this.feels_like = feels_like;
    }

    public Double getTemp_min() {
        return temp_min;
    }
    public void setTemp_min(Double temp_min) {
        this.temp_min = temp_min;
    }

    public Double getTemp_max() {
        return temp_max;
    }
    public void setTemp_max(Double temp_max) {
        this.temp_max = temp_max;
    }

    public int getPressure() {
        return pressure;
    }
    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getSea_level() {
        return sea_level;
    }
    public void setSea_level(int sea_level) {
        this.sea_level = sea_level;
    }

    public int getGrnd_level() {
        return grnd_level;
    }
    public void setGrnd_level(int grnd_level) {
        this.grnd_level = grnd_level;
    }

    public int getHumidity() {
        return humidity;
    }
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public Double getTemp_kf() {
        return temp_kf;
    }
    public void setTemp_kf(Double temp_kf) {
        this.temp_kf = temp_kf;
    }
}
