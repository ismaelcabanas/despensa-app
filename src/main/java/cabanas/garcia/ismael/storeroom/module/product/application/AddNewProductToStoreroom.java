package cabanas.garcia.ismael.storeroom.module.product.application;

import cabanas.garcia.ismael.storeroom.module.product.domain.model.Product;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.ProductId;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.ProductName;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.ProductQuantity;
import cabanas.garcia.ismael.storeroom.module.product.domain.repository.ProductRepository;

public class AddNewProductToStoreroom {

    private final ProductRepository productRepository;

    public AddNewProductToStoreroom(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductId add(String productName, int productQuantity) {
        ProductId identity = productRepository.nextIdentity();
        productRepository.insert(Product.builder(
                identity,
                ProductName.builder(productName).build(),
                ProductQuantity.builder(productQuantity).build()).build());
        return identity;
    }
}
