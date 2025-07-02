package test_casestudy.model.repository;

import test_casestudy.model.entity.Employee;
import test_casestudy.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private final boolean APPEND = true;

    @Override
    public List<Employee> findAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        List<String> stringList = ReadAndWriteFile.readFromFile("test_casestudy/data/Employee.csv");
        String[] array = null;
        for (String string : stringList) {
            array = string.split(",");
            Employee employee = new Employee(array[0], array[1], array[2], array[3], array[4], Double.parseDouble(array[5]));
            employeeList.add(employee);
        }
        return employeeList;
    }


    @Override
    public void addEmployee(Employee employee) {
        List<String> employeeList = new ArrayList<>();
        employeeList.add(employee.getInfoToCSV());
        ReadAndWriteFile.writeToFile("test_casestudy/data/Employee.csv",employeeList,APPEND);

    }

    @Override
    public void updateEmployee(Employee employee) {
        List<Employee> employeeList = findAllEmployees();
        for(int i=0;i<employeeList.size();i++){
            if(employeeList.get(i).getId().equals(employee.getId())){
                employeeList.set(i,employee);
                break;
            }
        }
        saveAllEmployees(employeeList);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        List<Employee> employeeList = findAllEmployees();
        employeeList.removeIf(employee1 -> employee1.getId().equals(employee.getId()));
        saveAllEmployees(employeeList);

    }

    @Override
    public Employee findById(String id) {
        List<Employee> employeeList = findAllEmployees();
        for (Employee employee : employeeList) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    private void saveAllEmployees(List<Employee> employeeList) {
        List<String> stringList = new ArrayList<>();
        for (Employee employee : employeeList) {
            stringList.add(employee.getInfoToCSV());
        }
        ReadAndWriteFile.writeToFile("test_casestudy/data/Employee.csv", stringList, false);
    }
}
