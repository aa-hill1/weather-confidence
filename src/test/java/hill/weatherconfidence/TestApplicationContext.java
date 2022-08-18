package hill.weatherconfidence;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@TestConfiguration
public class TestApplicationContext {

    @Primary
    @Bean
    public IKmsDecrypter kmsDecrypter() {
        return new TestKmsDecrypter();
    }
}
