package springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(basePackages = {"springboot"})
public class ServiceApp {
	public static void main(String[] args) {
		SpringApplication.run(ServiceApp.class, args);
	
	}

}
