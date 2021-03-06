package by.rudzko.likeit.service;

import by.rudzko.likeit.domain.User;
import by.rudzko.likeit.service.exception.ServiceException;
import by.rudzko.likeit.service.validation.InputValidationException;

import java.util.List;

public interface UserService {
		User findUser(User user) throws  InputValidationException, ServiceException;
		User addUser(User user) throws  InputValidationException, ServiceException;
		List<User> showUsers() throws InputValidationException, ServiceException;
}
