package md.stefanini.internship.taskmanager.command;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class BaseCommand implements AbstractCommand {
    private static final String SPACE = " ";

    protected String arguments;

    public BaseCommand(String[] args) {
        this.arguments = String.join(SPACE, args).trim();
    }

    @Override
    public void execute() throws SQLException {
        Pattern pattern = Pattern.compile(getArgumentsPattern());
        Matcher matcher = pattern.matcher(arguments);

        if (matcher.matches()) {
            fireCommand(matcher);
        } else {
            throw new IllegalArgumentException("Incorrect command arguments pattern");
        }
    }

    protected abstract String getArgumentsPattern();

    protected abstract void fireCommand(Matcher matcher) throws SQLException;
}
