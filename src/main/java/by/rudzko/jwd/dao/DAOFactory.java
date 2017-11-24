package by.rudzko.jwd.dao;

import by.rudzko.jwd.dao.UserDAO;
import by.rudzko.jwd.dao.implementation.UserDAOimpl;

public final class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

    private final by.rudzko.jwd.dao.UserDAO userDao = new UserDAOimpl();

    private DAOFactory() {
    }

    public UserDAO getUserDAO() {
        return userDao;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}
