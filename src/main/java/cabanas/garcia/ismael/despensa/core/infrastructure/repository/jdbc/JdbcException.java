package cabanas.garcia.ismael.despensa.core.infrastructure.repository.jdbc;

import java.sql.SQLException;

public class JdbcException extends RuntimeException {
    public JdbcException(SQLException e) {
        super(e);
    }
}
