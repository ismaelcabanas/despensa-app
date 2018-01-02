package cabanas.garcia.ismael.storeroom.module.product.infrastructure.controller;

import cabanas.garcia.ismael.storeroom.module.product.application.AddNewProductToStoreroom;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.ProductId;
import cabanas.garcia.ismael.storeroom.module.product.infrastructure.controller.request.ProductRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/products")
public class CreateProductController {
    private final AddNewProductToStoreroom addNewProductToStoreroom;

    public CreateProductController(AddNewProductToStoreroom addNewProductToStoreroom) {
        this.addNewProductToStoreroom = addNewProductToStoreroom;
    }

    @PostMapping
    public ResponseEntity<Void> create(ProductRequestDTO productRequestDTO) {
        ProductId productId = addNewProductToStoreroom.add(productRequestDTO.getName(), productRequestDTO.getQuantity());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(productId.value()).toUri();
        return ResponseEntity.created(location).build();
    }
}
