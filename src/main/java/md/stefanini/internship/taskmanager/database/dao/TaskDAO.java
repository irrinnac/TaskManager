package md.stefanini.internship.taskmanager.database.dao;

import md.stefanini.internship.taskmanager.database.models.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskDAO extends BaseDAO<Task> {

    public TaskDAO(Connection dbConnection) throws SQLException {
        super(dbConnection);
    }

    @Override
    protected PreparedStatement getSelectAllStatement() throws SQLException {
        return dbConnection.prepareStatement("SELECT userName, title, description FROM task;");
    }

    @Override
    protected PreparedStatement getInsertStatement(Task task) throws SQLException {
        PreparedStatement insertStatement = dbConnection.prepareStatement("INSERT INTO task (userName, title, description) VALUES (?, ?, ?)");

        insertStatement.setString(1, task.getUserName());
        insertStatement.setString(2, task.getTitle());
        insertStatement.setString(3, task.getDescription());

        return insertStatement;
    }

    @Override
    protected Task populateModel(ResultSet resultSet) throws SQLException {
        Task task = new Task();

        task.setUserName(resultSet.getString("userName"));
        task.setTitle(resultSet.getString("title"));
        task.setDescription(resultSet.getString("description"));

        return task;
    }
}
