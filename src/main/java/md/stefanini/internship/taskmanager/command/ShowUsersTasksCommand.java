package md.stefanini.internship.taskmanager.command;

import md.stefanini.internship.taskmanager.service.TaskService;

import java.sql.SQLException;
import java.util.regex.Matcher;

public class ShowUsersTasksCommand extends BaseCommand {

    private final TaskService taskService;

    public ShowUsersTasksCommand(String[] args, TaskService taskService) {
        super(args);
        this.taskService = taskService;
    }

    @Override
    protected String getArgumentsPattern() {
        return "^-showTasks -un='(?<userName>\\w+)'$";
    }

    @Override
    protected void fireCommand(Matcher matcher) throws SQLException {
        String userName = matcher.group("userName");
        taskService.showUserTasks(userName);
    }
}
