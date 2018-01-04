package cabanas.garcia.ismael.storeroom;

import cabanas.garcia.ismael.storeroom.module.product.Application;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Category(IntegrationTests.class)
public class ApplicationShould {

    @Test public void
    context_load() {

    }
}
