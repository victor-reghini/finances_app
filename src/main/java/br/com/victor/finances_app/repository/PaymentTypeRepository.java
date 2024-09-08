package br.com.victor.finances_app.repository;

import br.com.victor.finances_app.entity.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long> {
    @Query(value = "select pt from PaymentType pt where pt.user.id = :userId")
    List<PaymentType> findPaymentTypeByUserId(@Param("userId") Long userId);
}
