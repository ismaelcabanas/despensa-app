package cabanas.garcia.ismael.storeroom.bdd.steps;

import cabanas.garcia.ismael.storeroom.module.product.Application;
import cabanas.garcia.ismael.storeroom.module.product.infrastructure.controller.request.ProductRequestDTO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.net.URI;

import static io.restassured.RestAssured.given;

@ContextConfiguration
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreateProductApiSteps {

    private Response response;
    private RequestSpecification request;

    @LocalServerPort
    protected int port;

    @Given("^I want to add to storeroom (\\d+) units of a new product with name (.*)")
    public void requestForAddProduct(int units, String name) throws Throwable {
        ProductRequestDTO requestDto = new ProductRequestDTO();
        requestDto.setName(name);
        requestDto.setQuantity(units);
        request = given().request()
                .contentType(ContentType.JSON)
                .body(requestDto, ObjectMapperType.JACKSON_2);
    }

    @When("^I post data to path (.*)$")
    public void post(String path) throws Throwable {
        response = request.when().post(URI.create("http://localhost:"
            + port
            + path));
    }

    @Then("^response status is (\\d+)$")
    public void responseStatusIs(int statusCode) throws Throwable {
        response.then().statusCode(statusCode);
    }
}
