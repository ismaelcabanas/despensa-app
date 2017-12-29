package cabanas.garcia.ismael.despensa.module.product.domain.model.stubs;

import cabanas.garcia.ismael.despensa.module.product.domain.model.ProductId;

public final class ProductIdStub {

    private ProductIdStub() { }

    public static ProductId random() {
        return ProductId.builder().build();
    }
}
