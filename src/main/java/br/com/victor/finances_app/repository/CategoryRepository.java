package br.com.victor.finances_app.repository;

import br.com.victor.finances_app.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "select c from Category c where c.user.id = :userId")
    List<Category> getAllCategoriesByUserId(@Param("userId") Long userId);
}
