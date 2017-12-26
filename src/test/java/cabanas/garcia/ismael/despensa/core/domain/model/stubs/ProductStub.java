package cabanas.garcia.ismael.despensa.core.domain.model.stubs;

import cabanas.garcia.ismael.despensa.core.domain.model.Product;

public final class ProductStub {

    private ProductStub() {
    }

    public static Product random() {
        return Product.builder(ProductIdStub.random(), ProductNameStub.random(20), ProductQuantityStub.random()).build();
    }
}
