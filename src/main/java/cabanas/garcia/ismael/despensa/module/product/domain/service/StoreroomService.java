package cabanas.garcia.ismael.despensa.module.product.domain.service;

import cabanas.garcia.ismael.despensa.module.product.domain.model.Product;
import cabanas.garcia.ismael.despensa.module.product.domain.model.ProductId;
import cabanas.garcia.ismael.despensa.module.product.domain.model.ProductName;
import cabanas.garcia.ismael.despensa.module.product.domain.model.ProductQuantity;

import java.util.Optional;

public interface StoreroomService {
    Product add(ProductName productName, ProductQuantity quantity);

    void add(ProductId productId, ProductQuantity quantity);

    ProductQuantity quantityOf(ProductId productId);

    Optional<Product> findProductByName(ProductName name);
}
