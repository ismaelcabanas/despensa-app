package cabanas.garcia.ismael.despensa.module.product.domain.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class ProductQuantityShould {

    @Test public void
    be_equals() {
        ProductQuantity productQuantity = ProductQuantity.builder(3).build();
        ProductQuantity anotherProductQuantity = ProductQuantity.builder(3).build();

        boolean actual = productQuantity.equals(anotherProductQuantity);

        assertThat(actual).isTrue();
    }

    @Test public void
    not_be_equals() {
        ProductQuantity productQuantity = ProductQuantity.builder(3).build();
        ProductQuantity anotherProductQuantity = ProductQuantity.builder(4).build();

        boolean actual = productQuantity.equals(anotherProductQuantity);

        assertThat(actual).isFalse();
    }
}
