package cabanas.garcia.ismael.despensa.core.domain.model;

import cabanas.garcia.ismael.despensa.core.domain.model.stubs.ProductIdStub;
import cabanas.garcia.ismael.despensa.core.domain.model.stubs.ProductNameStub;
import cabanas.garcia.ismael.despensa.core.domain.model.stubs.ProductQuantityStub;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class WhenAddExistentProductIntoStoreroomShould {

    @Test public void
    increment_existences_of_product_in_storeroom() {
        Storeroom storeroom = Storeroom.builder().build();
        ProductId productId = ProductIdStub.random();
        ProductName someName = ProductNameStub.random(20);
        ProductQuantity someQuantity = ProductQuantityStub.random();
        storeroom.add(productId, someName, someQuantity);
        ProductQuantity anotherQuantity = ProductQuantityStub.random();
        ProductQuantity quantityExpected = someQuantity.sum(anotherQuantity);

        storeroom.add(productId, anotherQuantity);

        assertThat(storeroom.quantityOf(productId)).isEqualTo(quantityExpected);
    }
}
