package model;
// model/Teacher.java

// model/Teacher.java

public class Teacher {
    private int id;
    private String name;
    private String subject;

    // Constructor for adding new teacher (no id)
    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    // Constructor for retrieving from DB (includes id)
    public Teacher(int id, String name, String subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
}
