package casestudy.model.service;

import casestudy.model.entity.Employee;
import casestudy.model.repository.IEmployeeRepository;
import casestudy.model.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements IEmployeeService {
    private IEmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void addEmployee(Employee employee) {
        if (employee != null && !isIdExist(employee.getId())) {
            employeeRepository.addEmployee(employee);
        } else {
            throw new IllegalArgumentException("Employee with this ID already exists or employee is null");
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        if (employee != null && isIdExist(employee.getId())) {
            employeeRepository.deleteEmployee(employee);
        } else {
            throw new IllegalArgumentException("Employee not found or employee is null");
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        if (employee != null && isIdExist(employee.getId())) {
            employeeRepository.updateEmployee(employee);
        } else {
            throw new IllegalArgumentException("Employee not found or employee is null");
        }
    }

    @Override
    public Employee findById(String id) {
        return employeeRepository.findById(id);
    }

    @Override
    public boolean isIdExist(String id) {
        List<Employee> allEmployees = findAll();
        for (Employee employee : allEmployees) {
            if (employee.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
