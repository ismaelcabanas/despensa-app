package cabanas.garcia.ismael.despensa.core.domain.model.stubs;

import cabanas.garcia.ismael.despensa.core.domain.model.ProductQuantity;

public final class ProductQuantityStub {

    private ProductQuantityStub() { }

    public static ProductQuantity random() {
        return ProductQuantity.builder(IntStub.random()).build();
    }
}
