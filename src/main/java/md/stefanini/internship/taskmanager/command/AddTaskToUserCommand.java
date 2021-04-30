package md.stefanini.internship.taskmanager.command;

import md.stefanini.internship.taskmanager.service.TaskService;

import java.sql.SQLException;
import java.util.regex.Matcher;

public class AddTaskToUserCommand extends BaseCommand {

    private final TaskService taskService;

    public AddTaskToUserCommand(String[] args, TaskService taskService) {
        super(args);
        this.taskService = taskService;
    }

    @Override
    protected String getArgumentsPattern() {
        return "^-addTask -un='(?<userName>\\w+)' -tt='(?<taskTitle>[\\w\\s]+)' -td='(?<taskDescription>[\\w\\s]+)'$";
    }

    @Override
    protected void fireCommand(Matcher matcher) throws SQLException {

        String userName = matcher.group(1);
        String title = matcher.group(2);
        String description = matcher.group(3);

        taskService.assignTaskToUser(userName, title, description);
    }
}
