package hill.weatherconfidence;

import com.google.cloud.kms.v1.CryptoKeyName;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

@Configuration
public class AppConfig {

    private final ConfigurableEnvironment environment;

    public AppConfig(ConfigurableEnvironment environment) {
        this.environment = environment;
    }

    @Bean
    public IKmsDecrypter kmsDecrypter() {
        return new KmsDecrypter(kmsClient(), kmsKey(), environment);
    }

    @Bean
    public WebClient webClient() {
        return WebClient.create();
    }

    private KeyManagementServiceClient kmsClient() {
        try {
            return KeyManagementServiceClient.create();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private CryptoKeyName kmsKey() {
        String projectId = environment.getProperty("gcp.projectId");
        String locationId = environment.getProperty("gcp.locationId");
        String keyRingId = environment.getProperty("gcp.keyRingId");
        String keyId = environment.getProperty("gcp.keyId");
        return CryptoKeyName.of(projectId, locationId, keyRingId, keyId);
    }

}
