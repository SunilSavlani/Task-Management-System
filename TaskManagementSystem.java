import java.time.LocalDate;
import java.util.Scanner;

public class TaskManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        // Sample data
        manager.addUser("Alice", "Developer", "alice@example.com");
        manager.addUser("Bob", "Manager", "bob@example.com");
        manager.createProject("Website Redesign");

        boolean running = true;
        while (running) {
            System.out.println("\n=== Task Management Menu ===");
            System.out.println("1. Add User");
            System.out.println("2. Create Project");
            System.out.println("3. Add Task to Project");
            System.out.println("4. Update Task Status");
            System.out.println("5. List Tasks by User");
            System.out.println("6. List Tasks by Status");
            System.out.println("7. List All Projects");
            System.out.println("8. List All Users");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter role: ");
                    String role = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    manager.addUser(name, role, email);
                }
                case 2 -> {
                    System.out.print("Enter project name: ");
                    String pname = sc.nextLine();
                    manager.createProject(pname);
                }
                case 3 -> {
                    System.out.print("Enter project ID: ");
                    int pid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter task title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter description: ");
                    String desc = sc.nextLine();
                    System.out.print("Enter due date (yyyy-mm-dd): ");
                    LocalDate due = LocalDate.parse(sc.nextLine());
                    System.out.print("Enter priority (LOW, MEDIUM, HIGH): ");
                    Priority priority = Priority.valueOf(sc.nextLine().toUpperCase());
                    System.out.print("Enter assignee email: ");
                    String email = sc.nextLine();
                    manager.addTaskToProject(pid, title, desc, due, priority, email);
                }
                case 4 -> {
                    System.out.print("Enter task ID: ");
                    int tid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new status (TODO, IN_PROGRESS, DONE): ");
                    TaskStatus status = TaskStatus.valueOf(sc.nextLine().toUpperCase());
                    manager.updateTaskStatus(tid, status);
                }
                case 5 -> {
                    System.out.print("Enter user email: ");
                    String email = sc.nextLine();
                    manager.listTasksByUser(email);
                }
                case 6 -> {
                    System.out.print("Enter status (TODO, IN_PROGRESS, DONE): ");
                    TaskStatus status = TaskStatus.valueOf(sc.nextLine().toUpperCase());
                    manager.listTasksByStatus(status);
                }
                case 7 -> manager.listAllProjects();
                case 8 -> manager.listAllUsers();
                case 9 -> {
                    running = false;
                    System.out.println("Exiting system...");
                }
                default -> System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}
