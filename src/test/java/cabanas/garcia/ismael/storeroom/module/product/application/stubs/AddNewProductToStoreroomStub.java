package cabanas.garcia.ismael.storeroom.module.product.application.stubs;

import cabanas.garcia.ismael.storeroom.module.product.application.AddNewProductToStoreroom;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.ProductId;
import cabanas.garcia.ismael.storeroom.module.product.domain.repository.ProductRepository;
import org.mockito.Mockito;

public final class AddNewProductToStoreroomStub extends AddNewProductToStoreroom{
    private ProductId productId;

    private AddNewProductToStoreroomStub(Builder builder) {
        super(Mockito.mock(ProductRepository.class));
        productId = builder.productId;
    }

    @Override
    public ProductId add(String productName, int productQuantity) {
        return productId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ProductId productId;

        public Builder whenProductIsAdded(ProductId productId) {
            this.productId = productId;
            return this;
        }

        public AddNewProductToStoreroom build() {
            return new AddNewProductToStoreroomStub(this);
        }
    }
}
