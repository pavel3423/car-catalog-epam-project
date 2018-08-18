package by.htp.car_catalog.web.actions.impl;

import by.htp.car_catalog.web.actions.AbstractAction;
import by.htp.car_catalog.web.controller.ModelAndView;

public class LoginAction extends AbstractAction {

    @Override
    public String methodGet(ModelAndView modelAndView) {
        return "user/login";
    }


}
