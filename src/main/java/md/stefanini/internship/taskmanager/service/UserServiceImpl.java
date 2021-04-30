package md.stefanini.internship.taskmanager.service;

import md.stefanini.internship.taskmanager.database.dao.AbstractDAO;
import md.stefanini.internship.taskmanager.database.models.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final AbstractDAO<User> dao;

    public UserServiceImpl(AbstractDAO<User> userDAO) {
        this.dao = userDAO;
    }

    @Override
    public void createUser(String firstName, String lastName, String userName) throws SQLException {
        User user = new User();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserName(userName);

        dao.insert(user);
    }

    @Override
    public void showAllUsers() throws SQLException {
        List<User> userList = dao.getAll();

        System.out.println("List of all users:");
        System.out.println(userList);
    }
}
