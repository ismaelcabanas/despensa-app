package cabanas.garcia.ismael.storeroom.module.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "cabanas.garcia.ismael.storeroom.module.product.infrastructure.configuration",
        "cabanas.garcia.ismael.storeroom.module.product.infrastructure.controller"
})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
