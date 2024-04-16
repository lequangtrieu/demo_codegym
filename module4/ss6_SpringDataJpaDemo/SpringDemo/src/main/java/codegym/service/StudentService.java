package codegym.service;

import codegym.model.Student;

import java.util.List;

public interface StudentService {
    Student getStudentById(int id);
    List<Student> getList();
    void save(Student student);
    void update(Student student);
    void deleteStudentById(int id);
    List<Student> getListWithPaging(int pageNumber, int pageRecords);
}
