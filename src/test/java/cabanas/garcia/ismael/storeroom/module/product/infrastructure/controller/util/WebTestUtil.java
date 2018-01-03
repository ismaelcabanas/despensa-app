package cabanas.garcia.ismael.storeroom.module.product.infrastructure.controller.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class WebTestUtil {

    private WebTestUtil() {
    }

    public static byte[] convertObjectToJsonBytes(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsBytes(object);
    }
}
