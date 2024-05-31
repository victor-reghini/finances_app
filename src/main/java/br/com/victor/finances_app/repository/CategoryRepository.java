package br.com.victor.finances_app.repository;

import br.com.victor.finances_app.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
