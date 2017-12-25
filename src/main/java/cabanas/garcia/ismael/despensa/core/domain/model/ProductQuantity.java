package cabanas.garcia.ismael.despensa.core.domain.model;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ProductQuantity {
    private int value;

    private ProductQuantity(Builder builder) {
        this.value = builder.quantity;
    }

    public int value() {
        return value;
    }

    public static Builder builder(int quantity) {
        return new Builder(quantity);
    }

    public ProductQuantity sum(ProductQuantity quantity) {
        throw new NotImplementedException("Not implemented yet");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ProductQuantity that = (ProductQuantity) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(value, that.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(value)
                .toHashCode();
    }

    public static class Builder {
        private final int quantity;

        public Builder(int quantity) {
            this.quantity = quantity;
        }

        public ProductQuantity build() {
            return new ProductQuantity(this);
        }
    }
}
