package stepdefinitions;

import cabanas.garcia.ismael.despensa.core.domain.model.Product;
import cabanas.garcia.ismael.despensa.core.domain.model.Storeroom;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.List;

public class Steps {

    private Storeroom storeroom;

    @Given("^the storeroom is empty$")
    public void theStoreroomIsEmpty() throws Throwable {
        storeroom = Storeroom.builder().build();
    }

    @When("^I add (\\d+) (.+) product into storeroom$")
    public void iAddProductIntoStoreroom(int quantity, String productName) throws Throwable {
        Product product = Product.builder(productName).build();
        storeroom.add(product, quantity);
    }

    @And("^the storeroom has (\\d+) items of (.+)")
    public void theStoreroomHasItemOfProduct(int quantity, String productName) throws Throwable {
        Product product = Product.builder(productName).build();
        Assertions.assertThat(storeroom.count(product)).isEqualTo(quantity);
    }

    @Given("^the storeroom has$")
    public void theStoreroomHas(DataTable productsInStoreroom) throws Throwable {
        storeroom = Storeroom.builder().build();
        productsInStoreroom
                .raw()
                .stream()
                .skip(1)
                .forEach(rowData -> storeroom.add(Product.builder(rowData.get(0)).build(), Integer.parseInt(rowData.get(1))));
    }

    @Then("^the storeroom has (\\d+) products$")
    public void theStoreroomHasProducts(int quantity) throws Throwable {
        Assertions.assertThat(storeroom.size()).isEqualTo(quantity);
    }

}
