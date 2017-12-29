package cabanas.garcia.ismael.despensa.module.product.domain.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ProductName {
    private String value;

    private ProductName(Builder builder) {
        this.value = builder.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProductName that = (ProductName) o;

        return new EqualsBuilder()
                .append(value, that.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(value)
                .toHashCode();
    }

    public static Builder builder(String value) {
        return new Builder(value);
    }

    public String value() {
        return value;
    }

    public static class Builder {
        private final String value;

        public Builder(String value) {
            this.value = value;
        }

        public ProductName build() {
            return new ProductName(this);
        }
    }
}
