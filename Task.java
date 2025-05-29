import java.time.LocalDate;

public class Task {
    private int id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private Priority priority;
    private TaskStatus status;
    private User assignedUser;

    public Task(int id, String title, String description, LocalDate dueDate, Priority priority, User assignedUser) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = TaskStatus.TODO;
        this.assignedUser = assignedUser;
    }

    public int getId() { return id; }
    public TaskStatus getStatus() { return status; }
    public void setStatus(TaskStatus status) { this.status = status; }
    public User getAssignedUser() { return assignedUser; }
    public LocalDate getDueDate() { return dueDate; }
    public Priority getPriority() { return priority; }

    @Override
    public String toString() {
        return "[" + id + "] " + title + " - " + status + " | Priority: " + priority +
               " | Due: " + dueDate + " | Assigned to: " + assignedUser.getName();
    }
}
