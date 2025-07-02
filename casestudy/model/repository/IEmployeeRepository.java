package casestudy.model.repository;

import casestudy.model.entity.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> findAll();
    void addEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    void updateEmployee(Employee employee);
    Employee findById(String id);

}
