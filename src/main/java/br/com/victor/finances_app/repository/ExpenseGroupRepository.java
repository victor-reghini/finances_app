package br.com.victor.finances_app.repository;

import br.com.victor.finances_app.entity.ExpenseGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpenseGroupRepository extends JpaRepository<ExpenseGroup, Long> {
    @Query(value = "select eg from ExpenseGroup eg where eg.user.id = :userId")
    List<ExpenseGroup> findExpenseGroupByUserId(@Param("userId") Long userId);
}
