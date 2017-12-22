package by.rudzko.likeit.dao.exception;

public class DataInitializationException extends Exception{

	private static final long serialVersionUID = -6507364423666995536L;

	public DataInitializationException() {
		super();
	}

	public DataInitializationException(String message, Exception exception) {
		super(message, exception);
	}

	public DataInitializationException(String message) {
		super(message);
	}

	public DataInitializationException(Exception exception) {
		super(exception);
	}

}
