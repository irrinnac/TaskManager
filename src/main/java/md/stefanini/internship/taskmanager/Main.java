package md.stefanini.internship.taskmanager;

import md.stefanini.internship.taskmanager.database.dao.AbstractDAO;
import md.stefanini.internship.taskmanager.database.dao.DAOFactory;
import md.stefanini.internship.taskmanager.database.models.Task;
import md.stefanini.internship.taskmanager.database.models.User;
import md.stefanini.internship.taskmanager.command.*;
import md.stefanini.internship.taskmanager.service.TaskService;
import md.stefanini.internship.taskmanager.service.TaskServiceImpl;
import md.stefanini.internship.taskmanager.service.UserService;
import md.stefanini.internship.taskmanager.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();

            AbstractDAO<User> userDAO = daoFactory.getUserDAO();
            UserService userService = new UserServiceImpl(userDAO);

            AbstractDAO<Task> taskDAO = daoFactory.getTaskDAO();
            TaskService taskService = new TaskServiceImpl(taskDAO);

            AbstractCommand taskManagerCommand;

            switch (args[0]) {
                case "-createUser":
                    taskManagerCommand = new CreateUserCommand(args, userService);
                    break;
                case "-showAllUsers":
                    taskManagerCommand = new ShowAllUsersCommand(args, userService);
                    break;
                case "-addTask":
                    taskManagerCommand = new AddTaskToUserCommand(args, taskService);
                    break;
                case "-showTasks":
                    taskManagerCommand = new ShowUsersTasksCommand(args, taskService);
                    break;
                default:
                    throw new IllegalArgumentException("Incorrect command format");
            }

            taskManagerCommand.execute();

            userDAO.closeDbConnection();
            taskDAO.closeDbConnection();

        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Caught exception while executing");
            e.printStackTrace();

            System.exit(0);
        }
    }
}
