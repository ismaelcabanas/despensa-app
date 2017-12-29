package cabanas.garcia.ismael.storeroom.module.product.domain.model;

import cabanas.garcia.ismael.storeroom.module.product.domain.model.stubs.ProductNameStub;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.stubs.ProductQuantityStub;
import cabanas.garcia.ismael.storeroom.module.product.domain.repository.ProductRepository;
import cabanas.garcia.ismael.storeroom.module.product.domain.repository.stubs.ProductRepositoryStub;
import cabanas.garcia.ismael.storeroom.module.product.domain.service.StoreroomService;
import cabanas.garcia.ismael.storeroom.module.product.domain.service.StoreroomServiceImpl;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class WhenAddNewProductIntoStoreroomShould {

    @Test public void
    add_existence_of_product_into_storeroom() {
        ProductName productName = ProductNameStub.random(20);
        ProductQuantity productQuantity = ProductQuantityStub.random();
        ProductRepository productRepositoryStub = ProductRepositoryStub.builder().build();
        StoreroomService storeroomService = new StoreroomServiceImpl(productRepositoryStub);

        Product product = storeroomService.add(productName, productQuantity);

        assertThat(product.quantity()).isEqualTo(productQuantity);
    }

}
