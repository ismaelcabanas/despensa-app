package cabanas.garcia.ismael.storeroom.module.product.infrastructure.controller.request;

public class ProductRequestDTO {
    private String name;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
