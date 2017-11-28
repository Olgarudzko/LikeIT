package by.rudzko.likeit.service;

import by.rudzko.likeit.domain.User;
import by.rudzko.likeit.service.exception.ServiceException;

import java.util.List;

public interface UserService {
    User findUser(User user) throws ServiceException;

    User addUser(User user) throws ServiceException;

    List<User> showUsers() throws ServiceException;
}
