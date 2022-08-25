package hill.weatherconfidence.ingest;


import hill.weatherconfidence.ingest.model.GeocodeItem;
import hill.weatherconfidence.ingest.model.GeocodeResponse;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeocodeClientTest {

    public static MockWebServer mockBackEnd;
    private GeocodeClient client = null;

    @BeforeAll
    static void setUp() throws IOException {
        mockBackEnd = new MockWebServer();
        mockBackEnd.start();
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockBackEnd.shutdown();
    }

    @BeforeEach
    void beforeEach() {
        String baseUrl = String.format("http://localhost:%s", mockBackEnd.getPort());
        client = new GeocodeClient(baseUrl, "foo");
    }

    @Test
    public void queryKnownLocation_andReturnCoordinates() throws InterruptedException {
        mockBackEnd.enqueue(new MockResponse()
                .setBody("[{\"name\":\"Hemel Hempstead\",\"local_names\":{\"en\":\"Hemel Hempstead\",\"ru\":\"Хемел-Хемпстед\"},\"lat\":51.7511784,\"lon\":-0.472528,\"country\":\"GB\",\"state\":\"England\"}]")
                .addHeader("Content-Type", "application/json"));

        Mono<GeocodeResponse> geocoded = client.geocode("Hemel Hempstead");

        GeocodeItem expected = new GeocodeItem();
        expected.setCountry("GB");
        expected.setLat(Double.parseDouble("51.7511784"));
        expected.setLon(Double.parseDouble("-0.472528"));
        expected.setName("Hemel Hempstead");
        StepVerifier.create(geocoded)
                .expectNextMatches(item -> item.first()
                        .equals(expected))
                .verifyComplete();

        RecordedRequest recordedRequest = mockBackEnd.takeRequest();

        assertEquals("GET", recordedRequest.getMethod());
        assertEquals("/geo/1.0/direct?q=Hemel%20Hempstead&limit=1&appid=foo", recordedRequest.getPath());

    }

    @Test
    public void queryUnknownLocation_andReturnDefault() throws InterruptedException {
        mockBackEnd.enqueue(new MockResponse()
                .setBody("[]")
                .addHeader("Content-Type", "application/json"));
        Mono<GeocodeResponse> geocoded = client.geocode("Nowhere");

        StepVerifier.create(geocoded)
                .expectNextMatches(item -> item.first()
                        .equals(GeocodeItem.defaultLocation()))
                .verifyComplete();

        RecordedRequest recordedRequest = mockBackEnd.takeRequest();

        assertEquals("GET", recordedRequest.getMethod());
        assertEquals("/geo/1.0/direct?q=Nowhere&limit=1&appid=foo", recordedRequest.getPath());
    }

}
