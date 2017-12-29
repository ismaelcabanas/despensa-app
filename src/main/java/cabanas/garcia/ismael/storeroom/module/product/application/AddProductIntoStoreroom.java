package cabanas.garcia.ismael.storeroom.module.product.application;

import cabanas.garcia.ismael.storeroom.module.product.domain.model.Product;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.ProductName;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.ProductQuantity;
import cabanas.garcia.ismael.storeroom.module.product.domain.service.StoreroomService;

public class AddProductIntoStoreroom {
    private final StoreroomService storeroomService;

    public AddProductIntoStoreroom(StoreroomService storeroomService) {
        this.storeroomService = storeroomService;
    }

    public Product add(ProductName productName, ProductQuantity quantity) {
        return storeroomService.add(productName, quantity);
    }
}
