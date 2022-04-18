package nazeem.autoparts.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nazeem.autoparts.library.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}