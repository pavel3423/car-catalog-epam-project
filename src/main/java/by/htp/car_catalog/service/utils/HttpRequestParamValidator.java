package by.htp.car_catalog.service.utils;

import by.htp.car_catalog.service.utils.exception.IOException.ValidateNullObjectException;
import by.htp.car_catalog.service.utils.exception.IOException.ValidateNullStringException;

public final class HttpRequestParamValidator {
    private HttpRequestParamValidator() {
    }

    public static void validateObjectNotNull(Object... objects) throws ValidateNullObjectException {
        for (Object o : objects) {

            if (o == null) {

                throw new ValidateNullObjectException();
            }

        }
    }

    public static void validateStringNotNull(String... str) throws ValidateNullStringException {
        for (String s : str) {

            if ("".equals(s) || s == null) {

                throw new ValidateNullStringException();
            }

        }
    }
}
