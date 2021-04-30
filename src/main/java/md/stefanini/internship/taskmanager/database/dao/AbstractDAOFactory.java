package md.stefanini.internship.taskmanager.database.dao;

import md.stefanini.internship.taskmanager.database.models.Task;
import md.stefanini.internship.taskmanager.database.models.User;

import java.sql.SQLException;

public interface AbstractDAOFactory {
    AbstractDAO<User> getUserDAO() throws SQLException;

    AbstractDAO<Task> getTaskDAO() throws SQLException;
}
