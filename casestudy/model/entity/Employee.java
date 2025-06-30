package casestudy.model.entity;

public class Employee extends Person {
    private String position;
    private double salary;
    private String workLocation;

    public Employee(String position, double salary, String workLocation) {
        this.position = position;
        this.salary = salary;
        this.workLocation = workLocation;
    }

    public Employee(String id, String name, String email, String dateOfBirth, int age, String position, double salary, String workLocation) {
        super(id, name, email, dateOfBirth, age);
        this.position = position;
        this.salary = salary;
        this.workLocation = workLocation;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                "position='" + position + '\'' +
                ", salary=" + salary +
                ", workLocation='" + workLocation + '\'' +
                '}';
    }
}
