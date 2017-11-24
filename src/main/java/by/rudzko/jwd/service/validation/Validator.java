package by.rudzko.jwd.service.validation;

public class Validator {

    private static final String WRONG_LOGIN = "Wrong login format.";
    private static final String WRONG_PASSWORD = "Wrong password format.";

    private Validator() {
    }

    public static void isInputValid(String login, String password) throws InputValidationException {
        if (!login.matches("[A-Za-z]{3,50}")) {
            throw new InputValidationException(WRONG_LOGIN);
        }
        if (!password.matches("[-\\.A-Za-z0-9_]{4,50}")) {
            throw new InputValidationException(WRONG_PASSWORD);
        }
    }
}
