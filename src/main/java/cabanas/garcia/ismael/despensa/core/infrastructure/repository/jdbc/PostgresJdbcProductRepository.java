package cabanas.garcia.ismael.despensa.core.infrastructure.repository;

import cabanas.garcia.ismael.despensa.core.domain.model.Product;
import cabanas.garcia.ismael.despensa.core.domain.model.ProductId;
import cabanas.garcia.ismael.despensa.core.domain.repository.ProductRepository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

public class PostgresProductRepository implements ProductRepository {

    private static final String INSERT_PRODUCT_SQL = "insert into products (p_id, p_name, p_quantity) values (?, ?, ?)";

    private final DataSource dataSource;

    public PostgresProductRepository(DataSource dataSource) {
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
        return null;
    }

    @Override
    public void update(Product product) {

    }
}
