package by.htp.car_catalog.dao.connectionPool;

import java.sql.Connection;

public interface ConnectionPool {
    Connection getConnection();

    void putConnection(Connection connection);
}
