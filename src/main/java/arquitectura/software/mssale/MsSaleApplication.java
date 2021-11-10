package arquitectura.software.mssale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsSaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSaleApplication.class, args);
	}

}
