package by.htp.car_catalog.web.controller;

import by.htp.car_catalog.web.actions.Action;
import by.htp.car_catalog.web.actions.IndexAction;

import java.util.HashMap;
import java.util.Map;

class ActionManager {
    private final static Map<String, Action> ACTIONS;

    static {
        ACTIONS = new HashMap<>();
        ACTIONS.put("/index", new IndexAction());
    }

    static Action getAction(String action) {
        return ACTIONS.get(action);
    }
}
