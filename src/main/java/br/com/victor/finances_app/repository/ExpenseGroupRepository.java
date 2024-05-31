package br.com.victor.finances_app.repository;

import br.com.victor.finances_app.entity.ExpenseGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseGroupRepository extends JpaRepository<ExpenseGroup, Long> {
}
