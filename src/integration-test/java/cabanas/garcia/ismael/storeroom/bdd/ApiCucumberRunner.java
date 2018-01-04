package cabanas.garcia.ismael.storeroom.bdd;

import cabanas.garcia.ismael.storeroom.IntegrationTests;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "cabanas.garcia.ismael.storeroom.bdd.steps",
        features = "src/integration-test/resources/features/api")
@Category(IntegrationTests.class)
public class ApiCucumberRunner {
}
