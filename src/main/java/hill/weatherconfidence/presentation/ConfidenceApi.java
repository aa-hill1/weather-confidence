package hill.weatherconfidence.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfidenceApi {

    @GetMapping("/api")
    public PredictionConfidence hello() {
        return new PredictionConfidence(0d);
    }

    //TODO: Decide what needs to be in PredictionConfidence - what data to return?
    //TODO: Mock up data access - eventually will get data from a database and return it
    //TODO: What parameters do the callers need to provide?  Timestamp? What is the format of the timestamp?
    // Also location ID.

}
