package cabanas.garcia.ismael.storeroom.bdd;

import cabanas.garcia.ismael.storeroom.module.product.Application;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractFeatureTest {

    @LocalServerPort
    protected int port;
}
