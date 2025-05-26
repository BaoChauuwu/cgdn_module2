package crud;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    ArrayList<Student> students = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addStudent() {
        System.out.println("Enter Student ID");
        int id = Integer.parseInt(sc.nextLine());

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("Student ID already exists.");
                return;
            }
        }

        System.out.println("Enter Student Name");
        String name = sc.nextLine();
        System.out.println("Enter Student Address");
        String address = sc.nextLine();
        System.out.println("Enter Student Email");
        String email = sc.nextLine();

        Student student = new Student(id, name, address, email);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void updateStudent() {
        System.out.println("Enter Student ID to update");
        int id = Integer.parseInt(sc.nextLine());

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("Enter new Student Name");
                String name = sc.nextLine();
                System.out.println("Enter new Student Address");
                String address = sc.nextLine();
                System.out.println("Enter new Student Email");
                String email = sc.nextLine();

                s.setName(name);
                s.setAddress(address);
                s.setEmail(email);
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student ID not found.");
    }

    public void deleteStudent() {
        System.out.println("Enter Student ID to delete");
        int id = Integer.parseInt(sc.nextLine());

        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("Student deleted successfully.");
                return;
            }
        }
        System.out.println("Student ID not found.");
    }

    public void listStudent() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
