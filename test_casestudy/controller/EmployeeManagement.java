package test_casestudy.controller;

import test_casestudy.model.entity.Employee;
import test_casestudy.model.service.EmployeeService;
import test_casestudy.model.service.IEmployeeService;

import java.util.List;
import java.util.Scanner;

public class EmployeeManagement {
    private IEmployeeService employeeService = new EmployeeService();
    private Scanner scanner = new Scanner(System.in);

    public void employeeManagementMenu() {
        int choice;
        do {
            System.out.println("\n=== EMPLOYEE MANAGEMENT ===");
            System.out.println("1. Display all employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Update employee");
            System.out.println("4. Delete employee");
            System.out.println("5. Search employee by ID");
            System.out.println("0. Return to main menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayAllEmployees();
                    break;
                case 2:
                    addNewEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    searchEmployeeById();
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }
    public void displayAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("No employeee");

        }
        else  {
            System.out.println("Employee list:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }
    public void addNewEmployee() {
        System.out.println("Enter ID: ");
        String id = scanner.nextLine();
        if (employeeService.isIdExist(id)) {
            System.out.println("Employee with this ID already exists!");
            return;
        }
        System.out.println("Enter Code");
        String code = scanner.nextLine();
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter email");
        String email = scanner.nextLine();
        System.out.println("Enter DOB");
        String dob = scanner.nextLine();
        System.out.println("Enter salary");
        Double salary = Double.parseDouble(scanner.nextLine());
        Employee employee = new Employee(id, code, name, email, dob, salary);
        employeeService.addEmployee(employee);
        System.out.println("Employee added successfully!");
    }
    public void updateEmployee() {
        System.out.print("Enter ID of the employee to update: ");
        String id = scanner.nextLine();

        if (!employeeService.isIdExist(id)) {
            System.out.println("Employee with this ID does not exist!");
            return;
        }

        System.out.println("Enter new Code:");
        String code = scanner.nextLine();
        System.out.println("Enter new Name:");
        String name = scanner.nextLine();
        System.out.println("Enter new Email:");
        String email = scanner.nextLine();
        System.out.println("Enter new Date of Birth:");
        String dob = scanner.nextLine();
        System.out.println("Enter new Salary:");
        Double salary = Double.parseDouble(scanner.nextLine());

        Employee updatedEmployee = new Employee(id, code, name, email, dob, salary);
        employeeService.updateEmployee(updatedEmployee);
        System.out.println("Employee updated successfully!");
    }

    public void deleteEmployee() {
        String id = scanner.nextLine();
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            System.out.println("Employee not found!");
            return;
        }
        employeeService.deleteEmployee(employee);

    }

    public void searchEmployeeById() {
        System.out.print("Enter ID of the employee to search: ");
        String id = scanner.nextLine();

        Employee employee = employeeService.findById(id);
        if (employee == null) {
            System.out.println("Employee not found!");
        } else {
            System.out.println("Employee found:");
            System.out.println(employee);
        }
    }

}


