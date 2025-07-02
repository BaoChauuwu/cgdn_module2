package test_casestudy.model.entity;

public class Employee extends Person {
    private Double salary;

    public Employee(String id, String code, String name, String email, String dateOfBirth, Double salary) {
        super(id, code, name, email, dateOfBirth);
        this.salary = salary;
    }

    public Employee(Double salary) {
        this.salary = salary;
    }



    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
    @Override
    public String getInfoToCSV() {
        return this.getId() + "," + this.getCode() + "," + this.getName() + "," + this.getEmail() + "," + this.getDateOfBirth() + this.getSalary();
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                "salary=" + salary +
                '}';
    }
}
