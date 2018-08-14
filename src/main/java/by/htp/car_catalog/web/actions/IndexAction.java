package by.htp.car_catalog.web.actions;

import by.htp.car_catalog.dao.impl.BrandCarDaoImpl;
import by.htp.car_catalog.web.controller.ModelAndView;

public class IndexAction implements Action {
    @Override
    public String execute(ModelAndView modelAndView) {
        modelAndView.setAttribute("brands", new BrandCarDaoImpl().readAll());
        return "index";
    }

}
