package cabanas.garcia.ismael.despensa.core.domain.model;

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
        ProductName someName = ProductNameStub.random(20);
        ProductQuantity someQuantity = ProductQuantityStub.random();
        ProductRepository productRepositoryStub = ProductRepositoryStub.builder().build();
        StoreroomService storeroomService = new StoreroomServiceImpl(productRepositoryStub);
        Product product = storeroomService.add(someName, someQuantity);
        ProductQuantity anotherQuantity = ProductQuantityStub.random();

        storeroomService.add(product.id(), anotherQuantity);

        assertThat(storeroomService.quantityOf(product.id())).isEqualTo(someQuantity.sum(anotherQuantity));
    }
}
