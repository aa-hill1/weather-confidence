package hill.weatherconfidence.presentation;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class PredictionConfidence {

    private Double temperature;

    // Temporary method - this requires a builder pattern.
    public static PredictionConfidence withTemperature(double temp) {
        PredictionConfidence confidence = new PredictionConfidence();
        confidence.setTemperature(temp);
        return confidence;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}
