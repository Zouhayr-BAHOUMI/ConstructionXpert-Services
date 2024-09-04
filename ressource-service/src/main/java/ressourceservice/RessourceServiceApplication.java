package ressourceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RessourceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RessourceServiceApplication.class, args);
    }

}
