package cabanas.garcia.ismael.storeroom.module.product.infrastructure.controller.request.stub;

import cabanas.garcia.ismael.storeroom.module.product.domain.model.stubs.IntStub;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.stubs.StringStub;
import cabanas.garcia.ismael.storeroom.module.product.infrastructure.controller.request.ProductRequestDTO;

public final class ProductRequestDTOStub {

    private ProductRequestDTOStub() { }

    public static ProductRequestDTO random() {
        ProductRequestDTO requestDto = new ProductRequestDTO();
        requestDto.setName(StringStub.random(10));
        requestDto.setQuantity(IntStub.random());
        return requestDto;
    }
}
