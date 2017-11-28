package by.rudzko.likeit.dao;

import by.rudzko.likeit.dao.implementation.UserDAOimpl;

public final class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO userDao = new UserDAOimpl();

    private DAOFactory() {
    }

    public UserDAO getUserDAO() {
        return userDao;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}
