package md.stefanini.internship.taskmanager.command;

import md.stefanini.internship.taskmanager.service.UserService;

import java.sql.SQLException;
import java.util.regex.Matcher;

public class ShowAllUsersCommand extends BaseCommand {

    private final UserService userService;

    public ShowAllUsersCommand(String[] args, UserService userService) {
        super(args);
        this.userService = userService;
    }

    @Override
    protected String getArgumentsPattern() {
        return "^-showAllUsers$";
    }

    @Override
    protected void fireCommand(Matcher matcher) throws SQLException {
        userService.showAllUsers();
    }
}
