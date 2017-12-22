package by.rudzko.likeit.service.validation;

public class Validator {// имя более конкретное

    private static final String LOGIN_REGEX = "[A-Za-z]{3,50}";
    private static final String PASSWORD_REGEX = "[-\\.A-Za-z0-9_]{4,50}";

    private Validator() {
    }

    public static void isInputValid(String login, String password) throws InputValidationException {
        if (!login.matches(LOGIN_REGEX)) {
            throw new InputValidationException("Wrong login format.");
        }
        if (!password.matches(PASSWORD_REGEX)) {
            throw new InputValidationException("Wrong password format.");
        }
    }
}
