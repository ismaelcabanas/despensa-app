package cabanas.garcia.ismael.despensa.module.product.infrastructure.repository.jdbc;

import java.sql.SQLException;

public class JdbcException extends RuntimeException {
    public JdbcException(SQLException e) {
        super(e);
    }
}
