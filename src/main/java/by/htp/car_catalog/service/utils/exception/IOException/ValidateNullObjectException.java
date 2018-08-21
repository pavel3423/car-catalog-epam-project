package by.htp.car_catalog.service.utils.exception.IOException;

public class ValidateNullObjectException extends ValidateNullParamException {

    private static final long serialVersionUID = 2108784613761539122L;

    public ValidateNullObjectException() {
    }

    public ValidateNullObjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidateNullObjectException(String message) {
        super(message);
    }

    public ValidateNullObjectException(Throwable cause) {
        super(cause);
    }

}
