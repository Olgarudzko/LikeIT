package by.rudzko.likeit.dao;

import by.rudzko.likeit.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionCreator {// этот пакет не лучшее место для размещения данного класса
    private static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL_DB = "jdbc:mysql://localhost:3306/likeitdb";
    private static final String USER_DB = "root";
    private static final String PASSWORD_DB = "leta88";
    private static BlockingQueue<Connection> connectionPool = new ArrayBlockingQueue<>(10);

    public static Connection getConnection() throws DAOException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
            connectionPool.add(connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return connection;
    }

    public static void closeConnection(Connection connection) throws DAOException {
        if (connectionPool.contains(connection)) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }
    }

    private ConnectionCreator() {
    }

    public static void initialize() throws DAOException {
        try {
            Class.forName(COM_MYSQL_JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new DAOException(e);
        }
    }
}
