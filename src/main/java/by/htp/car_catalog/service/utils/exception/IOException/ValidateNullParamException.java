package by.htp.car_catalog.service.utils.exception.IOException;

import java.io.IOException;

public class ValidateNullParamException extends IOException {

    private static final long serialVersionUID = -6927051771242956629L;

    public ValidateNullParamException() {
        super();
    }

    public ValidateNullParamException(String message, Throwable cause) {

        super(message, cause);

    }

    public ValidateNullParamException(String message) {

        super(message);

    }

    public ValidateNullParamException(Throwable cause) {

        super(cause);

    }

}