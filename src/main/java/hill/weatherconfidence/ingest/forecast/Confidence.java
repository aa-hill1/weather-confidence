package hill.weatherconfidence.ingest.forecast;

public class Confidence {
    private Double tempConf;
    private Double humidityConf;
    private Double weatherIdConf;
    private Double windSpeedConf;

    public Confidence(/*Metrics for calculations*/) {
        this.tempConf = calcConfidence(/*Relevant stats*/);
        this.humidityConf = calcConfidence(/*Relevant stats*/);
        this.weatherIdConf = calcConfidence(/*Relevant stats*/);
        this.windSpeedConf = calcConfidence(/*Relevant stats*/);
    }
    public Double calcConfidence(/*Metrics for calculations*/) {
        Double confRating = 0.00d;
        //Confidence calculation algorithm
        return confRating;
    }
}
