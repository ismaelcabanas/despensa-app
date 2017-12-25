package cabanas.garcia.ismael.despensa.core.domain.model;

import cabanas.garcia.ismael.despensa.core.domain.model.stubs.ProductIdStub;
import cabanas.garcia.ismael.despensa.core.domain.model.stubs.ProductNameStub;
import cabanas.garcia.ismael.despensa.core.domain.model.stubs.ProductQuantityStub;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenAddNewProductIntoStoreroomShould {

    @Test public void
    the_product_is_added_to_storeroom() {
        Storeroom storeroom = Storeroom.builder().build();
        ProductId productId = ProductIdStub.random();
        ProductName productName = ProductNameStub.random(20);
        ProductQuantity productQuantity = ProductQuantityStub.random();

        storeroom.add(productId, productName, productQuantity);

        assertThat(storeroom.quantityOf(productId)).isEqualTo(productQuantity);
    }

}
