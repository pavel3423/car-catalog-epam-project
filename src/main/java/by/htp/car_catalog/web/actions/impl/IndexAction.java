package by.htp.car_catalog.web.actions.impl;

import by.htp.car_catalog.dao.impl.BrandCarDaoImpl;
import by.htp.car_catalog.web.actions.AbstractAction;
import by.htp.car_catalog.web.controller.ModelAndView;

public class IndexAction extends AbstractAction {

    @Override
    public String methodGet(ModelAndView modelAndView) {
        modelAndView.setAttribute("brands", new BrandCarDaoImpl().readAll());
        return "index";
    }
}
