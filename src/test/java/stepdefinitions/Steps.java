package stepdefinitions;

import cabanas.garcia.ismael.despensa.core.domain.model.*;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.UUID;

public class Steps {

    private Storeroom storeroom;
    private ProductId productId;

    @Given("^the storeroom is empty$")
    public void theStoreroomIsEmpty() throws Throwable {
        storeroom = Storeroom.builder().build();
    }

    @When("^I add (\\d+) (.+) product into storeroom$")
    public void iAddProductIntoStoreroom(int quantity, String name) throws Throwable {
        ProductName productName = ProductName.builder(name).build();
        ProductQuantity productQuantity = ProductQuantity.builder(quantity).build();
        productId = ProductId.builder(UUID.randomUUID().toString()).build();
        storeroom.add(productId, productName, productQuantity);
    }

    @Then("^the storeroom has (\\d+) (?:item|items) of (.+)")
    public void theStoreroomHasItemOfProduct(int quantity, String name) throws Throwable {
        Assertions.assertThat(storeroom.quantityOf(productId)).isEqualTo(quantity);
    }

    @Given("^the storeroom has$")
    public void theStoreroomHas(DataTable productsInStoreroom) throws Throwable {
        storeroom = Storeroom.builder().build();
        productsInStoreroom
                .raw()
                .stream()
                .skip(1)
                .forEach(rowData -> storeroom.add(
                        ProductId.builder(rowData.get(0)).build(),
                        ProductName.builder(rowData.get(1)).build(),
                        ProductQuantity.builder(Integer.parseInt(rowData.get(2))).build()));
    }

}
