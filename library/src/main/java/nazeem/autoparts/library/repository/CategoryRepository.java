package nazeem.autoparts.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nazeem.autoparts.library.model.product.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}