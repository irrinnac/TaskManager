package md.stefanini.internship.taskmanager.database.dao;

import md.stefanini.internship.taskmanager.database.models.Task;
import md.stefanini.internship.taskmanager.database.models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory implements AbstractDAOFactory {

    private static final String DB_URL = "jdbc:sqlite:src/main/resources/database/sqllite/taskmanager.db";

    private final Connection dbConnection;

    // Singleton
    private static DAOFactory instance;

    public static DAOFactory getInstance() throws SQLException {
        if (instance == null) {
            instance = new DAOFactory();
        }

        return instance;
    }

    @Override
    public AbstractDAO<User> getUserDAO() throws SQLException {
        return new UserDAO(dbConnection);
    }

    @Override
    public AbstractDAO<Task> getTaskDAO() throws SQLException {
        return new TaskDAO(dbConnection);
    }

    private DAOFactory() throws SQLException {
        dbConnection = DriverManager.getConnection(DB_URL);
    }
}
