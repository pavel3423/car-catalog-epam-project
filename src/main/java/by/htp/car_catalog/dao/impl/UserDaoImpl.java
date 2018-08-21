package by.htp.car_catalog.dao.impl;

import by.htp.car_catalog.dao.UserDao;
import by.htp.car_catalog.dao.connectionPool.ConnectionPool;
import by.htp.car_catalog.dao.connectionPool.ConnectionPoolImpl;
import by.htp.car_catalog.entity.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDaoImpl extends AbstractDao implements UserDao {
    private final static String CREATE_USER_SQL_QUERY =
            "INSERT INTO users (`id`, `login`, `email`, `password`, `salt`, `roleID`) VALUES (?, ?, ?, ?, ?, ?)";
    private final static String READ_USER_BY_ID_SQL_QUERY =
            "SELECT * FROM users WHERE id = ?";
    private final static String READ_ALL_USER_SQL_QUERY =
            "SELECT * FROM users";
    private final static String UPDATE_USER_SQL_QUERY =
            "UPDATE users SET `id`=?, `login`=?, `email`=?, `password`=?, `salt`=?, `roleID`=? WHERE id=?";
    private final static String DELETE_USER_SQL_QUERY =
            "DELETE FROM users WHERE id = ?";
    private final static String READ_USER_BY_LOGIN_SQL_QUERY =
            "SELECT * FROM users WHERE login = ?";
    private final ConnectionPool connectionPool = new ConnectionPoolImpl();

    @Override
    public void create(User user) throws SQLIntegrityConstraintViolationException {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement statement =
                     connection.prepareStatement(CREATE_USER_SQL_QUERY, Statement.RETURN_GENERATED_KEYS)
        ) {
            setUserInStatement(statement, user);
            int count = statement.executeUpdate();
            if (count == 1) {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    user.setId(resultSet.getInt(1));
                }
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new SQLIntegrityConstraintViolationException();
        } catch (SQLException e) {
            //TODO logger
            e.printStackTrace();
        } finally {
            connectionPool.putConnection(connection);
        }
    }

    @Override
    public User read(int id) {
        Connection connection = connectionPool.getConnection();
        try (
                PreparedStatement statement = connection.prepareStatement(READ_USER_BY_ID_SQL_QUERY)
        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return getUser(resultSet);
            }
        } catch (SQLException e) {
            //TODO logger
            e.printStackTrace();
        } finally {
            connectionPool.putConnection(connection);
        }
        return null;
    }

    @Override
    public ArrayList<User> readAll() {
        ArrayList<User> cars = new ArrayList<>();
        Connection connection = connectionPool.getConnection();
        try (
                PreparedStatement statement = connection.prepareStatement(READ_ALL_USER_SQL_QUERY)
        ) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                cars.add(getUser(resultSet));
            }
        } catch (SQLException e) {
            //TODO logger
            e.printStackTrace();
        } finally {
            connectionPool.putConnection(connection);
        }
        return cars;
    }

    @Override
    public void update(User user) {
        Connection connection = connectionPool.getConnection();
        try (
                PreparedStatement statement = connection.prepareStatement(UPDATE_USER_SQL_QUERY)
        ) {
            setUserInStatement(statement, user);
            statement.setInt(7, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            //TODO logger
            e.printStackTrace();
        } finally {
            connectionPool.putConnection(connection);
        }
    }

    @Override
    public void delete(int id) {
        super.delete(connectionPool, DELETE_USER_SQL_QUERY, id);
    }

    @Override
    public User findByLogin(String login) {
        Connection connection = connectionPool.getConnection();
        try (
                PreparedStatement statement = connection.prepareStatement(READ_USER_BY_LOGIN_SQL_QUERY)
        ) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return getUser(resultSet);
            }
        } catch (SQLException e) {
            //TODO logger
            e.printStackTrace();
        } finally {
            connectionPool.putConnection(connection);
        }
        return null;
    }

    private void setUserInStatement(PreparedStatement statement, User user) throws SQLException {
        statement.setInt(1, user.getId());
        statement.setString(2, user.getLogin());
        statement.setString(3, user.getEmail());
        statement.setString(4, user.getPassword());
        statement.setString(5, user.getSalt());
        statement.setInt(6, user.getRoleID());
    }

    private User getUser(ResultSet resultSet) throws SQLException {
        return User.newBuilder().
                setId(resultSet.getInt("id")).
                setLogin(resultSet.getString("login")).
                setEmail(resultSet.getString("email")).
                setPassword(resultSet.getString("password")).
                setSalt(resultSet.getString("salt")).
                setRoleID(resultSet.getInt("id")).build();
    }
}
