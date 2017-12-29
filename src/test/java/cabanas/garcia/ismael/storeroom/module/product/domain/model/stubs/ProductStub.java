package cabanas.garcia.ismael.storeroom.module.product.domain.model.stubs;

import cabanas.garcia.ismael.storeroom.module.product.domain.model.Product;

public final class ProductStub {

    private ProductStub() {
    }

    public static Product random() {
        return Product.builder(ProductIdStub.random(), ProductNameStub.random(20), ProductQuantityStub.random()).build();
    }
}
