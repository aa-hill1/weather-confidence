package hill.weatherconfidence.presentation;

public class PredictionConfidence {

    public PredictionConfidence(Double temperature) {
        this.temperature = temperature;
    }

    private final Double temperature;

    public Double getTemperature() {
        return temperature;
    }
}
