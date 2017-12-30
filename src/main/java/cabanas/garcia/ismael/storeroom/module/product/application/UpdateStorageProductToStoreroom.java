package cabanas.garcia.ismael.storeroom.module.product.application;

import cabanas.garcia.ismael.storeroom.module.product.domain.model.Product;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.ProductId;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.ProductQuantity;
import cabanas.garcia.ismael.storeroom.module.product.domain.repository.ProductRepository;

import java.util.Optional;

public class UpdateStorageProductToStoreroom {
    private final ProductRepository productRepository;

    public UpdateStorageProductToStoreroom(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void add(ProductId productId, ProductQuantity productQuantity) {
        Optional<Product> product = productRepository.findById(productId);
        product.ifPresent(p -> productRepository.update(p.add(productQuantity)));
    }
}
