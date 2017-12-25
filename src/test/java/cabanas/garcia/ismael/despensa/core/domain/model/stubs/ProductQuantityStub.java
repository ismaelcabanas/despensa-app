package cabanas.garcia.ismael.despensa.core.domain.model.stubs;

import cabanas.garcia.ismael.despensa.core.domain.model.ProductQuantity;

public class ProductQuantityStub {
    public static ProductQuantity random() {
        return ProductQuantity.builder(IntStub.random()).build();
    }
}
