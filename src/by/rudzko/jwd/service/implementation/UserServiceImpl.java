package by.rudzko.jwd.service.implementation;

import by.rudzko.jwd.dao.DAOFactory;
import by.rudzko.jwd.dao.UserDAO;
import by.rudzko.jwd.dao.exception.DAOException;
import by.rudzko.jwd.domain.entity.User;
import by.rudzko.jwd.service.UserService;
import by.rudzko.jwd.service.exception.ServiceException;

import java.util.List;

public class UserServiceImpl implements UserService{
	UserDAO userDAO = DAOFactory.getInstance().getUserDAO();

	public User findUser(User user) throws ServiceException {
        try {
			return userDAO.findUser(user);
		} catch (DAOException e) {
			throw new ServiceException (e)	;
		}
     }

	public User addUser(User user) throws ServiceException {
		try {
			return userDAO.addUser(user);
		} catch (DAOException e) {
			throw new ServiceException (e)	;
		}
	}

	public List<User> showUsers() throws ServiceException{
		try {
			return userDAO.showUsers();
		} catch (DAOException e) {
			throw new ServiceException (e)	;
		}
	}

}
