package casestudy.view;

import java.util.Scanner;

public class MainView {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("-------Management------------");
            System.out.println("1.Management Employee");
            System.out.println("2. Management Student");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    employeeMenu();
                    break;
                case 2:
                    studentMenu();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void employeeMenu() {
        while (true) {
            System.out.println("--------Management Employee-----------");
            System.out.println("1.List Employees");
            System.out.println("2. Add Employee");
            System.out.println("3.Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("0. Back to main menu");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("List Employees feature - Coming soon!");
                    break;
                case 2:
                    System.out.println("Add Employee feature - Coming soon!");
                    break;
                case 3:
                    System.out.println("Update Employee feature - Coming soon!");
                    break;
                case 4:
                    System.out.println("Delete Employee feature - Coming soon!");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void studentMenu() {
        while (true) {
            System.out.println("--------Management Student-----------");
            System.out.println("1.List Students");
            System.out.println("2. Add Student");
            System.out.println("3.Update Student");
            System.out.println("4. Delete Student");
            System.out.println("0. Back to main menu");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("List Students feature - Coming soon!");
                    break;
                case 2:
                    System.out.println("Add Student feature - Coming soon!");
                    break;
                case 3:
                    System.out.println("Update Student feature - Coming soon!");
                    break;
                case 4:
                    System.out.println("Delete Student feature - Coming soon!");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
