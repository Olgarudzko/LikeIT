package by.rudzko.jwd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {
private static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL_DB = "jdbc:mysql://localhost:3306/likeitdb";
	private static final String USER_DB = "root";
    private static final String PASSWORD_DB = "leta88";
    private static volatile Connection connection = null;

    static {
        try {
            Class.forName(COM_MYSQL_JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed())
            connection = DriverManager.getConnection(
                    URL_DB, USER_DB, PASSWORD_DB
            );
        return connection;
    }
}
