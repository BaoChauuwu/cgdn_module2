package test_casestudy.model.service;


import test_casestudy.model.entity.Employee;
import test_casestudy.model.repository.EmployeeRepository;
import test_casestudy.model.repository.IEmployeeRepository;

import java.util.List;

public class EmployeeService implements  IEmployeeService {
    private IEmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAllEmployees();
    }

    @Override
    public void addEmployee(Employee employee) {
        if (employee != null && !isIdExist(employee.getId())) {
            employeeRepository.addEmployee(employee);
        } else {
            System.out.println("Employee is already exist");
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        if (employee != null && !isIdExist(employee.getId())) {
            employeeRepository.updateEmployee(employee);
        }
        else {
            System.out.println("Employee not exist");
        }

    }

    @Override
    public void deleteEmployee(Employee employee) {
        if (employee != null && isIdExist(employee.getId())) {
            employeeRepository.deleteEmployee(employee);
        }
        else {
            System.out.println("Employee Not Found");
        }
    }

    @Override
    public Employee findById(String id) {
        return employeeRepository.findById(id);
    }

    @Override
    public boolean isIdExist(String id) {
        List<Employee> allEmployees = findAllEmployees();
        for (Employee employee : allEmployees) {
            if (employee.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
