package cabanas.garcia.ismael.storeroom.module.product.domain.model;

import cabanas.garcia.ismael.storeroom.module.product.domain.model.stubs.ProductNameStub;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.stubs.ProductQuantityStub;
import cabanas.garcia.ismael.storeroom.module.product.domain.repository.stubs.ProductRepositoryStub;
import cabanas.garcia.ismael.storeroom.module.product.domain.service.StoreroomService;
import cabanas.garcia.ismael.storeroom.module.product.domain.service.StoreroomServiceImpl;
import org.junit.Test;

public final class WhenAddExistentProductIntoStoreroomShould {

    @Test public void
    increment_existences_of_product_in_storeroom() {
        ProductName someName = ProductNameStub.random(20);
        ProductQuantity someQuantity = ProductQuantityStub.random();
        ProductRepositoryStub productRepositoryStub = ProductRepositoryStub.builder().build();
        StoreroomService storeroomService = new StoreroomServiceImpl(productRepositoryStub);
        Product product = storeroomService.add(someName, someQuantity);
        ProductQuantity anotherQuantity = ProductQuantityStub.random();

        storeroomService.add(product.id(), anotherQuantity);

        productRepositoryStub.shouldUpdateProductWithQuantity(anotherQuantity.sum(someQuantity));
    }
}
