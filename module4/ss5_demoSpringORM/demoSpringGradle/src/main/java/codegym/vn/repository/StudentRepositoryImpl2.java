package codegym.vn.repository;

import codegym.vn.entity.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class StudentRepositoryImpl2 implements StudentRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void create(Student student) {
        entityManager.persist(student);
    }

    @Override
    public void delete(Student student) {
        entityManager.remove(student);
    }

    @Override
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    public Student findById(String id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("select s from Student s").getResultList();
    }
}
