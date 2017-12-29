package stepdefinitions;

import cabanas.garcia.ismael.despensa.module.product.domain.model.Product;
import cabanas.garcia.ismael.despensa.module.product.domain.model.ProductName;
import cabanas.garcia.ismael.despensa.module.product.domain.model.ProductQuantity;
import cabanas.garcia.ismael.despensa.module.product.domain.repository.InMemoryProductRepository;
import cabanas.garcia.ismael.despensa.module.product.domain.repository.ProductRepository;
import cabanas.garcia.ismael.despensa.module.product.domain.service.StoreroomService;
import cabanas.garcia.ismael.despensa.module.product.domain.service.StoreroomServiceImpl;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class Steps {

    private StoreroomService storeroomService;

    private ProductRepository productRepository = new InMemoryProductRepository();

    @Given("^the storeroom is empty$")
    public void theStoreroomIsEmpty() throws Throwable {
        storeroomService = new StoreroomServiceImpl(productRepository);
    }

    @When("^I add (\\d+) (.+) product into storeroom$")
    public void addProductIntoStoreroom(int quantity, String name) throws Throwable {
        ProductName productName = ProductName.builder(name).build();
        ProductQuantity productQuantity = ProductQuantity.builder(quantity).build();
        storeroomService.add(productName, productQuantity);
    }

    @Then("^the storeroom has (\\d+) (?:item|items) of (.+)")
    public void theStoreroomHasItemOfProduct(int quantity, String name) throws Throwable {
        Optional<Product> product = storeroomService.findProductByName(ProductName.builder(name).build());
        assertThat(storeroomService.quantityOf(product.get().id())).isEqualTo(ProductQuantity.builder(quantity).build());
    }

    @Given("^the storeroom has$")
    public void theStoreroomHas(DataTable productsInStoreroom) throws Throwable {
        storeroomService = new StoreroomServiceImpl(productRepository);
        productsInStoreroom
                .raw()
                .stream()
                .skip(1)
                .forEach(rowData -> storeroomService.add(
                        ProductName.builder(rowData.get(0)).build(),
                        ProductQuantity.builder(Integer.parseInt(rowData.get(1))).build()));
    }

    @When("^I add (\\d+) (.*) product more into storeroom$")
    public void addProductMoreIntoStoreroom(int quantity, String name) throws Throwable {
        Optional<Product> product = storeroomService.findProductByName(ProductName.builder(name).build());
        product.ifPresent(product1 -> storeroomService.add(product1.id(), ProductQuantity.builder(quantity).build()));
    }
}
