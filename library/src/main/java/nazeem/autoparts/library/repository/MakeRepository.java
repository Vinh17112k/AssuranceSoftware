package nazeem.autoparts.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nazeem.autoparts.library.model.product.Make;

public interface MakeRepository extends JpaRepository<Make, Long> {
    Make findByName(String name);
}