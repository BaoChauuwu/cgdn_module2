package test_casestudy.model.service;


import test_casestudy.model.entity.Student;
import test_casestudy.model.repository.IStudentRepository;
import test_casestudy.model.repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService {
    private IStudentRepository studentRepository = new StudentRepository();


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

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void addStudent(Student student) {
        if (student.getId() != null && isIdExist(student.getId())) {
            studentRepository.addStudent(student);
        } else {
            System.out.println("Student is Exit");
        }
    }

    @Override
    public void deleteStudent(Student student) {
        if (student.getId() != null && isIdExist(student.getId())) {
            studentRepository.deleteStudent(student);
        } else {
            System.out.println("Student not Found");
        }

    }

    @Override
    public void updateStudent(Student student) {
        if (student.getId() != null && isIdExist(student.getId())) {
            studentRepository.updateStudent(student);
        } else {
            System.out.println("Student not Found");
        }
    }

    @Override
    public Student findById(String id) {
        return studentRepository.findById(id);
    }
}
