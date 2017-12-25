package cabanas.garcia.ismael.despensa.core.domain.model.stubs;

import cabanas.garcia.ismael.despensa.core.domain.model.ProductId;

import java.util.UUID;

public class ProductIdStub {
    public static ProductId random() {
        return ProductId.builder(UUID.randomUUID().toString()).build();
    }
}
