package by.htp.car_catalog.web.actions.impl;

import by.htp.car_catalog.service.UserService;
import by.htp.car_catalog.service.impl.UserServiceImpl;
import by.htp.car_catalog.service.utils.exception.IOException.ValidateNullParamException;
import by.htp.car_catalog.web.actions.AbstractAction;
import by.htp.car_catalog.web.actions.utils.WebConstants;
import by.htp.car_catalog.web.controller.ModelAndView;

import java.sql.SQLIntegrityConstraintViolationException;

public class SignupAction extends AbstractAction {
    private static final String MSG_NO_REGISTRATION_USER = "Can not register. Please check the correctness of the entered data";
    private static final String MSG_USER_DUBLICATE = "A user with this name or e-mail is already registered";

    UserService userService = new UserServiceImpl();

    @Override
    public String methodGet(ModelAndView modelAndView) {
        return "user/signup";
    }

    @Override
    public String methodPost(ModelAndView modelAndView) {
        try {
            userService.addUser(modelAndView);
            return WebConstants.REDIRECT_TO + "profile";
        } catch (ValidateNullParamException e) {
            modelAndView.setAttribute("msg", MSG_NO_REGISTRATION_USER);
        } catch (SQLIntegrityConstraintViolationException e) {
            modelAndView.setAttribute("msg", MSG_USER_DUBLICATE);
        }
        return "user/signup";
    }
}
