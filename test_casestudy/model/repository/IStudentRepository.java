package test_casestudy.model.repository;




import test_casestudy.model.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    void addStudent(Student student);
    void deleteStudent(Student student);
    void updateStudent(Student student);
    Student findById(String id);
}
