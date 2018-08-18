package by.htp.car_catalog.web.actions;

import by.htp.car_catalog.web.controller.ModelAndView;

public interface Action {

    String methodOptions(ModelAndView modelAndView);

    String methodGet(ModelAndView modelAndView);

    String methodHead(ModelAndView modelAndView);

    String methodPost(ModelAndView modelAndView);

    String methodPut(ModelAndView modelAndView);

    String methodPatch(ModelAndView modelAndView);

    String methodDelete(ModelAndView modelAndView);

    String methodTrace(ModelAndView modelAndView);

    String methodConnect(ModelAndView modelAndView);
}
