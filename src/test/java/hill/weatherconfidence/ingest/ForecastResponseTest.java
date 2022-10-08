package hill.weatherconfidence.ingest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hill.weatherconfidence.ingest.forecast.ForecastResponse;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.time.Instant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ForecastResponseTest {

    private ObjectMapper om = new ObjectMapper();

    @Test
    public void deserializeResponseTest() throws IOException {
        String json = Files.readString(
                new ClassPathResource("fixtures/forecastResponse.json").getFile().toPath()
        );
        ForecastResponse expectedResponse = om.readValue(json, ForecastResponse.class);

        // This will fail - I doubt there are three items in this array, but it lets you check whether the serialization
        // works at all - you can update and expand the test when you know if it works overall to add in more assertions
        // for things you expect to have deserialized
        assertTrue(expectedResponse.first().getMain().getTemp().equals(288.68));

        // The test is currently failing because you're trying to deserialize the API response into what looks like
        // a structure you'd use for the database - which includes confidence and multiple predictions for a single
        // point in time.
    }

    @Test
    public void datesAreExpectedFormat() throws IOException {
        String json = Files.readString(
                new ClassPathResource("fixtures/forecastResponse.json").getFile().toPath()
        );
        ForecastResponse expectedResponse = om.readValue(json, ForecastResponse.class);
        String dateTimeText = expectedResponse.first().getDt_txt();
        // TODO: Parse date properly into an Instant
        Instant parsed = Instant.now();
    }

}
