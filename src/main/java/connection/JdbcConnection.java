package connection;

import java.sql.Connection;

public interface JdbcConnection {
    Connection getConnection();
}
