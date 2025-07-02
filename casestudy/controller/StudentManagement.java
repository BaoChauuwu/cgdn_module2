package casestudy.controller;

import casestudy.model.entity.Student;
import casestudy.model.service.IStudentService;
import casestudy.model.service.StudentService;

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

    private void displayAllStudents() {
        List<Student> students = studentService.findAll();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\n=== ALL STUDENTS ===");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private void addNewStudent() {
        try {
            System.out.print("Enter student ID: ");
            String id = scanner.nextLine();
            
            if (studentService.isIdExist(id)) {
                System.out.println("Student with this ID already exists!");
                return;
            }

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student email: ");
            String email = scanner.nextLine();
            System.out.print("Enter date of birth: ");
            String dateOfBirth = scanner.nextLine();
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter class name: ");
            String className = scanner.nextLine();

            Student student = new Student(id, name, email, dateOfBirth, age, className);
            studentService.addStudent(student);
            System.out.println("Student added successfully!");

        } catch (Exception e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    private void updateStudent() {
        try {
            System.out.print("Enter student ID to update: ");
            String id = scanner.nextLine();

            Student existingStudent = studentService.findById(id);
            if (existingStudent == null) {
                System.out.println("Student not found!");
                return;
            }

            System.out.println("Current student info: " + existingStudent);
            System.out.print("Enter new name (or press Enter to keep current): ");
            String name = scanner.nextLine();
            if (name.isEmpty()) name = existingStudent.getName();

            System.out.print("Enter new email (or press Enter to keep current): ");
            String email = scanner.nextLine();
            if (email.isEmpty()) email = existingStudent.getEmail();

            System.out.print("Enter new date of birth (or press Enter to keep current): ");
            String dateOfBirth = scanner.nextLine();
            if (dateOfBirth.isEmpty()) dateOfBirth = existingStudent.getDateOfBirth();

            System.out.print("Enter new age (or 0 to keep current): ");
            int age = scanner.nextInt();
            if (age == 0) age = existingStudent.getAge();
            scanner.nextLine(); // consume newline

            System.out.print("Enter new class name (or press Enter to keep current): ");
            String className = scanner.nextLine();
            if (className.isEmpty()) className = existingStudent.getClassName();

            Student updatedStudent = new Student(existingStudent.getId(), name, email, dateOfBirth, age, className);
            studentService.updateStudent(updatedStudent);
            System.out.println("Student updated successfully!");

        } catch (Exception e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    private void deleteStudent() {
        try {
            System.out.print("Enter student ID to delete: ");
            String id = scanner.nextLine();

            Student student = studentService.findById(id);
            if (student == null) {
                System.out.println("Student not found!");
                return;
            }

            System.out.println("Student to delete: " + student);
            System.out.print("Are you sure you want to delete this student? (y/N): ");
            String confirm = scanner.nextLine();

            if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
                studentService.deleteStudent(student);
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Deletion cancelled.");
            }

        } catch (Exception e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }

    private void searchStudentById() {
        try {
            System.out.print("Enter student ID: ");
            String id = scanner.nextLine();

            Student student = studentService.findById(id);
            if (student == null) {
                System.out.println("Student not found!");
            } else {
                System.out.println("Found student: " + student);
            }

        } catch (Exception e) {
            System.out.println("Error searching student: " + e.getMessage());
        }
    }

}
