package cabanas.garcia.ismael.despensa.core.domain.model;

import java.util.HashMap;
import java.util.Map;

public class Storeroom {

    private Map<ProductId, Product> products = new HashMap<>();

    private Storeroom() { }

    public static Builder builder() {
        return new Builder();
    }

    public void add(ProductId productId, ProductName productName, ProductQuantity quantity) {
        Product product = Product.builder(productId, productName, quantity).build();
        products.put(productId, product);
    }

    public Product add(ProductId productId, ProductQuantity quantity) {
        Product oldProduct = products.remove(productId);
        oldProduct.add(quantity);
        Product product = Product.builder(oldProduct.id(), oldProduct.name(), oldProduct.quantity()).build();
        products.put(product.id(), product);
        return product;
    }

    public ProductQuantity quantityOf(ProductId productId) {
        return products.get(productId).quantity();
    }

    public static class Builder {
        public Storeroom build() {
            return new Storeroom();
        }
    }
}
