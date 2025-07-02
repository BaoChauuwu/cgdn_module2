package test_casestudy.model.service;

import test_casestudy.model.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAllEmployees();
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    Employee findById(String id);
    boolean isIdExist(String id);
}
