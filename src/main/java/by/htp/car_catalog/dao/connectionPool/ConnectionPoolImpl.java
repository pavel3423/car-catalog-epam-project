package by.htp.car_catalog.dao.connectionPool;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPoolImpl implements ConnectionPool {
    private static final int CONNECTION_NUMBER = 40;
    private static final String URL;
    private static final String USER;
    private static final String PASSWORD;
    private static final BlockingQueue<Connection> connections = new LinkedBlockingQueue<>(CONNECTION_NUMBER);

    static {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("db_config");
        URL = resourceBundle.getString("jdbc.URL");
        USER = resourceBundle.getString("jdbc.USER");
        PASSWORD = resourceBundle.getString("jdbc.PASSWORD");
        try {
            DriverManager.registerDriver(new Driver());

            for (int i = 0; i < CONNECTION_NUMBER; i++) {
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                connections.add(connection);
            }
        } catch (SQLException e) {
            //TODO add logger
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = connections.take();
        } catch (InterruptedException e) {
            //TODO add logger
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void putConnection(Connection connection) {
        try {
            if (connection.isClosed()) {
                connections.put(createConnection());
            } else {
                connections.put(connection);
            }
        } catch (InterruptedException | SQLException e) {
            //TODO add logger
            e.printStackTrace();
        }
    }

    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            //TODO add logger
            e.printStackTrace();
        }
        return connection;
    }
}
