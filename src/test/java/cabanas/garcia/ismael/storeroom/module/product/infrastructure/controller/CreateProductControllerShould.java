package cabanas.garcia.ismael.storeroom.module.product.infrastructure.controller;

import cabanas.garcia.ismael.storeroom.module.product.application.AddNewProductToStoreroom;
import cabanas.garcia.ismael.storeroom.module.product.application.stubs.AddNewProductToStoreroomStub;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.stubs.ProductIdStub;
import cabanas.garcia.ismael.storeroom.module.product.infrastructure.controller.request.ProductRequestDTO;
import cabanas.garcia.ismael.storeroom.module.product.infrastructure.controller.request.stub.ProductRequestDTOStub;
import cabanas.garcia.ismael.storeroom.module.product.infrastructure.controller.util.WebTestUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.regex.Pattern;

import static cabanas.garcia.ismael.storeroom.module.product.infrastructure.controller.util.WebTestConfig.objectMapperHttpMessageConverter;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public final class CreateProductControllerShould {

    private MockMvc mockMvc;

    private AddNewProductToStoreroom addNewProductToStoreroom;

    private static Pattern createProductUriPattern =
            Pattern.compile("^(http)://localhost/api/v1/products/*[-a-zA-Z0-9+&@#/%=~_|]");

    private CreateProductController controller;

    @Before public void
    setUp() {
        addNewProductToStoreroom = AddNewProductToStoreroomStub.builder()
                .whenProductIsAdded(ProductIdStub.random())
                .build();
        controller = new CreateProductController(addNewProductToStoreroom);
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setMessageConverters(objectMapperHttpMessageConverter())
                .build();
    }

    @Test public void
    response_with_201_status_code() throws Exception {
        ProductRequestDTO validProductRequest = ProductRequestDTOStub.random();

        mockMvc.perform(post("/api/v1/products")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(WebTestUtil.convertObjectToJsonBytes(validProductRequest))
        ).andExpect(status().isCreated());
    }

    @Test public void
    response_with_header_location_indicating_the_location_of_product_created() throws Exception {
        ProductRequestDTO validProductRequest = ProductRequestDTOStub.random();

        MvcResult response = mockMvc.perform(post("/api/v1/products")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(WebTestUtil.convertObjectToJsonBytes(validProductRequest))
        ).andReturn();

        assertThat(response.getResponse().getHeader(HttpHeaders.LOCATION)).containsPattern(createProductUriPattern);
    }
}
