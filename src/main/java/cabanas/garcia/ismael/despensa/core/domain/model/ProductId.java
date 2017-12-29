package cabanas.garcia.ismael.despensa.core.domain.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.UUID;

public class ProductId {
    private final String id;

    private ProductId(Builder builder) {
        this.id = builder.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProductId productId = (ProductId) o;

        return new EqualsBuilder()
                .append(id, productId.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }


    public String value() {
        return id;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(String id) {
        return new Builder(id);
    }

    public static class Builder {

        private final String id;

        public Builder(String id) {
            this.id = id;
        }

        public Builder() {
            this.id = UUID.randomUUID().toString();
        }

        public ProductId build() {
            return new ProductId(this);
        }
    }
}
