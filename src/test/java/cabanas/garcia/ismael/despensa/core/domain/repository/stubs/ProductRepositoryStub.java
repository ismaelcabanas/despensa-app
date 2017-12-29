package cabanas.garcia.ismael.despensa.core.domain.repository.stubs;

import cabanas.garcia.ismael.despensa.core.domain.model.Product;
import cabanas.garcia.ismael.despensa.core.domain.model.ProductId;
import cabanas.garcia.ismael.despensa.core.domain.model.ProductName;
import cabanas.garcia.ismael.despensa.core.domain.repository.ProductRepository;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Optional;

public class ProductRepositoryStub implements ProductRepository {
    private Product product;

    private ProductRepositoryStub() {
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public void insert(Product aProduct) {
        this.product = aProduct;
    }

    @Override
    public Optional<Product> findById(ProductId productId) {
        return (productId.equals(product.id()) ? Optional.of(product) : Optional.empty());
    }

    @Override
    public void update(Product aProduct) {
        this.product = aProduct;
    }

    @Override
    public ProductId nextIdentity() {
        return ProductId.builder().build();
    }

    @Override
    public Optional<Product> findByName(ProductName productName) {
        throw new NotImplementedException("Not implemented yet");
    }

    public static class Builder {
        public ProductRepository build() {
            return new ProductRepositoryStub();
        }
    }
}
