package cabanas.garcia.ismael.despensa.core.domain.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ProductId {
    private final String id;

    private ProductId(Builder builder) {
        this.id = builder.uuid;
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

    public static Builder builder(String uuid) {
        return new Builder(uuid);
    }

    public String value() {
        return id;
    }

    public static class Builder {
        private final String uuid;

        public Builder(String uuid) {
            this.uuid = uuid;
        }

        public ProductId build() {
            return new ProductId(this);
        }
    }
}
