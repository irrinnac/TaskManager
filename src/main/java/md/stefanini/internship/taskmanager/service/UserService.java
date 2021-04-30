package md.stefanini.internship.taskmanager.service;

import java.sql.SQLException;

public interface UserService {
    void createUser(String firstName, String lastName, String userName) throws SQLException;

    void showAllUsers() throws SQLException;
}
