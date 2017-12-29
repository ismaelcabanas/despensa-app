package cabanas.garcia.ismael.despensa.core.domain.model.stubs;

import cabanas.garcia.ismael.despensa.core.domain.model.ProductId;

public final class ProductIdStub {

    private ProductIdStub() { }

    public static ProductId random() {
        return ProductId.builder().build();
    }
}
