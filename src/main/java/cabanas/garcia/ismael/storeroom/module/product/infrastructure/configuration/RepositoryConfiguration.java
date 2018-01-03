package cabanas.garcia.ismael.storeroom.module.product.infrastructure.configuration;

import cabanas.garcia.ismael.storeroom.module.product.domain.repository.ProductRepository;
import cabanas.garcia.ismael.storeroom.module.product.infrastructure.repository.jdbc.PostgresJdbcProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class RepositoryConfiguration {

    @Bean
    public ProductRepository productRepository(DataSource dataSource) {
        return new PostgresJdbcProductRepository(dataSource);
    }
}
