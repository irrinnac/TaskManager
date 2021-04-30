package md.stefanini.internship.taskmanager.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO<T> implements AbstractDAO<T> {

    protected Connection dbConnection;

    public BaseDAO(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<T> getAll() throws SQLException {
        List<T> modelList = new ArrayList<>();

        ResultSet resultSet = getSelectAllStatement().executeQuery();

        while (resultSet.next()) {
            T model = populateModel(resultSet);
            modelList.add(model);
        }


        return modelList;
    }

    @Override
    public int insert(T model) throws SQLException {
        return getInsertStatement(model).executeUpdate();
    }

    @Override
    public void closeDbConnection() throws SQLException {
        dbConnection.close();
    }

    protected abstract PreparedStatement getSelectAllStatement() throws SQLException;

    protected abstract PreparedStatement getInsertStatement(T model) throws SQLException;

    protected abstract T populateModel(ResultSet resultSet) throws SQLException;
}
