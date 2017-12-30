package cabanas.garcia.ismael.storeroom.module.product.application;

import cabanas.garcia.ismael.storeroom.module.product.domain.model.Product;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.ProductName;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.ProductQuantity;
import cabanas.garcia.ismael.storeroom.module.product.domain.repository.ProductRepository;

public class AddNewProductToStoreroom {

    private final ProductRepository productRepository;

    public AddNewProductToStoreroom(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void add(ProductName productName, ProductQuantity productQuantity) {
        productRepository.insert(Product.builder(
                productRepository.nextIdentity(),
                productName,
                productQuantity).build());
    }
}
