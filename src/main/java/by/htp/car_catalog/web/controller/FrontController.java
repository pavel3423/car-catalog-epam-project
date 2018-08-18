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
        String command = executeCommand(action, modelAndView);
        modelAndView.navigate(command);
    }

    private String executeCommand(Action action, ModelAndView modelAndView) {
        String command;
        String method = modelAndView.getRequest().getMethod();

        switch (method) {
            case "OPTIONS":
                command = action.methodOptions(modelAndView);
                break;
            case "GET":
                command = action.methodGet(modelAndView);
                break;
            case "HEAD":
                command = action.methodHead(modelAndView);
                break;
            case "POST":
                command = action.methodPost(modelAndView);
                break;
            case "PUT":
                command = action.methodPut(modelAndView);
                break;
            case "PATCH":
                command = action.methodPatch(modelAndView);
                break;
            case "DELETE":
                command = action.methodDelete(modelAndView);
                break;
            case "TRACE":
                command = action.methodTrace(modelAndView);
                break;
            case "CONNECT":
                command = action.methodConnect(modelAndView);
                break;
            default:
                throw new UnsupportedOperationException();
        }
        return command;
    }
}
