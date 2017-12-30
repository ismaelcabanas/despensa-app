package cabanas.garcia.ismael.storeroom.module.product.domain;

import cabanas.garcia.ismael.storeroom.module.product.application.AddNewProductToStoreroom;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.Product;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.ProductName;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.ProductQuantity;
import cabanas.garcia.ismael.storeroom.module.product.domain.repository.InMemoryProductRepository;
import cabanas.garcia.ismael.storeroom.module.product.domain.repository.ProductRepository;
import cucumber.api.DataTable;
import cucumber.api.java8.En;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class AddNewProductToStoreroomStepDefs implements En {

    private ProductRepository productRepository;
    private AddNewProductToStoreroom addNewProductToStoreroom;

    public AddNewProductToStoreroomStepDefs() {

        Before(() -> {
            productRepository = new InMemoryProductRepository();
        });

        Given("^the storeroom has$", (DataTable productsInStoreroom) -> {
            addNewProductToStoreroom = new AddNewProductToStoreroom(productRepository);
            productsInStoreroom
                    .raw()
                    .stream()
                    .skip(1)
                    .forEach(rowData -> addProductToStoreroom(
                            Integer.parseInt(rowData.get(1)),
                            rowData.get(0)
                    ));
        });

        When("^I add (\\d+) items of new (.*) product into storeroom$", (Integer quantity, String productName) -> {
            addProductToStoreroom(quantity, productName);
        });

        Then("^the storeroom has a new (.*) product with (\\d+) items$", (String productName, Integer quantity) -> {
            Optional<Product> product = productRepository.findByName(ProductName.builder(productName).build());
            assertThat(product).isNotEmpty();
            product.ifPresent(p -> assertThat(p.quantity()).isEqualTo(ProductQuantity.builder(quantity).build()));
        });

    }

    private void addProductToStoreroom(Integer quantity, String productName) {
        addNewProductToStoreroom.add(ProductName.builder(productName).build(),
                ProductQuantity.builder(quantity).build());
    }
}
