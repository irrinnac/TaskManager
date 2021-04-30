package md.stefanini.internship.taskmanager.service;

import md.stefanini.internship.taskmanager.database.dao.AbstractDAO;
import md.stefanini.internship.taskmanager.database.models.Task;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskServiceImpl implements TaskService {
    private final AbstractDAO<Task> dao;

    public TaskServiceImpl(AbstractDAO<Task> taskDAO) {
        this.dao = taskDAO;
    }

    @Override
    public void assignTaskToUser(String userName, String title, String description) throws SQLException {
        Task task = new Task();

        task.setUserName(userName);
        task.setTitle(title);
        task.setDescription(description);

        dao.insert(task);
    }

    @Override
    public void showUserTasks(String userName) throws SQLException {
        List<Task> tasksByUserNameList = new ArrayList<>();
        List<Task> taskList = dao.getAll();

        for (Task task : taskList) {
            if (task.getUserName().equals(userName)) {
                tasksByUserNameList.add(task);
            }
        }


        System.out.printf("%s tasks: \n", userName);
        System.out.println(tasksByUserNameList);
    }
}
