package by.rudzko.jwd.dao.implementation;

import by.rudzko.jwd.dao.ConnectionCreator;
import by.rudzko.jwd.dao.UserDAO;
import by.rudzko.jwd.dao.exception.DAOException;
import by.rudzko.jwd.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static by.rudzko.jwd.dao.Constants.*;

public class UserDAOimpl implements UserDAO{

	public User findUser(User user) throws DAOException {
		try {
			Statement statement = ConnectionCreator.getConnection().createStatement();
			ResultSet fullInfo = statement.executeQuery(String.format(FIND_USER_REQUEST, user.getLogin(), user.getPassword()));
			if (fullInfo.next()) {
			user.setRole(fullInfo.getInt(FK_ROLE));
			user.setRating(fullInfo.getInt(RATING));
				ResultSet roleSet = statement.executeQuery(String.format(Locale.ENGLISH, DEFINE_ROLE_REQUEST, user.getRole()));
				if(roleSet.next()){
					user.setRoleValue(roleSet.getString(ROLE));
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return user;
	}

	public User addUser(User user) throws DAOException {
		try {
			Statement statement = ConnectionCreator.getConnection().createStatement();
			int changed = statement.executeUpdate(String.format(Locale.ENGLISH,
					ADD_USER_REQUEST, user.getLogin(), user.getPassword(), USER_ROLE));
			if (changed!=1) {
				return null;
			}
			user.setRating(NULL_RATING);
			user.setRole(USER_ROLE);
			user.setRoleValue(MEMBER);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return user;
	}

	public List<User> showUsers () throws DAOException{
		List<User> users = new ArrayList<>();
		Statement statement = null;
		try {
			statement = ConnectionCreator.getConnection().createStatement();
			ResultSet usersSet = statement.executeQuery(String.format(Locale.ENGLISH, SHOW_USERS_REQUEST));
			while(usersSet.next()){
				User user = new User();
				user.setLogin(usersSet.getString(LOGIN));
				user.setRating(usersSet.getInt(RATING));
				user.setRole(usersSet.getInt(FK_ROLE));
				users.add(user);
			}
			for (User member: users){
				ResultSet roleSet = statement.executeQuery(String.format(Locale.ENGLISH, DEFINE_ROLE_REQUEST, member.getRole()));
				if(roleSet.next()){
					member.setRoleValue(roleSet.getString(ROLE));
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				if (statement!=null) { statement.close(); }
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
		return users;
	}
}
