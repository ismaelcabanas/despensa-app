package cabanas.garcia.ismael.despensa.core.domain.repository;

import cabanas.garcia.ismael.despensa.core.domain.model.Product;
import cabanas.garcia.ismael.despensa.core.domain.model.ProductId;
import cabanas.garcia.ismael.despensa.core.domain.model.ProductName;

import java.util.Optional;

public interface ProductRepository {
    void insert(Product product);

    Optional<Product> findById(ProductId productId);

    void update(Product product);

    ProductId nextIdentity();

    Optional<Product> findByName(ProductName productName);
}
