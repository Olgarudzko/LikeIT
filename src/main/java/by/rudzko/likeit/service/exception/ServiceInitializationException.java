package by.rudzko.likeit.service.exception;

public class ServiceInitializationException extends Exception{

	private static final long serialVersionUID = -7160805310411600351L;

	public ServiceInitializationException() {
		super();
	}

	public ServiceInitializationException(String message, Exception exception) {
		super(message, exception);
	}

	public ServiceInitializationException(String message) {
		super(message);
	}

	public ServiceInitializationException(Exception exception) {
		super(exception);
	}
	
}
