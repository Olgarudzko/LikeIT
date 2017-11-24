package by.rudzko.jwd.service.validation;

public class InputValidationException extends Exception{

    public InputValidationException() {
        super();
    }

    public InputValidationException(String message, Exception exception) {
        super(message, exception);
    }

    public InputValidationException(String message) {
        super(message);
    }

    public InputValidationException(Exception exception) {
        super(exception);
    }
}
