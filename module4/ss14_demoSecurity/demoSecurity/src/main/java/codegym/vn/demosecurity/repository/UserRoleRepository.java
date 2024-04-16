package codegym.vn.demosecurity.repository;

import codegym.vn.demosecurity.entity.User;
import codegym.vn.demosecurity.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findAllByUser(User user);
}
