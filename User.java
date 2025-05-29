public class User {
    private int id;
    private String name;
    private String role;
    private String email;

    public User(int id, String name, String role, String email) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.email = email;
    }

    public int getId() { return id; }
    public String getEmail() { return email; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "[" + id + "] " + name + " (" + role + ") - " + email;
    }
}
