package codegym.vn.demosecurity.repository;

import codegym.vn.demosecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
