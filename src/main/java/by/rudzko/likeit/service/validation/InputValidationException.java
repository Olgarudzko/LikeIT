package by.rudzko.likeit.service.validation;

public class InputValidationException extends Exception {

    private static final long serialVersionUID = 4279664404705532141L;

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
