package cabanas.garcia.ismael.despensa.core.domain.model;

public class Product {

    private ProductName productName;

    private Product(Builder builder) {
        this.productName = ProductName.builder(builder.productName).build();
    }

    public static Builder builder(String productName) {
        return new Builder(productName);
    }

    public static class Builder {
        private final String productName;

        public Builder(String productName) {
            this.productName = productName;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
