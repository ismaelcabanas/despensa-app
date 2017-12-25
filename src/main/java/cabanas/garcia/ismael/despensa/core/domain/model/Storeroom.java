package cabanas.garcia.ismael.despensa.core.domain.model;

import java.util.HashMap;
import java.util.Map;

public class Storeroom {

    private Map<ProductId, Product> products = new HashMap<>();

    private Storeroom(Builder builder){}

    public static Builder builder() {
        return new Builder();
    }

    public void add(ProductId productId, ProductName productName, ProductQuantity quantity) {
        Product product = Product.builder(productName, quantity).build();
        products.put(productId, product);
    }

    public ProductQuantity quantityOf(ProductId productId) {
        return products.get(productId).quantity();
    }

    public static class Builder {
        public Storeroom build() {
            return new Storeroom(this);
        }
    }
}
