package by.rudzko.likeit.dao;

import by.rudzko.likeit.dao.exception.DAOException;
import by.rudzko.likeit.domain.User;

import java.util.List;

public interface UserDAO {

    User findUser(User user) throws DAOException;

    User addUser(User user) throws DAOException;

    List<User> showUsers() throws DAOException;
}
