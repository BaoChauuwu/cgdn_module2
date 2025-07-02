package test_casestudy.model.service;



import test_casestudy.model.entity.Student;

import java.util.List;

public interface IStudentService {
  List<Student> findAll();
  void addStudent(Student student);
  void deleteStudent(Student student);
  void updateStudent(Student student);
  Student findById(String id);
  boolean isIdExist(String id);
}
