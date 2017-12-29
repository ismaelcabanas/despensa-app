package cabanas.garcia.ismael.despensa.module.product.domain.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Product {

    private final ProductId productId;
    private ProductQuantity productQuantity;
    private final ProductName productName;

    private Product(Builder builder) {
        this.productId = builder.productId;
        this.productName = builder.productName;
        this.productQuantity = builder.productQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

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

    public static Builder builder(ProductId productId, ProductName productName, ProductQuantity quantity) {
        return new Builder(productId, productName, quantity);
    }

    public ProductQuantity quantity() {
        return productQuantity;
    }

    public void add(ProductQuantity quantity) {
        this.productQuantity = this.productQuantity.sum(quantity);
    }

    public ProductId id() {
        return this.productId;
    }

    public ProductName name() {
        return this.productName;
    }

    public static class Builder {
        private final ProductName productName;
        private final ProductQuantity productQuantity;
        private final ProductId productId;

        public Builder(ProductId productId, ProductName productName, ProductQuantity quantity) {
            this.productId = productId;
            this.productName = productName;
            this.productQuantity = quantity;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
