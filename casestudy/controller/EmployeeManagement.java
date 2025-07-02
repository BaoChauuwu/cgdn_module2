package casestudy.controller;

import casestudy.model.entity.Employee;
import casestudy.model.service.IEmployeeService;
import casestudy.model.service.EmployeeService;

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

    private void displayAllEmployees() {
        List<Employee> employees = employeeService.findAll();
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("\n=== ALL EMPLOYEES ===");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    private void addNewEmployee() {
        try {
            System.out.print("Enter employee ID: ");
            String id = scanner.nextLine();
            
            if (employeeService.isIdExist(id)) {
                System.out.println("Employee with this ID already exists!");
                return;
            }

            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();
            System.out.print("Enter employee email: ");
            String email = scanner.nextLine();
            System.out.print("Enter date of birth: ");
            String dateOfBirth = scanner.nextLine();
            System.out.print("Enter age: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter position: ");
            String position = scanner.nextLine();
            System.out.print("Enter salary: ");
            double salary = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter work location: ");
            String workLocation = scanner.nextLine();

            Employee employee = new Employee(id, name, email, dateOfBirth, age, position, salary, workLocation);
            employeeService.addEmployee(employee);
            System.out.println("Employee added successfully!");

        } catch (Exception e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }

    private void updateEmployee() {
        try {
            System.out.print("Enter employee ID to update: ");
            String id = scanner.nextLine();

            Employee existingEmployee = employeeService.findById(id);
            if (existingEmployee == null) {
                System.out.println("Employee not found!");
                return;
            }

            System.out.println("Current employee info: " + existingEmployee);
            System.out.print("Enter new name (or press Enter to keep current): ");
            String name = scanner.nextLine();
            if (name.isEmpty()) name = existingEmployee.getName();

            System.out.print("Enter new email (or press Enter to keep current): ");
            String email = scanner.nextLine();
            if (email.isEmpty()) email = existingEmployee.getEmail();

            System.out.print("Enter new date of birth (or press Enter to keep current): ");
            String dateOfBirth = scanner.nextLine();
            if (dateOfBirth.isEmpty()) dateOfBirth = existingEmployee.getDateOfBirth();

            System.out.print("Enter new age (or 0 to keep current): ");
            int age = scanner.nextInt();
            if (age == 0) age = existingEmployee.getAge();
            scanner.nextLine(); // consume newline

            System.out.print("Enter new position (or press Enter to keep current): ");
            String position = scanner.nextLine();
            if (position.isEmpty()) position = existingEmployee.getPosition();

            System.out.print("Enter new salary (or 0 to keep current): ");
            double salary = scanner.nextDouble();
            if (salary == 0) salary = existingEmployee.getSalary();
            scanner.nextLine(); // consume newline

            System.out.print("Enter new work location (or press Enter to keep current): ");
            String workLocation = scanner.nextLine();
            if (workLocation.isEmpty()) workLocation = existingEmployee.getWorkLocation();

            Employee updatedEmployee = new Employee(existingEmployee.getId(), name, email, dateOfBirth, age, position, salary, workLocation);
            employeeService.updateEmployee(updatedEmployee);
            System.out.println("Employee updated successfully!");

        } catch (Exception e) {
            System.out.println("Error updating employee: " + e.getMessage());
        }
    }

    private void deleteEmployee() {
        try {
            System.out.print("Enter employee ID to delete: ");
            String id = scanner.nextLine();

            Employee employee = employeeService.findById(id);
            if (employee == null) {
                System.out.println("Employee not found!");
                return;
            }

            System.out.println("Employee to delete: " + employee);
            System.out.print("Are you sure you want to delete this employee? (y/N): ");
            String confirm = scanner.nextLine();

            if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
                employeeService.deleteEmployee(employee);
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("Deletion cancelled.");
            }

        } catch (Exception e) {
            System.out.println("Error deleting employee: " + e.getMessage());
        }
    }

    private void searchEmployeeById() {
        try {
            System.out.print("Enter employee ID: ");
            String id = scanner.nextLine();

            Employee employee = employeeService.findById(id);
            if (employee == null) {
                System.out.println("Employee not found!");
            } else {
                System.out.println("Found employee: " + employee);
            }

        } catch (Exception e) {
            System.out.println("Error searching employee: " + e.getMessage());
        }
    }
}
