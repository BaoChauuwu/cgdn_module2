package casestudy.model.entity;

public class Student extends Person {
    private String className;

    public Student(String className) {
        this.className = className;
    }

    public Student(String id, String name, String email, String dateOfBirth, int age, String className) {
        super(id, name, email, dateOfBirth, age);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                "className='" + className + '\'' +
                '}';
    }
}
