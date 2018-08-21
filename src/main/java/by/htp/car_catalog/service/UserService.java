package by.htp.car_catalog.service;

import by.htp.car_catalog.entity.User;
import by.htp.car_catalog.service.utils.exception.IOException.ValidateNullParamException;
import by.htp.car_catalog.service.utils.exception.IOException.ValidateNullStringException;
import by.htp.car_catalog.web.controller.ModelAndView;

import java.sql.SQLIntegrityConstraintViolationException;

public interface UserService {
    User addUser(ModelAndView modelAndView) throws ValidateNullStringException, SQLIntegrityConstraintViolationException;

    User loginUser(ModelAndView modelAndView) throws ValidateNullParamException;

    void updateUser(User user);
}
