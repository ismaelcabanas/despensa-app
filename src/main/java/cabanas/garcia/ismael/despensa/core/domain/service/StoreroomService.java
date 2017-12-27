package cabanas.garcia.ismael.despensa.core.domain.service;

import cabanas.garcia.ismael.despensa.core.domain.model.ProductId;
import cabanas.garcia.ismael.despensa.core.domain.model.ProductName;
import cabanas.garcia.ismael.despensa.core.domain.model.ProductQuantity;

public interface StoreroomService {
    void add(ProductId productId, ProductName productName, ProductQuantity quantity);

    void add(ProductId productId, ProductQuantity quantity);

    ProductQuantity quantityOf(ProductId productId);
}
