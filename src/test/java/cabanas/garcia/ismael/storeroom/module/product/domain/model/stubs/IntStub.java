package cabanas.garcia.ismael.storeroom.module.product.domain.model.stubs;

import org.apache.commons.lang3.RandomUtils;

public final class IntStub {

    private IntStub() { }

    public static int random() {
        return RandomUtils.nextInt(1, 100);
    }
}
