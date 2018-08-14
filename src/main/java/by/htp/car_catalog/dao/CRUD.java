package by.htp.car_catalog.dao;

import java.util.ArrayList;

public interface CRUD<T> {
    void create(T entity);

    T read(int id);

    ArrayList<T> readAll();

    void update(T entity);

    void delete(int id);
}
