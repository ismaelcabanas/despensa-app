package cabanas.garcia.ismael.despensa.module.product.domain.service;

import cabanas.garcia.ismael.despensa.module.product.domain.model.Product;
import cabanas.garcia.ismael.despensa.module.product.domain.model.ProductId;
import cabanas.garcia.ismael.despensa.module.product.domain.model.ProductName;
import cabanas.garcia.ismael.despensa.module.product.domain.model.ProductQuantity;
import cabanas.garcia.ismael.despensa.module.product.domain.repository.ProductRepository;

import java.util.Optional;

public class StoreroomServiceImpl implements StoreroomService {

    private final ProductRepository productRepository;

    public StoreroomServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product add(ProductName productName, ProductQuantity quantity) {
        ProductId productId = productRepository.nextIdentity();
        Product product = Product.builder(productId, productName, quantity).build();
        productRepository.insert(product);
        return product;
    }

    @Override
    public void add(ProductId productId, ProductQuantity quantity) {
        Optional<Product> oldProduct = productRepository.findById(productId);
        oldProduct.ifPresent(product -> {
            product.add(quantity);
            productRepository.update(product);
        });

    }

    @Override
    public ProductQuantity quantityOf(ProductId productId) {
        return productRepository.findById(productId).get().quantity();
    }

    @Override
    public Optional<Product> findProductByName(ProductName name) {
        return productRepository.findByName(name);
    }

}
