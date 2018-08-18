package by.htp.car_catalog.web.actions;

import by.htp.car_catalog.web.controller.ModelAndView;

public abstract class AbstractAction implements Action {
    @Override
    public String methodOptions(ModelAndView modelAndView) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String methodGet(ModelAndView modelAndView) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String methodHead(ModelAndView modelAndView) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String methodPost(ModelAndView modelAndView) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String methodPut(ModelAndView modelAndView) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String methodPatch(ModelAndView modelAndView) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String methodDelete(ModelAndView modelAndView) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String methodTrace(ModelAndView modelAndView) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String methodConnect(ModelAndView modelAndView) {
        throw new UnsupportedOperationException();
    }
}
