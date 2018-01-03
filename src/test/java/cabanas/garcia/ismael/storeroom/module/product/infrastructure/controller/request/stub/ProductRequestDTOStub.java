package cabanas.garcia.ismael.storeroom.module.product.infrastructure.controller.request.stub;

import cabanas.garcia.ismael.storeroom.module.product.infrastructure.controller.request.ProductRequestDTO;

public final class ProductRequestDTOStub {

    private ProductRequestDTOStub() { }

    public static ProductRequestDTO random() {
        return new ProductRequestDTO();
    }
}
