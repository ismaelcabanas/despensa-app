package cabanas.garcia.ismael.storeroom.module.product.domain.repository.stubs;

import cabanas.garcia.ismael.storeroom.module.product.domain.model.Product;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.ProductId;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.ProductName;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.ProductQuantity;
import cabanas.garcia.ismael.storeroom.module.product.domain.repository.ProductRepository;
import org.apache.commons.lang3.NotImplementedException;
import org.assertj.core.api.Assertions;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class ProductRepositoryStub implements ProductRepository {
    private Product product;
    private ProductRepository productRepositoryMock;

    private ProductRepositoryStub() {
        productRepositoryMock = Mockito.mock(ProductRepository.class);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public void insert(Product aProduct) {
        this.product = aProduct;
        productRepositoryMock.insert(aProduct);
    }

    @Override
    public Optional<Product> findById(ProductId productId) {
        return (productId.equals(product.id()) ? Optional.of(product) : Optional.empty());
    }

    @Override
    public void update(Product aProduct) {
        this.product = aProduct;
        productRepositoryMock.update(aProduct);
    }

    @Override
    public ProductId nextIdentity() {
        return ProductId.builder().build();
    }

    @Override
    public Optional<Product> findByName(ProductName productName) {
        throw new NotImplementedException("Not implemented yet");
    }

    public void shouldUpdateProductWithQuantity(ProductQuantity anotherQuantity) {
        ArgumentCaptor<Product> argProduct = ArgumentCaptor.forClass(Product.class);
        verify(productRepositoryMock, times(1)).update(argProduct.capture());
        Assertions.assertThat(argProduct.getValue().quantity()).isEqualTo(anotherQuantity);
    }

    public static class Builder {
        public ProductRepositoryStub build() {
            return new ProductRepositoryStub();
        }
    }
}
