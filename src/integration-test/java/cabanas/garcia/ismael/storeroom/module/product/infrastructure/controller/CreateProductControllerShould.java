package cabanas.garcia.ismael.storeroom.module.product.infrastructure.controller;

import cabanas.garcia.ismael.storeroom.IntegrationTests;
import cabanas.garcia.ismael.storeroom.module.product.Application;
import cabanas.garcia.ismael.storeroom.module.product.infrastructure.controller.request.ProductRequestDTO;
import cabanas.garcia.ismael.storeroom.module.product.infrastructure.controller.request.stub.ProductRequestDTOStub;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Category(IntegrationTests.class)
public class CreateProductControllerShould {

    private static Pattern createProductUriPattern =
            Pattern.compile("^(http)://localhost:[0-9]+/api/v1/products/"
                    + "[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[34][0-9a-fA-F]{3}-[89ab][0-9a-fA-F]{3}-[0-9a-fA-F]{12}");

    @LocalServerPort
    private int port;

    @Test public void
    post_product() {
        ProductRequestDTO productRequest = ProductRequestDTOStub.random();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<ProductRequestDTO> httpEntity = new HttpEntity<>(productRequest, headers);
        TestRestTemplate restTemplate = new TestRestTemplate();

        ResponseEntity<Void> response = restTemplate.exchange(
                createURLWithPort("/api/v1/products"),
                HttpMethod.POST, httpEntity, Void.class);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getHeaders().get(HttpHeaders.LOCATION).get(0)).containsPattern(createProductUriPattern);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
