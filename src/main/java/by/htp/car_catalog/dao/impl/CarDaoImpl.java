package by.htp.car_catalog.dao.impl;

import by.htp.car_catalog.dao.CarDao;
import by.htp.car_catalog.dao.connectionPool.ConnectionPool;
import by.htp.car_catalog.dao.connectionPool.ConnectionPoolImpl;
import by.htp.car_catalog.entity.Car;

import java.sql.*;
import java.util.ArrayList;

public class CarDaoImpl extends AbstractDao implements CarDao {
    private final ConnectionPool connectionPool = new ConnectionPoolImpl();
    private final static String CREATE_CAR_SQL_QUERY = "INSERT INTO cars (`id`, `modelID`, `year`, `bodyType`, `length`, `width`, `height`, `base`, `numberOfDoors`, `clearance`, `trunk`, `volumeOfTheTank`, `numberOfPlaces`, `price`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final static String READ_CAR_SQL_QUERY = "SELECT * FROM cars WHERE id = ?";
    private final static String READ_ALL_CAR_SQL_QUERY = "SELECT * FROM cars";
    private final static String UPDATE_CAR_SQL_QUERY = "UPDATE cars SET `id`=?, `modelID`=?, `year`=?, `bodyType`=?, `length`=?, `width`=?, `height`=?, `base`=?, `numberOfDoors`=?, `clearance`=?, `trunk`=?, `volumeOfTheTank`=?, `numberOfPlaces`=?, `price`=? WHERE id=?";
    private final static String DELETE_CAR_SQL_QUERY = "DELETE FROM cars WHERE id = ?";

    @Override
    public void create(Car car) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement statement =
                     connection.prepareStatement(CREATE_CAR_SQL_QUERY, Statement.RETURN_GENERATED_KEYS)
        ) {
            setCarInStatement(statement, car);
            int count = statement.executeUpdate();
            if (count == 1) {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    car.setId(resultSet.getInt(1));
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
    public Car read(int id) {
        Connection connection = connectionPool.getConnection();
        try (
                PreparedStatement statement = connection.prepareStatement(READ_CAR_SQL_QUERY)
        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return getCar(resultSet);
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
    public ArrayList<Car> readAll() {
        ArrayList<Car> cars = new ArrayList<>();
        Connection connection = connectionPool.getConnection();
        try (
                PreparedStatement statement = connection.prepareStatement(READ_ALL_CAR_SQL_QUERY)
        ) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                cars.add(getCar(resultSet));
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
    public void update(Car car) {
        Connection connection = connectionPool.getConnection();
        try (
                PreparedStatement statement = connection.prepareStatement(UPDATE_CAR_SQL_QUERY)
        ) {
            setCarInStatement(statement, car);
            statement.setInt(15, car.getId());
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
        super.delete(connectionPool, DELETE_CAR_SQL_QUERY, id);
    }

    private void setCarInStatement(PreparedStatement statement, Car car) throws SQLException {
        statement.setInt(1, car.getId());
        statement.setInt(2, car.getModelID());
        statement.setInt(3, car.getYear());
        statement.setString(4, car.getBodyType());
        statement.setInt(5, car.getLength());
        statement.setInt(6, car.getWidth());
        statement.setInt(7, car.getHeight());
        statement.setInt(8, car.getBase());
        statement.setInt(9, car.getNumberOfDoors());
        statement.setInt(10, car.getClearance());
        statement.setInt(11, car.getTrunk());
        statement.setInt(12, car.getVolumeOfTheTank());
        statement.setInt(13, car.getNumberOfPlaces());
        statement.setInt(14, car.getPrice());
    }

    private Car getCar(ResultSet resultSet) throws SQLException {
        return Car.newBuilder().
                setId(resultSet.getInt("id")).
                setModelID(resultSet.getInt("modelID")).
                setYear(resultSet.getInt("year")).
                setBodyType(resultSet.getString("bodyType")).
                setLength(resultSet.getInt("length")).
                setWidth(resultSet.getInt("width")).
                setHeight(resultSet.getInt("height")).
                setBase(resultSet.getInt("base")).
                setNumberOfDoors(resultSet.getInt("numberOfDoors")).
                setClearance(resultSet.getInt("clearance")).
                setTrunk(resultSet.getInt("trunk")).
                setVolumeOfTheTank(resultSet.getInt("volumeOfTheTank")).
                setNumberOfPlaces(resultSet.getInt("numberOfPlaces")).
                setPrice(resultSet.getInt("price")).build();
    }
}
