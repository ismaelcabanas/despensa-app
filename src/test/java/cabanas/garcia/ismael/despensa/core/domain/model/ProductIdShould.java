package cabanas.garcia.ismael.despensa.core.domain.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class ProductIdShould {

    @Test public void
    be_equals() {
        ProductId productId = ProductId.builder("uuid1").build();
        ProductId otherProductId = ProductId.builder("uuid1").build();

        boolean actual = productId.equals(otherProductId);

        assertThat(actual).isTrue();
    }

    @Test public void
    not_be_equals() {
        ProductId productId = ProductId.builder("uuid3").build();
        ProductId otherProductId = ProductId.builder("uuid2").build();

        boolean actual = productId.equals(otherProductId);

        assertThat(actual).isFalse();
    }

}
