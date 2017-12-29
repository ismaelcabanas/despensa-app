package cabanas.garcia.ismael.despensa.module.product.domain.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductNameShould {

    @Test public void
    be_equals() {
        ProductName productName = ProductName.builder("Milk").build();
        ProductName anotherProductName = ProductName.builder("Milk").build();

        boolean actual = productName.equals(anotherProductName);

        assertThat(actual).isTrue();
    }

    @Test public void
    not_be_equals() {
        ProductName productName = ProductName.builder("Mejillones").build();
        ProductName anotherProductName = ProductName.builder("Eggs").build();

        boolean actual = productName.equals(anotherProductName);

        assertThat(actual).isFalse();
    }

}
