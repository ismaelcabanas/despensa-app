package cabanas.garcia.ismael.despensa.module.product.domain.model.stubs;

import cabanas.garcia.ismael.despensa.module.product.domain.model.ProductName;
import org.apache.commons.lang3.RandomStringUtils;

public final class ProductNameStub {

    private ProductNameStub() { }

    public static ProductName random(int characters) {
        return ProductName.builder(RandomStringUtils.random(characters)).build();
    }
}
