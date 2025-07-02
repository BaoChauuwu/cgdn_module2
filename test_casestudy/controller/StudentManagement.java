package test_casestudy.controller;

import test_casestudy.model.entity.Student;
import test_casestudy.model.service.IStudentService;
import test_casestudy.model.service.StudentService;

import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    private IStudentService studentService = new StudentService();
    private Scanner scanner = new Scanner(System.in);

    public void studentManagementMenu() {
        int choice;
        do {
            System.out.println("\n=== STUDENT MANAGEMENT ===");
            System.out.println("1. Display all students");
            System.out.println("2. Add new student");
            System.out.println("3. Update student");
            System.out.println("4. Delete student");
            System.out.println("5. Search student by ID");
            System.out.println("0. Return to main menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayAllStudents();
                    break;
                case 2:
                    addNewStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    searchStudentById();
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }

    public void displayAllStudents() {
        List<Student> students = studentService.findAll();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("Student list:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void addNewStudent() {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        if (studentService.isIdExist(id)) {
            System.out.println("Student with this ID already exists!");
            return;
        }

        System.out.print("Enter Code: ");
        String code = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter DOB: ");
        String dob = scanner.nextLine();
        System.out.print("Enter GPA: ");
        String className =scanner.nextLine();

        Student student = new Student(id, code, name, email, dob, className);
        studentService.addStudent(student);
        System.out.println("Student added successfully!");
    }

    public void updateStudent() {
        System.out.print("Enter ID of the student to update: ");
        String id = scanner.nextLine();

        if (!studentService.isIdExist(id)) {
            System.out.println("Student with this ID does not exist!");
            return;
        }

        System.out.print("Enter new Code: ");
        String code = scanner.nextLine();
        System.out.print("Enter new Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter new DOB: ");
        String dob = scanner.nextLine();
        System.out.print("Enter new className: ");
        String className = scanner.nextLine();

        Student updatedStudent = new Student(id, code, name, email, dob, className);
        studentService.updateStudent(updatedStudent);
        System.out.println("Student updated successfully!");
    }

    public void deleteStudent() {
        System.out.print("Enter ID of the student to delete: ");
        String id = scanner.nextLine();

        Student student = studentService.findById(id);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        studentService.deleteStudent(student);
        System.out.println("Student deleted successfully!");
    }

    public void searchStudentById() {
        System.out.print("Enter ID of the student to search: ");
        String id = scanner.nextLine();

        Student student = studentService.findById(id);
        if (student == null) {
            System.out.println("Student not found!");
        } else {
            System.out.println("Student found:");
            System.out.println(student);
        }
    }
}
