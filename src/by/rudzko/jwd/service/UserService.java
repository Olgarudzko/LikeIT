package by.rudzko.jwd.service;

import by.rudzko.jwd.domain.entity.User;
import by.rudzko.jwd.service.exception.ServiceException;

import java.util.List;

public interface UserService {
		User findUser(User user) throws ServiceException;
		User addUser(User user) throws ServiceException;
		List<User> showUsers() throws ServiceException;
}
