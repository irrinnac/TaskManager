package md.stefanini.internship.taskmanager.database.dao;

import md.stefanini.internship.taskmanager.database.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends BaseDAO<User> {

    public UserDAO(Connection dbConnection) {
        super(dbConnection);
    }

    @Override
    protected PreparedStatement getSelectAllStatement() throws SQLException {
        return dbConnection.prepareStatement("SELECT firstName, lastName, userName FROM user;");
    }

    @Override
    protected PreparedStatement getInsertStatement(User user) throws SQLException {
        PreparedStatement insertStatement = dbConnection.prepareStatement("INSERT INTO user (firstName, lastName, userName) VALUES (?, ?, ?)");

        insertStatement.setString(1, user.getFirstName());
        insertStatement.setString(2, user.getLastName());
        insertStatement.setString(3, user.getUserName());

        return insertStatement;
    }

    @Override
    protected User populateModel(ResultSet resultSet) throws SQLException {
        User user = new User();

        user.setUserName(resultSet.getString("userName"));
        user.setFirstName(resultSet.getString("firstName"));
        user.setLastName(resultSet.getString("lastName"));

        return user;
    }
}
