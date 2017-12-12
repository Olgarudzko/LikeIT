package by.rudzko.likeit.dao;

import by.rudzko.likeit.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


// ты выдала пользователю соединение
// вопрос 1 - зачем ты помещаешь его после этого в пул
// вопрос 2 - возврат в пул не предусмотрен, так как нарушена логика самого пула соединений
// короче - бред получился
public class ConnectionCreator {// этот пакет не лучшее место для размещения данного класса
    private static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";// настройки БД следует читать из properties файла
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
            throw new DAOException(e);// это класс вызывается только в реализации ДАО, этот эксепшен не надо оборачивать
            // реализация дао для бд вполне понимает, что такое SQLException
        }
        return connection;
    }

    public static void closeConnection(Connection connection) throws DAOException {
        if (connectionPool.contains(connection)) {// если ты в пул помещаешь коннекшн, который уже так есть - то это ошибка кодирования
            // а ты вместо этого плодишь еще одну ошибку
            // это коннекшн, который уже в пуле - закрываешь
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DAOException(e);// аналогично вышесказанному
                // а вообще можно сразу в лог
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
