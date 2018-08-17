package by.htp.car_catalog.dao.impl;

import by.htp.car_catalog.dao.connectionPool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

abstract class AcstractDao {

    void delete(ConnectionPool connectionPool, String sql, int id) {
        Connection connection = connectionPool.getConnection();
        try (
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            //TODO logger
            e.printStackTrace();
        } finally {
            connectionPool.putConnection(connection);
        }
    }
}
