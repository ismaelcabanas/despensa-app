package cabanas.garcia.ismael.storeroom.module.product.domain.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class ProductIdShould {

    public static final String UUID1 = "uuid1";

    @Test public void
    be_reflexive() {
        ProductId productId = ProductId.builder(UUID1).build();

        assertThat(productId).isEqualTo(productId);
    }

    @Test public void
    be_symetric() {
        ProductId productId = ProductId.builder(UUID1).build();
        ProductId otherProductId = ProductId.builder(UUID1).build();

        assertThat(productId).isEqualTo(otherProductId);
        assertThat(otherProductId).isEqualTo(productId);
    }

    @Test public void
    be_transitive() {
        ProductId oneProductId = ProductId.builder(UUID1).build();
        ProductId secondProductId = ProductId.builder(UUID1).build();
        ProductId thirdProductId = ProductId.builder(UUID1).build();

        assertThat(oneProductId).isEqualTo(secondProductId);
        assertThat(secondProductId).isEqualTo(thirdProductId);
        assertThat(oneProductId).isEqualTo(thirdProductId);
    }

    @Test public void
    not_equal_when_compare_with_null() {
        ProductId oneProductId = ProductId.builder(UUID1).build();
        ProductId secondProductId = null;

        assertThat(oneProductId.equals(secondProductId)).isFalse();
    }

    @Test public void
    not_be_equals() {
        ProductId productId = ProductId.builder().build();
        ProductId otherProductId = ProductId.builder().build();

        boolean actual = productId.equals(otherProductId);

        assertThat(actual).isFalse();
    }

    @Test public void
    hashCode_consistency() {
        ProductId oneProductId = ProductId.builder(UUID1).build();

        assertThat(oneProductId.hashCode()).isEqualTo(oneProductId.hashCode());
    }

    @Test public void
    hashCode_be_equals() {
        ProductId oneProductId = ProductId.builder(UUID1).build();
        ProductId secondProductId = ProductId.builder(UUID1).build();

        assertThat(oneProductId.hashCode()).isEqualTo(secondProductId.hashCode());
    }

}
