package by.htp.car_catalog.web.controller;

import by.htp.car_catalog.web.actions.Action;
import by.htp.car_catalog.web.actions.impl.IndexAction;
import by.htp.car_catalog.web.actions.impl.LoginAction;
import by.htp.car_catalog.web.actions.impl.ProfileAction;
import by.htp.car_catalog.web.actions.impl.SignupAction;

import java.util.HashMap;
import java.util.Map;

class ActionManager {
    private final static Map<String, Action> ACTIONS;

    static {
        ACTIONS = new HashMap<>();
        ACTIONS.put("/index", new IndexAction());
        ACTIONS.put("/login", new LoginAction());
        ACTIONS.put("/signup", new SignupAction());
        ACTIONS.put("/profile", new ProfileAction());
    }

    static Action getAction(String action) {
        return ACTIONS.get(action);
    }
}
