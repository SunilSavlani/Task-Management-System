import java.util.ArrayList;
import java.util.List;

public class Project {
    private int id;
    private String name;
    private List<Task> taskList = new ArrayList<>();

    public Project(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public List<Task> getTaskList() { return taskList; }

    public void addTask(Task task) {
        taskList.add(task);
    }

    @Override
    public String toString() {
        return "[" + id + "] Project: " + name + " | Tasks: " + taskList.size();
    }
}
