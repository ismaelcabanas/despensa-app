package cabanas.garcia.ismael.despensa.core.domain.repository;

import cabanas.garcia.ismael.despensa.core.domain.model.Product;
import cabanas.garcia.ismael.despensa.core.domain.model.ProductId;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryProductRepository implements ProductRepository {

    private final Map<ProductId, Product> products = new HashMap<>();

    @Override
    public void insert(Product product) {
        save(product);
    }

    @Override
    public Optional<Product> findById(ProductId productId) {
        return Optional.of(products.get(productId));
    }

    @Override
    public void update(Product product) {
        save(product);
    }

    private Product save(Product product) {
        return products.put(product.id(), product);
    }
}
