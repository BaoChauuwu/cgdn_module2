package crud;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        boolean check = true;
        while (check) {

            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View All Students");
            System.out.println("5.Thoat");
            Scanner sc = new Scanner(System.in);
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    studentManagement.addStudent();
                    break;
                case 2:
                    studentManagement.updateStudent();
                    break;
                case 3:
                    studentManagement.deleteStudent();
                    break;
                case 4:
                    studentManagement.listStudent();
                    break;
                case 5:
                    check = false;
                default:
                    System.out.println("Moi ban nhap lai");
                    break;
            }
        }
    }
}
