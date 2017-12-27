package cabanas.garcia.ismael.despensa.core.domain.model;

import cabanas.garcia.ismael.despensa.core.domain.model.stubs.ProductIdStub;
import cabanas.garcia.ismael.despensa.core.domain.model.stubs.ProductNameStub;
import cabanas.garcia.ismael.despensa.core.domain.model.stubs.ProductQuantityStub;
import cabanas.garcia.ismael.despensa.core.domain.repository.ProductRepository;
import cabanas.garcia.ismael.despensa.core.domain.repository.stubs.ProductRepositoryStub;
import cabanas.garcia.ismael.despensa.core.domain.service.StoreroomService;
import cabanas.garcia.ismael.despensa.core.domain.service.StoreroomServiceImpl;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class WhenAddExistentProductIntoStoreroomShould {

    @Test public void
    increment_existences_of_product_in_storeroom() {
        ProductId productId = ProductIdStub.random();
        ProductName someName = ProductNameStub.random(20);
        ProductQuantity someQuantity = ProductQuantityStub.random();
        ProductRepository productRepositoryStub = ProductRepositoryStub.builder().build();
        StoreroomService storeroomService = new StoreroomServiceImpl(productRepositoryStub);
        storeroomService.add(productId, someName, someQuantity);
        ProductQuantity anotherQuantity = ProductQuantityStub.random();

        storeroomService.add(productId, anotherQuantity);

        assertThat(storeroomService.quantityOf(productId)).isEqualTo(someQuantity.sum(anotherQuantity));
    }
}
