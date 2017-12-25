package cabanas.garcia.ismael.despensa.core.domain.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Product {

    private final ProductQuantity productQuantity;
    private final ProductName productName;

    private Product(Builder builder) {
        this.productName = builder.productName;
        this.productQuantity = builder.productQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return new EqualsBuilder()
                .append(productName, product.productName)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(productName)
                .toHashCode();
    }

        public static Builder builder(ProductName productName, ProductQuantity quantity) {
        return new Builder(productName, quantity);
    }

    public ProductQuantity quantity() {
        return productQuantity;
    }

    public static class Builder {
        private final ProductName productName;
        private final ProductQuantity productQuantity;

        public Builder(ProductName productName, ProductQuantity quantity) {
            this.productName = productName;
            this.productQuantity = quantity;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
