package test_casestudy.view;

import test_casestudy.controller.EmployeeManagement;
import test_casestudy.controller.StudentManagement;

import java.util.Scanner;

public class MainView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EmployeeManagement employeeManagement = new EmployeeManagement();
    private static final StudentManagement studentManagement = new StudentManagement();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Employee Management");
            System.out.println("2. Student Management");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                System.out.print("Enter your choice: ");
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    employeeManagement.employeeManagementMenu();
                    break;
                case 2:
                    studentManagement.studentManagementMenu();
                    break;
                case 0:
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }
}
