package casestudy.view;

import casestudy.controller.EmployeeManagement;
import casestudy.controller.StudentManagement;

import java.util.Scanner;

public class MainView {
    private static final Scanner sc = new Scanner(System.in);
    private static EmployeeManagement employeeManagement = new EmployeeManagement();
    private static StudentManagement studentManagement = new StudentManagement();

    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            System.out.println("\n-------MAIN MANAGEMENT SYSTEM------------");
            System.out.println("1. Management Employee");
            System.out.println("2. Management Student");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    employeeManagement.employeeManagementMenu();
                    break;
                case 2:
                    studentManagement.studentManagementMenu();
                    break;
                case 0:
                    System.out.println("Thank you for using the system. Goodbye!");
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
