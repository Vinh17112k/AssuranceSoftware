package nazeem.autoparts.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nazeem.autoparts.library.model.customer.Fullname;

public interface FullnameRepository extends JpaRepository<Fullname, Long> {
	
}
