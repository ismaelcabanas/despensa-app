package cabanas.garcia.ismael.storeroom.module.product.domain;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/domain"
)
public class RunCukeTest {
}
