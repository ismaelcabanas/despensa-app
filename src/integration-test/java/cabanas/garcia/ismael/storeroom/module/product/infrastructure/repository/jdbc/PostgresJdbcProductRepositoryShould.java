package cabanas.garcia.ismael.storeroom.module.product.infrastructure.repository.jdbc;

import cabanas.garcia.ismael.storeroom.IntegrationTests;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.Product;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.ProductId;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.ProductName;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.ProductQuantity;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.stubs.ProductIdStub;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.stubs.ProductNameStub;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.stubs.ProductQuantityStub;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.stubs.ProductStub;
import com.codurance.lightaccess.LightAccess;
import com.codurance.lightaccess.executables.SQLCommand;
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

    private static final String DELETE_ALL_PRODUCTS = "delete from products";
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
        lightAccess.executeCommand(deleteAllProducts());
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

    @Test public void
    update_products() {
        Product productOne = ProductStub.random();
        productRepository.insert(productOne);
        Product productOneWithQuantityAdded = productOne.add(ProductQuantityStub.random());

        productRepository.update(productOneWithQuantityAdded);

        List<Product> products = lightAccess.executeQuery(retrieveAllProducts());
        assertThat(products).containsExactly(productOneWithQuantityAdded);
        assertThat(products.get(0).quantity()).isEqualTo(productOneWithQuantityAdded.quantity());
    }

    @Test public void
    next_identity() {

        ProductId productId = productRepository.nextIdentity();

        assertThat(productId).isNotNull();
    }

    private SQLCommand deleteAllProducts() {
        return conn -> conn.prepareStatement(DELETE_ALL_PRODUCTS)
                .executeUpdate();
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
