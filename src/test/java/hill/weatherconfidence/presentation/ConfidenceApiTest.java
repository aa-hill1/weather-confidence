package hill.weatherconfidence.presentation;

import hill.weatherconfidence.TestApplicationContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = TestApplicationContext.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConfidenceApiTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void helloTest() {
        PredictionConfidence response = this.restTemplate.getForObject("http://localhost:" + port + "/api",
                PredictionConfidence.class);
        assertEquals(0d, response.getTemperature());
    }

}
