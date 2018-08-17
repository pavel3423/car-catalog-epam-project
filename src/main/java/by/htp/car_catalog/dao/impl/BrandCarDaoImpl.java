package by.htp.car_catalog.dao.impl;

import by.htp.car_catalog.dao.BrandCarDao;
import by.htp.car_catalog.dao.connectionPool.ConnectionPool;
import by.htp.car_catalog.dao.connectionPool.ConnectionPoolImpl;
import by.htp.car_catalog.entity.BrandCar;

import java.sql.*;
import java.util.ArrayList;

public class BrandCarDaoImpl extends AbstractDao implements BrandCarDao {
    private final ConnectionPool connectionPool = new ConnectionPoolImpl();
    private final static String CREATE_BRAND_SQL_QUERY = "INSERT INTO brands_car (`id`, `brand`) VALUES (?, ?)";
    private final static String READ_BRAND_SQL_QUERY = "SELECT * FROM brands_car WHERE id = ?";
    private final static String READ_ALL_BRAND_SQL_QUERY = "SELECT * FROM brands_car";
    private final static String UPDATE_BRAND_SQL_QUERY = "UPDATE brands_car SET `id`=?, `brand`=? WHERE id=?";
    private final static String DELETE_BRAND_SQL_QUERY = "DELETE FROM brands_car WHERE id = ?";

    @Override
    public void create(BrandCar brand) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement statement =
                     connection.prepareStatement(CREATE_BRAND_SQL_QUERY, Statement.RETURN_GENERATED_KEYS)
        ) {
            setBrandInStatement(statement, brand);
            int count = statement.executeUpdate();
            if (count == 1) {
                try (ResultSet resultSet = statement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        brand.setId(resultSet.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            //TODO logger
            e.printStackTrace();
        } finally {
            connectionPool.putConnection(connection);
        }
    }

    @Override
    public BrandCar read(int id) {
        Connection connection = connectionPool.getConnection();
        try (
                PreparedStatement statement = connection.prepareStatement(READ_BRAND_SQL_QUERY)
        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return getBrand(resultSet);
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
    public ArrayList<BrandCar> readAll() {
        ArrayList<BrandCar> brands = new ArrayList<>();
        Connection connection = connectionPool.getConnection();
        try (
                PreparedStatement statement = connection.prepareStatement(READ_ALL_BRAND_SQL_QUERY)
        ) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                brands.add(getBrand(resultSet));
            }
        } catch (SQLException e) {
            //TODO logger
            e.printStackTrace();
        } finally {
            connectionPool.putConnection(connection);
        }
        return brands;
    }

    @Override
    public void update(BrandCar brand) {
        Connection connection = connectionPool.getConnection();
        try (
                PreparedStatement statement = connection.prepareStatement(UPDATE_BRAND_SQL_QUERY)
        ) {
            setBrandInStatement(statement, brand);
            statement.setInt(3, brand.getId());
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
        super.delete(connectionPool, DELETE_BRAND_SQL_QUERY, id);
    }

    private void setBrandInStatement(PreparedStatement statement, BrandCar brand) throws SQLException {
        statement.setInt(1, brand.getId());
        statement.setString(2, brand.getBrand());
    }

    private BrandCar getBrand(ResultSet resultSet) throws SQLException {
        return BrandCar.newBuilder().
                setId(resultSet.getInt("id")).
                setBrand(resultSet.getString("brand")).build();
    }
}
