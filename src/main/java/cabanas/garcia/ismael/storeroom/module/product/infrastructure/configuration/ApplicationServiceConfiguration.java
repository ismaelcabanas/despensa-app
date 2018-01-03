package cabanas.garcia.ismael.storeroom.module.product.infrastructure.configuration;

import cabanas.garcia.ismael.storeroom.module.product.application.AddNewProductToStoreroom;
import cabanas.garcia.ismael.storeroom.module.product.domain.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationServiceConfiguration {

    @Bean
    public AddNewProductToStoreroom addNewProductToStoreroom(ProductRepository productRepository) {
        return new AddNewProductToStoreroom(productRepository);
    }
}
