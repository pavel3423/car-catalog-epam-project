package by.htp.car_catalog.web.controller;

import by.htp.car_catalog.web.actions.Action;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        ModelAndView modelAndView = new ModelAndView(req, resp);
        Action action = ActionFactory.getAction(req);
        String command = action.execute(modelAndView);
        modelAndView.navigate(command);
    }
}
