package by.htp.car_catalog.web.actions.impl;

import by.htp.car_catalog.web.actions.AbstractAction;
import by.htp.car_catalog.web.actions.utils.WebConstants;
import by.htp.car_catalog.web.controller.ModelAndView;

public class LogoutAction extends AbstractAction {
    @Override
    public String methodGet(ModelAndView modelAndView) {
        modelAndView.getSession().invalidate();
        return WebConstants.REDIRECT_TO + "index";
    }
}
