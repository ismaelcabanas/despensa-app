package cabanas.garcia.ismael.despensa.core.infrastructure.repository.jdbc;

import cabanas.garcia.ismael.despensa.core.domain.model.Product;
import cabanas.garcia.ismael.despensa.core.domain.model.ProductId;
import cabanas.garcia.ismael.despensa.core.domain.model.ProductName;
import cabanas.garcia.ismael.despensa.core.domain.repository.ProductRepository;
import org.apache.commons.lang3.NotImplementedException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

public class PostgresJdbcProductRepository implements ProductRepository {

    private static final String INSERT_PRODUCT_SQL = "insert into products (p_id, p_name, p_quantity) values (?, ?, ?)";
    public static final String NOT_IMPLEMENTED_YET = "Not implemented yet";

    private final DataSource dataSource;

    public PostgresJdbcProductRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Product product) {
        try (Connection conn = dataSource.getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(INSERT_PRODUCT_SQL)) {
                preparedStatement.setObject(1, UUID.fromString(product.id().value()));
                preparedStatement.setString(2, product.name().value());
                preparedStatement.setInt(3, product.quantity().value());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new JdbcException(e);
            }
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }

    @Override
    public Optional<Product> findById(ProductId productId) {
        throw new NotImplementedException(NOT_IMPLEMENTED_YET);
    }

    @Override
    public void update(Product product) {
        throw new NotImplementedException(NOT_IMPLEMENTED_YET);
    }

    @Override
    public ProductId nextIdentity() {
        throw new NotImplementedException(NOT_IMPLEMENTED_YET);
    }

    @Override
    public Optional<Product> findByName(ProductName productName) {
        throw new NotImplementedException(NOT_IMPLEMENTED_YET);
    }
}
