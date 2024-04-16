package codegym.repository;

import codegym.model.Student;

import java.util.List;

public interface StudentRepository {
    Student getStudentById(int id);
    List<Student> getList();
    List<Student> getListWithPaging(int pageNumber, int pageRecords);
    void save(Student student);
    void update(Student student);
    void deleteStudentById(int id);
}
