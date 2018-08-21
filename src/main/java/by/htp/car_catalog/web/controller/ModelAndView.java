package by.htp.car_catalog.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ModelAndView {
    private static final String ROOT_PACKAGE_PATH = "/WEB-INF/pages/jsp/";

    private HttpServletRequest req;
    private HttpServletResponse resp;

    ModelAndView(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;
    }

    public HttpServletRequest getRequest() {
        return req;
    }

    public HttpServletResponse getResponse() {
        return resp;
    }

    public void setAttribute(String s, Object o) {
        req.setAttribute(s, o);
    }

    public Object getAttribute(String s) {
        return req.getAttribute(s);
    }

    public String getParameter(String s) {
        return req.getParameter(s);
    }

    public HttpSession getSession() {
        return req.getSession();
    }

    void navigate(String command) {
        try {
            if (!command.contains("redirect:")) {
                String path = ROOT_PACKAGE_PATH + command + ".jsp";
                req.getRequestDispatcher(path).forward(req, resp);
            } else {
                command = command.replaceFirst("redirect:", "");
                command = command + ".html";
                resp.sendRedirect(command);
            }
        } catch (ServletException | IOException e) {
            //TODO logger
            e.printStackTrace();
        }
    }
}
