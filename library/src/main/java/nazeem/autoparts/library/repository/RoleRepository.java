package nazeem.autoparts.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nazeem.autoparts.library.model.user.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}