package cabanas.garcia.ismael.despensa.core.domain.model.stubs;

import org.apache.commons.lang3.RandomStringUtils;

public class StringStub {
    public static String random(int size) {
        return RandomStringUtils.random(size);
    }
}