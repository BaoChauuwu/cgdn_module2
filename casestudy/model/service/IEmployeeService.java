package casestudy.model.service;

import casestudy.model.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    void addEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    void updateEmployee(Employee employee);
    Employee findById(String id);
    boolean isIdExist(String id);
}
