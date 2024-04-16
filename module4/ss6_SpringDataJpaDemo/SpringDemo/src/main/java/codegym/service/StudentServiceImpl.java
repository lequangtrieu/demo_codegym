package codegym.service;

import codegym.model.Student;
import codegym.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student getStudentById(int id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public List<Student> getList() {
        return studentRepository.getList();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void update(Student student) {
        studentRepository.update(student);
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepository.deleteStudentById(id);
    }

    @Override
    public List<Student> getListWithPaging(int pageNumber, int pageRecords) {
        return studentRepository.getListWithPaging(pageNumber, pageRecords);
    }
}
