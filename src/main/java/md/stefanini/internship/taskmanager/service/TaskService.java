package md.stefanini.internship.taskmanager.service;

import java.sql.SQLException;

public interface TaskService {
    void assignTaskToUser(String userName, String title, String description) throws SQLException;

    void showUserTasks(String userName) throws SQLException;
}
