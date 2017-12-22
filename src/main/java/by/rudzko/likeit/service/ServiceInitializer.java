package by.rudzko.likeit.service;

import by.rudzko.likeit.dao.DataInitializer;
import by.rudzko.likeit.dao.exception.DataInitializationException;
import by.rudzko.likeit.service.exception.ServiceInitializationException;

public class ServiceInitializer {

	public static void initialize() throws ServiceInitializationException{
		try {
			DataInitializer.initialize();
		} catch (DataInitializationException e) {
			throw new ServiceInitializationException("Service initialization failed", e);
		}
	}
	
	private ServiceInitializer() {}
}
