package cabanas.garcia.ismael.storeroom.module.product.infrastructure.repository.jdbc;

import cabanas.garcia.ismael.storeroom.module.product.domain.model.Product;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.ProductId;
import cabanas.garcia.ismael.storeroom.module.product.domain.model.ProductName;
import cabanas.garcia.ismael.storeroom.module.product.domain.repository.ProductRepository;
import org.apache.commons.lang3.NotImplementedException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

public class PostgresJdbcProductRepository implements ProductRepository {

    private static final String INSERT_PRODUCT_SQL = "insert into products (p_id, p_name, p_quantity) values (?, ?, ?)";
    private static final String NOT_IMPLEMENTED_YET = "Not implemented yet";
    private static final String UPDATE_PRODUCT_SQL = "update products set p_name = ?, p_quantity = ? where p_id = ?";

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
        try (Connection conn = dataSource.getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_PRODUCT_SQL)) {
                preparedStatement.setString(1, product.name().value());
                preparedStatement.setInt(2, product.quantity().value());
                preparedStatement.setObject(3, UUID.fromString(product.id().value()));
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new JdbcException(e);
            }
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
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
