package by.htp.car_catalog.service.impl;

import by.htp.car_catalog.dao.UserDao;
import by.htp.car_catalog.dao.impl.UserDaoImpl;
import by.htp.car_catalog.entity.User;
import by.htp.car_catalog.service.UserService;
import by.htp.car_catalog.service.utils.HttpRequestParamValidator;
import by.htp.car_catalog.service.utils.exception.IOException.ValidateNullObjectException;
import by.htp.car_catalog.service.utils.exception.IOException.ValidateNullParamException;
import by.htp.car_catalog.service.utils.exception.IOException.ValidateNullStringException;
import by.htp.car_catalog.service.utils.sequrity.AES;
import by.htp.car_catalog.service.utils.sequrity.Hash;
import by.htp.car_catalog.service.utils.sequrity.Salt;
import by.htp.car_catalog.web.controller.ModelAndView;

import java.sql.SQLIntegrityConstraintViolationException;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public User addUser(ModelAndView modelAndView) throws ValidateNullStringException, SQLIntegrityConstraintViolationException {
        String login = modelAndView.getParameter("login");
        String email = modelAndView.getParameter("email");
        String password = modelAndView.getParameter("password");

        HttpRequestParamValidator.validateStringNotNull(login, email, password);
        String salt = Salt.getSalt();
        String hash = Hash.getHash(password, salt);
        User user = User.newBuilder().setId(0).setLogin(login).setEmail(email).
                setPassword(AES.encrypt(hash)).setSalt(salt).setRoleID(2).build();
        userDao.create(user);
        modelAndView.getSession().setAttribute("user", user);
        return user;
    }

    @Override
    public User loginUser(ModelAndView modelAndView) throws ValidateNullParamException {
        String login = modelAndView.getParameter("login");
        String password = modelAndView.getParameter("password");
        HttpRequestParamValidator.validateStringNotNull(login, password);
        User user = userDao.findByLogin(login);
        HttpRequestParamValidator.validateObjectNotNull(user);

        String aes = AES.decrypt(user.getPassword());
        String hash = Hash.getHash(password, user.getSalt());
        if (hash.equals(aes)) {
            modelAndView.getSession().setAttribute("user", user);
            return user;
        } else {
            throw new ValidateNullObjectException();
        }
    }

    @Override
    public void updateUser(User user) {

    }
}
