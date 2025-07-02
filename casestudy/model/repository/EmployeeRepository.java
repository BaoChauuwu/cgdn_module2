package casestudy.model.repository;

import casestudy.model.entity.Employee;
import casestudy.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private final boolean APPEND = true;
    private final String FILE_PATH = "casestudy/data/employee.csv";

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        List<String> stringList = ReadAndWriteFile.readFromFile(FILE_PATH);
        String [] array = null;
        for (String string : stringList) {
            if (!string.trim().isEmpty()) {
                array = string.split(",");
                if (array.length >= 8) {
                    Employee employee = new Employee(array[0],array[1],array[2],array[3],Integer.parseInt(array[4]),array[5],Double.parseDouble(array[6]),array[7]);
                    employeeList.add(employee);
                }
            }
        }
        return employeeList;
    }

    @Override
    public void addEmployee(Employee employee) {
        List<String> employeeList = new ArrayList<>();
        employeeList.add(employee.getInfoToCSV());
        ReadAndWriteFile.writeToFile(FILE_PATH, employeeList, APPEND);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        List<Employee> employeeList = findAll();
        employeeList.removeIf(e -> e.getId().equals(employee.getId()));
        saveAllEmployees(employeeList);
    }

    @Override
    public void updateEmployee(Employee employee) {
        List<Employee> employeeList = findAll();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(employee.getId())) {
                employeeList.set(i, employee);
                break;
            }
        }
        saveAllEmployees(employeeList);
    }

    @Override
    public Employee findById(String id) {
        List<Employee> employeeList = findAll();
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
        ReadAndWriteFile.writeToFile(FILE_PATH, stringList, false);
    }
}
