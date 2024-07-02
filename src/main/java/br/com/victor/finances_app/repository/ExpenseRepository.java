package br.com.victor.finances_app.repository;

import br.com.victor.finances_app.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    @Query(value = "SELECT * FROM EXPENSES WHERE USER_ID = ?1", countQuery = "SELECT COUNT(*) FROM EXPENSES WHERE USER_ID = ?1", nativeQuery = true)
    List<Expense> getAllByUser(@Param("user_id") Long userId);

    @Query(value = "SELECT * FROM EXPENSES WHERE USER_ID = ?1 AND ACCOUNT_ID = ?2 AND PAYMENT_DUE_DATE >= ?3 AND PAYMENT_DUE_DATE <= ?4",
            countQuery = "SELECT COUNT(*) FROM EXPENSES WHERE USER_ID = ?1 AND ACCOUNT_ID = ?2 AND PAYMENT_DUE_DATE >= ?3 AND PAYMENT_DUE_DATE <= ?4",
            nativeQuery = true)
    List<Expense> getAllByUserAccountAndPaymentDueDate(@Param("user_id") Long userId,
                                                     @Param("account_id") Long accountId,
                                                     @Param("start_date") Date startDate,
                                                     @Param("end_date") Date endDate);

    @Query(value = "SELECT * FROM EXPENSES WHERE USER_ID = ?1 AND PAYMENT_DUE_DATE >= ?2 AND PAYMENT_DUE_DATE <= ?3",
            countQuery = "SELECT COUNT(*) FROM EXPENSES WHERE USER_ID = ?1 AND PAYMENT_DUE_DATE >= ?2 AND PAYMENT_DUE_DATE <= ?3",
            nativeQuery = true)
    List<Expense> getAllByUserAndPaymentDueDate(@Param("user_id") Long userId,
                                               @Param("start_date") Date startDate,
                                               @Param("end_date") Date endDate);
}
