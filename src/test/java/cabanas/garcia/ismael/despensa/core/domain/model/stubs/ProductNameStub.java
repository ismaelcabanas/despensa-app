package cabanas.garcia.ismael.despensa.core.domain.model.stubs;

import cabanas.garcia.ismael.despensa.core.domain.model.ProductName;
import org.apache.commons.lang3.RandomStringUtils;

public class ProductNameStub {
    public static ProductName random(int characters) {
        return ProductName.builder(RandomStringUtils.random(characters)).build();
    }
}
