package md.stefanini.internship.taskmanager.database.dao;

import java.sql.SQLException;
import java.util.List;

public interface AbstractDAO<T> {

    List<T> getAll() throws SQLException;

    int insert(T model) throws SQLException;

    void closeDbConnection() throws SQLException;
}
