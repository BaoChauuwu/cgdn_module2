package test_casestudy.model.entity;

public class Student extends Person {
    private String className;

    public Student(String id, String code, String name, String email, String dateOfBirth, String className) {
        super(id, code, name, email, dateOfBirth);
        this.className = className;
    }

    public Student(String className) {
        this.className = className;
    }
    public Student() {}

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String getInfoToCSV() {
        return this.getId()  + this.getCode() + this.getName() + this.getEmail() + this.getDateOfBirth() + this.getClassName();
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                "className='" + className + '\'' +
                '}';
    }
}
