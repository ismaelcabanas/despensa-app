package cabanas.garcia.ismael.storeroom.module.product.infrastructure.controller;

import cabanas.garcia.ismael.storeroom.module.product.infrastructure.controller.request.ProductRequestDTO;
import cabanas.garcia.ismael.storeroom.module.product.infrastructure.controller.request.stub.ProductRequestDTOStub;
import org.junit.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateProductControllerShould {

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
        assertThat(response.getHeaders().get(HttpHeaders.LOCATION).get(0)).containsPattern(Pattern.compile("/products/"));
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
