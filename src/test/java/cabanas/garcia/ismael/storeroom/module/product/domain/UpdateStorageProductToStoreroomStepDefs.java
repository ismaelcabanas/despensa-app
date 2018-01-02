package cabanas.garcia.ismael.storeroom.module.product.domain;

import cabanas.garcia.ismael.storeroom.module.product.application.AddNewProductToStoreroom;
import cabanas.garcia.ismael.storeroom.module.product.application.UpdateStorageProductToStoreroom;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.Product;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.ProductName;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.ProductQuantity;
import cabanas.garcia.ismael.storeroom.module.product.domain.repository.InMemoryProductRepository;
import cabanas.garcia.ismael.storeroom.module.product.domain.repository.ProductRepository;
import cucumber.api.DataTable;
import cucumber.api.java8.En;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class UpdateStorageProductToStoreroomStepDefs implements En {

    public UpdateStorageProductToStoreroomStepDefs() {

        final ProductRepository productRepository = new InMemoryProductRepository();
        final UpdateStorageProductToStoreroom updateStorageProductToStoreroom =
                new UpdateStorageProductToStoreroom(productRepository);

        Given("^the storeroom has$", (DataTable productsInStoreroom) -> {
            AddNewProductToStoreroom addNewProductToStoreroom = new AddNewProductToStoreroom(productRepository);
            productsInStoreroom
                    .raw()
                    .stream()
                    .skip(1)
                    .forEach(rowData -> addNewProductToStoreroom.add(rowData.get(0),
                            Integer.parseInt(rowData.get(1))
                    ));
        });

        When("^I add (\\d+) items more of (.*) product into storeroom$", (Integer quantity, String productName) -> {
            Optional<Product> product = productRepository.findByName(ProductName.builder(productName).build());
            product.ifPresent(p -> updateStorageProductToStoreroom.add(p.id(), ProductQuantity.builder(quantity).build()));
        });

        Then("^the storeroom has (\\d+) items of (.*)", (Integer quantity, String productName) -> {
            Optional<Product> product = productRepository.findByName(ProductName.builder(productName).build());
            assertThat(product).isNotEmpty();
            product.ifPresent(p -> assertThat(p.quantity()).isEqualTo(ProductQuantity.builder(quantity).build()));
        });
    }

}
