package cabanas.garcia.ismael.despensa.core.domain.service;

import cabanas.garcia.ismael.despensa.core.domain.model.Product;
import cabanas.garcia.ismael.despensa.core.domain.model.ProductId;
import cabanas.garcia.ismael.despensa.core.domain.model.ProductName;
import cabanas.garcia.ismael.despensa.core.domain.model.ProductQuantity;
import cabanas.garcia.ismael.despensa.core.domain.repository.ProductRepository;

import java.util.Optional;

public class StoreroomServiceImpl implements StoreroomService {

    private final ProductRepository productRepository;

    public StoreroomServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void add(ProductId productId, ProductName productName, ProductQuantity quantity) {
        Product product = Product.builder(productId, productName, quantity).build();
        productRepository.insert(product);
    }

    public void add(ProductId productId, ProductQuantity quantity) {
        Optional<Product> oldProduct = productRepository.findById(productId);
        oldProduct.ifPresent(product -> {
            product.add(quantity);
            productRepository.update(product);
        });

    }

    public ProductQuantity quantityOf(ProductId productId) {
        return productRepository.findById(productId).get().quantity();
    }

}
