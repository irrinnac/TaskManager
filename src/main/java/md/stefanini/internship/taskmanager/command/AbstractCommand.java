package md.stefanini.internship.taskmanager.command;

import java.sql.SQLException;

public interface AbstractCommand {
    public static final int i = 0;

    void execute() throws SQLException;
}
