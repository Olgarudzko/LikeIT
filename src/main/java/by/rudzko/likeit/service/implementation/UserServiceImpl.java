package by.rudzko.likeit.service.implementation;

import by.rudzko.likeit.dao.DAOFactory;
import by.rudzko.likeit.dao.UserDAO;
import by.rudzko.likeit.dao.exception.DAOException;
import by.rudzko.likeit.domain.User;
import by.rudzko.likeit.service.UserService;
import by.rudzko.likeit.service.exception.ServiceException;
import by.rudzko.likeit.service.validation.InputValidationException;
import by.rudzko.likeit.service.validation.Validator;

import java.util.List;

public class UserServiceImpl implements UserService{
    private UserDAO userDAO = DAOFactory.getInstance().getUserDAO();

    public User findUser(User user) throws InputValidationException, ServiceException {
        try {
            Validator.isInputValid(user.getLogin(), user.getPassword());// знаешь, is в метод предполагает использовае if-a
            // а то не очень читаемый код получается
            return userDAO.findUser(user);
        } catch (DAOException e) {
            throw new ServiceException("Search wasn't completed", e);
        }
    }

    public User addUser(User user) throws InputValidationException, ServiceException {
        try {
            Validator.isInputValid(user.getLogin(), user.getPassword());
            return userDAO.addUser(user);
        } catch (DAOException e) {
            throw new ServiceException("User wasn't added", e);
        }
    }

    public List<User> showUsers() throws InputValidationException, ServiceException {
        try {
            return userDAO.showUsers();
        } catch (DAOException e) {
            throw new ServiceException("", e);
        }
    }

}
