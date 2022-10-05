package hill.weatherconfidence.ingest.forecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastResponse {

    private String cod;
    private int message;
    private int cnt;

    private ForecastList list;

    public ForecastItem first() {
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return ForecastItem.defaultForecast();
        }
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public ForecastList getList() {
        return list;
    }

    public void setList(ForecastList list) {
        this.list = list;
    }
}
