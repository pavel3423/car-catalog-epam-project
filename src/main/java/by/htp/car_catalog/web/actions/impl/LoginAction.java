package by.htp.car_catalog.web.actions.impl;

import by.htp.car_catalog.service.UserService;
import by.htp.car_catalog.service.impl.UserServiceImpl;
import by.htp.car_catalog.service.utils.exception.IOException.ValidateNullParamException;
import by.htp.car_catalog.web.actions.AbstractAction;
import by.htp.car_catalog.web.actions.utils.WebConstants;
import by.htp.car_catalog.web.controller.ModelAndView;

public class LoginAction extends AbstractAction {
    private static final String MSG_NO_USER = "Can not login. Please check the correctness of the entered data";

    UserService userService = new UserServiceImpl();

    @Override
    public String methodGet(ModelAndView modelAndView) {
        return "user/login";
    }

    @Override
    public String methodPost(ModelAndView modelAndView) {
        try {
            userService.loginUser(modelAndView);
            return WebConstants.REDIRECT_TO + "profile";
        } catch (ValidateNullParamException e) {
            modelAndView.setAttribute("msg", "MSG_NO_USER");
            return "user/login";
        }
    }
}
