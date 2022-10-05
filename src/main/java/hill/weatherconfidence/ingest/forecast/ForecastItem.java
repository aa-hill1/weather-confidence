package hill.weatherconfidence.ingest.forecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hill.weatherconfidence.ingest.forecast.pointintimepred.PointInTimePrediction;

import java.util.ArrayList;

//TODO: This needs to reflect the fields that you'd get the top-level list.  Start off with just
//int dt;
//for now, then build up gradually.  Best to do this in a test.

@JsonIgnoreProperties (ignoreUnknown = true)
public class ForecastItem {
    private String cod;
    private int message;
    private int cnt;
    private ArrayList<PointInTimePrediction> predictions;
    private Confidence confidence;

    public String getCod() {return cod;}
    public void setCod(String cod) {this.cod = cod;}
    public int getMessage() {return message;}
    public void setMessage(int message) {this.message = message;}
    public int getCnt() {return cnt;}
    public void setCnt(int cnt) {this.cnt = cnt;}
    public ArrayList<PointInTimePrediction> getPredictions() {
        return predictions;
    }
    public void setPredictions(ArrayList<PointInTimePrediction> predictions) {
        this.predictions = predictions;
    }
    public Confidence getConfidence() {
        return confidence;
    }
    public void setConfidence(Confidence confidence) {
        this.confidence = confidence;
    }

    public static ForecastItem defaultForecast() {
        ForecastItem item = new ForecastItem();
        item.setCnt(0);
        item.setCod("0");
        item.setMessage(0);
        item.setPredictions(new ArrayList<>());
        item.setConfidence(new Confidence(/*Metrics for calculations == 0*/));
        return item;
    }
}
