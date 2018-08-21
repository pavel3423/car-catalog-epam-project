package by.htp.car_catalog.dao;

import by.htp.car_catalog.entity.User;

public interface UserDao extends CRUD<User> {
    User findByLogin(String login);
}
