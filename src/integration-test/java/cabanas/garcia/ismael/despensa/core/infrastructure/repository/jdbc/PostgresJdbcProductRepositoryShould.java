package cabanas.garcia.ismael.despensa.core.infrastructure.repository.jdbc;

import cabanas.garcia.ismael.despensa.IntegrationTests;
import cabanas.garcia.ismael.despensa.core.domain.model.Product;
import cabanas.garcia.ismael.despensa.core.domain.model.ProductId;
import cabanas.garcia.ismael.despensa.core.domain.model.ProductName;
import cabanas.garcia.ismael.despensa.core.domain.model.ProductQuantity;
import cabanas.garcia.ismael.despensa.core.domain.model.stubs.ProductIdStub;
import cabanas.garcia.ismael.despensa.core.domain.model.stubs.ProductNameStub;
import cabanas.garcia.ismael.despensa.core.domain.model.stubs.ProductQuantityStub;
import cabanas.garcia.ismael.despensa.core.domain.model.stubs.ProductStub;
import com.codurance.lightaccess.LightAccess;
import com.codurance.lightaccess.executables.SQLQuery;
import com.codurance.lightaccess.mapping.LAResultSet;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

import javax.sql.DataSource;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Category(IntegrationTests.class)
public class PostgresJdbcProductRepositoryShould {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private static final String SELECT_ALL_PRODUCTS_SQL = "select * from products";

    private static HikariConfig config = new HikariConfig();
    private static DataSource dataSource;
    private LightAccess lightAccess;
    private PostgresJdbcProductRepository productRepository;

    @BeforeClass public static void
    before_all_tests() {
        config.setJdbcUrl("jdbc:postgresql://" + System.getProperty("postgres.host")
                + ":"
                + System.getProperty("postgres.port") + "/postgres?currentSchema=storeroom");
        config.setUsername("postgres");
        config.setPassword("postgres");
        dataSource = new HikariDataSource(config);

        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.migrate();
    }

    @Before public void
    before_each_test() {
        lightAccess = new LightAccess(dataSource);
        productRepository = new PostgresJdbcProductRepository(dataSource);
    }

    @Test public void
    insert_products() {
        Product productOne = ProductStub.random();
        Product productTwo = ProductStub.random();

        productRepository.insert(productOne);
        productRepository.insert(productTwo);

        List<Product> products = lightAccess.executeQuery(retrieveAllProducts());
        assertThat(products).containsExactlyInAnyOrder(productOne, productTwo);
    }

    @Test public void
    insert_products_fail_when_product_name_exceed_100() {
        Product productOne = Product.builder(ProductIdStub.random(),
                ProductNameStub.random(150),
                ProductQuantityStub.random())
                .build();
        thrown.expect(JdbcException.class);
        productRepository.insert(productOne);
    }

    private SQLQuery<List<Product>> retrieveAllProducts() {
        return conn -> conn.prepareStatement(SELECT_ALL_PRODUCTS_SQL)
                .executeQuery()
                .mapResults(this::toProduct);
    }

    private Product toProduct(LAResultSet laResultSet) {
        return Product.builder(ProductId.builder(laResultSet.getString(1)).build(),
                ProductName.builder(laResultSet.getString(2)).build(),
                ProductQuantity.builder(laResultSet.getInt(3)).build()).build();
    }

}
