import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<User> users = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();
    private int userIdCounter = 1;
    private int projectIdCounter = 1;
    private int taskIdCounter = 1;

    public void addUser(String name, String role, String email) {
        users.add(new User(userIdCounter++, name, role, email));
    }

    public void createProject(String name) {
        projects.add(new Project(projectIdCounter++, name));
    }

    public void addTaskToProject(int projectId, String title, String desc, LocalDate dueDate, Priority priority, String email) {
        Project project = getProjectById(projectId);
        User user = getUserByEmail(email);
        if (project != null && user != null) {
            Task task = new Task(taskIdCounter++, title, desc, dueDate, priority, user);
            project.addTask(task);
        } else {
            System.out.println("Invalid project ID or user email.");
        }
    }

    public void updateTaskStatus(int taskId, TaskStatus status) {
        for (Project project : projects) {
            for (Task task : project.getTaskList()) {
                if (task.getId() == taskId) {
                    task.setStatus(status);
                    return;
                }
            }
        }
        System.out.println("Task not found.");
    }

    public void listTasksByUser(String email) {
        for (Project project : projects) {
            for (Task task : project.getTaskList()) {
                if (task.getAssignedUser().getEmail().equals(email)) {
                    System.out.println(task);
                }
            }
        }
    }

    public void listTasksByStatus(TaskStatus status) {
        for (Project project : projects) {
            for (Task task : project.getTaskList()) {
                if (task.getStatus() == status) {
                    System.out.println(task);
                }
            }
        }
    }

    public void listAllProjects() {
        for (Project project : projects) {
            System.out.println(project);
        }
    }

    public void listAllUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    private Project getProjectById(int id) {
        for (Project project : projects) {
            if (project.getId() == id) return project;
        }
        return null;
    }

    private User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) return user;
        }
        return null;
    }
}
