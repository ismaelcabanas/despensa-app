package stepdefinitions;

import cabanas.garcia.ismael.despensa.core.domain.model.ProductId;
import cabanas.garcia.ismael.despensa.core.domain.model.ProductName;
import cabanas.garcia.ismael.despensa.core.domain.model.ProductQuantity;
import cabanas.garcia.ismael.despensa.core.domain.service.StoreroomService;
import cabanas.garcia.ismael.despensa.core.domain.service.StoreroomServiceImpl;
import cabanas.garcia.ismael.despensa.core.domain.repository.ProductRepository;
import cabanas.garcia.ismael.despensa.core.domain.repository.InMemoryProductRepository;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class Steps {

    private StoreroomService storeroomService;
    private ProductId productId;

    private Map<String, String> mapProducts = new HashMap<>();
    private ProductRepository productRepository = new InMemoryProductRepository();

    @Given("^the storeroom is empty$")
    public void theStoreroomIsEmpty() throws Throwable {
        storeroomService = new StoreroomServiceImpl(productRepository);
    }

    @When("^I add (\\d+) (.+) product into storeroom$")
    public void addProductIntoStoreroom(int quantity, String name) throws Throwable {
        ProductName productName = ProductName.builder(name).build();
        ProductQuantity productQuantity = ProductQuantity.builder(quantity).build();
        productId = ProductId.builder(UUID.randomUUID().toString()).build();
        storeroomService.add(productId, productName, productQuantity);
    }

    @Then("^the storeroom has (\\d+) (?:item|items) of (.+)")
    public void theStoreroomHasItemOfProduct(int quantity, String name) throws Throwable {
        assertThat(storeroomService.quantityOf(productId)).isEqualTo(ProductQuantity.builder(quantity).build());
    }

    @Given("^the storeroom has$")
    public void theStoreroomHas(DataTable productsInStoreroom) throws Throwable {
        storeroomService = new StoreroomServiceImpl(productRepository);
        productsInStoreroom
                .raw()
                .stream()
                .skip(1)
                .forEach(rowData -> storeroomService.add(
                        ProductId.builder(rowData.get(0)).build(),
                        ProductName.builder(rowData.get(1)).build(),
                        ProductQuantity.builder(Integer.parseInt(rowData.get(2))).build()));

        productsInStoreroom
                .raw()
                .stream()
                .skip(1)
                .forEach(rowData -> mapProducts.put(rowData.get(1), rowData.get(0)));

    }

    @When("^I add (\\d+) (.*) product more into storeroom$")
    public void addMilkProductMoreIntoStoreroom(int quantity, String name) throws Throwable {
        productId = ProductId.builder(mapProducts.get(name)).build();
        storeroomService.add(productId, ProductQuantity.builder(quantity).build());
    }
}
