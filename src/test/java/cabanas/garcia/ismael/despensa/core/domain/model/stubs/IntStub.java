package cabanas.garcia.ismael.despensa.core.domain.model.stubs;

import org.apache.commons.lang3.RandomUtils;

public class IntStub {
    public static int random() {
        return RandomUtils.nextInt(1,100);
    }
}
