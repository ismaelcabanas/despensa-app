package cabanas.garcia.ismael.storeroom.module.product.domain.model.stubs;

import org.apache.commons.lang3.RandomStringUtils;

public final class StringStub {

    private StringStub() {
    }

    public static String random(int size) {
        return RandomStringUtils.random(size);
    }
}
