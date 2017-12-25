package cabanas.garcia.ismael.despensa.core.domain.model;

public class ProductId {
    private final String id;

    private ProductId(Builder builder) {
        this.id = builder.uuid;
    }

    public static Builder builder(String uuid) {
        return new Builder(uuid);
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
