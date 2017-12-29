package cabanas.garcia.ismael.storeroom.module.product.domain.service;

import cabanas.garcia.ismael.storeroom.module.product.domain.model.Product;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.ProductId;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.ProductName;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.ProductQuantity;

public interface StoreroomService {
    Product add(ProductName productName, ProductQuantity quantity);

    void add(ProductId productId, ProductQuantity quantity);

}
