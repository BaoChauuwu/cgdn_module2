package test_casestudy.model.repository;

import test_casestudy.model.entity.Student;
import test_casestudy.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private final boolean APPEND = true;

    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        List<String> stringList = ReadAndWriteFile.readFromFile("test_casestudy/data/Student.csv");
        String[] array = null;
        for (String string : stringList) {
            if (!string.trim().isEmpty()) {
                array = string.split(",");
                if (array.length >= 6) {
                    Student student = new Student(array[0], array[1], array[2], array[3], array[4], array[5]);
                    studentList.add(student);
                }
            }
        }
        return studentList;
    }

    @Override
    public void addStudent(Student student) {
        List<String> studentList = new ArrayList<>();
        studentList.add(student.getInfoToCSV());
        ReadAndWriteFile.writeToFile("test_casestudy/data/Student.csv", studentList, APPEND);
    }

    @Override
    public void deleteStudent(Student student) {
        List<Student> studentList = findAll();
        studentList.removeIf(s -> s.getId().equals(student.getId()));
        saveAllStudents(studentList);
    }

    @Override
    public void updateStudent(Student student) {
        List<Student> studentList = findAll();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(student.getId())) {
                studentList.set(i, student);
                break;
            }
        }
        saveAllStudents(studentList);
    }


    @Override
    public Student findById(String id) {
        List<Student> studentList = findAll();
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    private void saveAllStudents(List<Student> studentList) {
        List<String> stringList = new ArrayList<>();
        for (Student student : studentList) {
            stringList.add(student.getInfoToCSV());
        }
        ReadAndWriteFile.writeToFile("test_casestudy/data/Student.csv", stringList, false);
    }
}


