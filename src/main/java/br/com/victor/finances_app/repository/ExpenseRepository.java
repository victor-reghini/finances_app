package br.com.victor.finances_app.repository;

import br.com.victor.finances_app.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    @Query(value = "SELECT e FROM Expense e WHERE e.user.id = :userId")
    List<Expense> getAllByUser(@Param("userId") Long userId);

    @Query(value = "SELECT e FROM Expense e WHERE e.user.id = :userId AND e.account.id = :accountId AND e.paymentDueDate >= :startDate AND e.paymentDueDate <= :endDate")
    List<Expense> getAllByUserAccountAndPaymentDueDate(@Param("userId") Long userId,
                                                     @Param("accountId") Long accountId,
                                                     @Param("startDate") Date startDate,
                                                     @Param("endDate") Date endDate);

    @Query(value = "SELECT e FROM Expense e WHERE e.user.id = :userId AND e.paymentDueDate >= :startDate AND e.paymentDueDate <= :endDate")
    List<Expense> getAllByUserAndPaymentDueDate(@Param("userId") Long userId,
                                               @Param("startDate") Date startDate,
                                               @Param("endDate") Date endDate);
}
