package by.htp.car_catalog.service.utils.exception.IOException;

public class ValidateNullStringException extends ValidateNullParamException {

    private static final long serialVersionUID = 3753073296936215301L;

    public ValidateNullStringException() {
    }

    public ValidateNullStringException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidateNullStringException(String message) {
        super(message);
    }

    public ValidateNullStringException(Throwable cause) {
        super(cause);
    }

}
