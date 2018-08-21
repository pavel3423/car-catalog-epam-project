package by.htp.car_catalog.service.utils.exception.IOException;

import java.io.IOException;

public class UnknownCommandException extends IOException {

    private static final long serialVersionUID = 8379949874021998229L;

    public UnknownCommandException() {
        super();
    }

    public UnknownCommandException(String message, Throwable cause) {

        super(message, cause);

    }

    public UnknownCommandException(String message) {

        super(message);

    }

    public UnknownCommandException(Throwable cause) {

        super(cause);

    }

}