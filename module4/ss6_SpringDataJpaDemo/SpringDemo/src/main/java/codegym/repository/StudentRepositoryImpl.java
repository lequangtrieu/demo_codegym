package codegym.repository;

import codegym.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class StudentRepositoryImpl implements StudentRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Student getStudentById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> getList() {
        return entityManager.createQuery("select s from Student s")
                .getResultList();
    }

    /*
        pageNumber: số trang
        pageRecords: số record mỗi trang
     */
    @Override
    public List<Student> getListWithPaging(int pageNumber, int pageRecords) {
        return entityManager.createQuery("select s from Student s")
                .setFirstResult((pageNumber - 1) * pageRecords)
                .setMaxResults(pageRecords)
                .getResultList();
    }

    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    public void deleteStudentById(int id) {
        Student entity = entityManager.find(Student.class, id);
        entityManager.remove(entity);
    }

    public List<Student> getListByName(String name) {
        return entityManager.createQuery("select s from Student s where s.name like :name" +
                        " and s.address = :address")
                .setParameter("name", "%" + name + "%")
                .setParameter("address", "Đà Nẵng")
                .getResultList();
    }

    public List<Student> getListByAddress(String address) {
        return entityManager.createNamedQuery("searchByAddress")
                .setParameter("address", "%" + address + "%")
                .getResultList();
    }
}
