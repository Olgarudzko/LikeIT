package by.rudzko.jwd.dao;

import by.rudzko.jwd.dao.exception.DAOException;
import by.rudzko.jwd.domain.entity.User;

import java.util.List;

public interface UserDAO {

	User findUser(User user) throws DAOException;
	User addUser(User user) throws DAOException;
	List <User> showUsers() throws DAOException;
}
