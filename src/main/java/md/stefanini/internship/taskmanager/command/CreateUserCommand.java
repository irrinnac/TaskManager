package md.stefanini.internship.taskmanager.command;

import md.stefanini.internship.taskmanager.service.UserService;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateUserCommand extends BaseCommand {

    private final UserService userService;

    public CreateUserCommand(String[] args, UserService userService) {
        super(args);
        this.userService = userService;
    }

    @Override
    protected String getArgumentsPattern() {
        return "^-createUser -fn='(?<firstName>\\w+)' -ln='(?<lastName>\\w+)' -un='(?<userName>\\w+)'$";
    }

    @Override
    public void execute() throws SQLException {
        Pattern pattern = Pattern.compile("^-createUser -fn='(?<firstName>\\w+)' -ln='(?<lastName>\\w+)' -un='(?<userName>\\w+)'$");
        Matcher matcher = pattern.matcher(arguments);

        if (matcher.matches()) {
            fireCommand(matcher);
        } else {
            throw new IllegalArgumentException("Incorrect command arguments pattern");
        }
    }

    @Override
    protected void fireCommand(Matcher matcher) throws SQLException {
        String firstName = matcher.group("firstName");
        String lastName = matcher.group("lastName");
        String userName = matcher.group("userName");

        userService.createUser(firstName, lastName, userName);
    }
}
