package cabanas.garcia.ismael.despensa.module.product.domain.repository;

import cabanas.garcia.ismael.despensa.module.product.domain.model.Product;
import cabanas.garcia.ismael.despensa.module.product.domain.model.ProductId;
import cabanas.garcia.ismael.despensa.module.product.domain.model.ProductName;

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

    @Override
    public ProductId nextIdentity() {
        return ProductId.builder().build();
    }

    @Override
    public Optional<Product> findByName(ProductName productName) {
        return products.entrySet().stream()
                .filter(entry -> productName.equals(entry.getValue().name()))
                .map(map -> map.getValue())
                .findFirst();
    }

    private Product save(Product product) {
        return products.put(product.id(), product);
    }
}
