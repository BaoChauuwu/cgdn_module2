package test_casestudy.model.repository;

import test_casestudy.model.entity.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> findAllEmployees();
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    Employee findById(String id);


}
