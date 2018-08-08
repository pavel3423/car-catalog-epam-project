package by.htp.car_catalog.web.controller;

import by.htp.car_catalog.web.actions.Action;

import javax.servlet.http.HttpServletRequest;

class ActionFactory {
    static Action getAction(HttpServletRequest req) {
        String command = req.getRequestURI();
        command = command.replaceFirst(".html", "");
        return ActionManager.getAction(command);
    }
}
