package casestudy.model.service;

import casestudy.model.entity.Student;
import casestudy.model.repository.IStudentRepository;
import casestudy.model.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService {
    private IStudentRepository studentRepository = new StudentRepository();

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void addStudent(Student student) {
        if (student != null && !isIdExist(student.getId())) {
            studentRepository.addStudent(student);
        } else {
            throw new IllegalArgumentException("Student with this ID already exists or student is null");
        }
    }

    @Override
    public void deleteStudent(Student student) {
        if (student != null && isIdExist(student.getId())) {
            studentRepository.deleteStudent(student);
        } else {
            throw new IllegalArgumentException("Student not found or student is null");
        }
    }

    @Override
    public void updateStudent(Student student) {
        if (student != null && isIdExist(student.getId())) {
            studentRepository.updateStudent(student);
        } else {
            throw new IllegalArgumentException("Student not found or student is null");
        }
    }

    @Override
    public Student findById(String id) {
        return studentRepository.findById(id);
    }

    @Override
    public boolean isIdExist(String id) {
        List<Student> allStudents = findAll();
        for (Student student : allStudents) {
            if (student.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
