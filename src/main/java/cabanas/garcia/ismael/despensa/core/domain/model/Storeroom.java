package cabanas.garcia.ismael.despensa.core.domain.model;

public class Storeroom {

    private Storeroom(Builder builder){}

    public static Builder builder() {
        return new Builder();
    }

    public void add(Product product, int quantity) {

    }

    public int size() {
        return 0;
    }

    public int count(Product product) {
        return 0;
    }

    public static class Builder {
        public Storeroom build() {
            return new Storeroom(this);
        }
    }
}
