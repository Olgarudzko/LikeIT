package by.rudzko.likeit.dao.implementation;

import by.rudzko.likeit.dao.ConnectionCreator;
import by.rudzko.likeit.dao.UserDAO;
import by.rudzko.likeit.dao.exception.DAOException;
import by.rudzko.likeit.domain.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static by.rudzko.likeit.dao.Constant.*;

public class UserDAOimpl implements UserDAO {

    public User findUser(User user) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement();
            ResultSet fullInfo = statement.executeQuery(String.format(Locale.ENGLISH, FIND_USER_REQUEST, user.getLogin(), user.getPassword()));
            if (fullInfo.next()) {
                user.setRole(fullInfo.getInt(FK_ROLE));
                user.setRating(fullInfo.getInt(RATING));
                ResultSet roleSet = statement.executeQuery(String.format(Locale.ENGLISH, DEFINE_ROLE_REQUEST, user.getRole()));
                if (roleSet.next()) {
                    user.setRoleValue(roleSet.getString(ROLE));
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            ConnectionCreator.closeConnection(connection);
        }
        return user;
    }

    public User addUser(User user) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement();
            int changed = statement.executeUpdate(String.format(Locale.ENGLISH,
                    ADD_USER_REQUEST, user.getLogin(), user.getPassword(), USER_ROLE));
            if (changed != 1) {
                return null;
            }
            user.setRating(NULL_RATING);
            user.setRole(USER_ROLE);
            user.setRoleValue(MEMBER);
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            ConnectionCreator.closeConnection(connection);
        }
        return user;
    }

    public List<User> showUsers() throws DAOException {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement();
            ResultSet usersSet = statement.executeQuery(String.format(Locale.ENGLISH, SHOW_USERS_REQUEST));
            while (usersSet.next()) {
                User user = new User();
                user.setLogin(usersSet.getString(LOGIN));
                user.setRating(usersSet.getInt(RATING));
                user.setRole(usersSet.getInt(FK_ROLE));
                users.add(user);
            }
            for (User member : users) {
                ResultSet roleSet = statement.executeQuery(String.format(Locale.ENGLISH, DEFINE_ROLE_REQUEST, member.getRole()));
                if (roleSet.next()) {
                    member.setRoleValue(roleSet.getString(ROLE));
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            ConnectionCreator.closeConnection(connection);
        }
        return users;
    }
}
