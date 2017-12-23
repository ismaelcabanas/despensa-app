package cabanas.garcia.ismael.despensa.core.domain.model;

public class ProductName {
    private String value;

    private ProductName(Builder builder) {
        this.value = builder.value;
    }

    public static Builder builder(String value) {
        return new Builder(value);
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
