package hill.weatherconfidence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WeatherConfidenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherConfidenceApplication.class, args);
	}

}
