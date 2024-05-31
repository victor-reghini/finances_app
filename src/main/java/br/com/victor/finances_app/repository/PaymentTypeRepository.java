package br.com.victor.finances_app.repository;

import br.com.victor.finances_app.entity.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long> {
}
