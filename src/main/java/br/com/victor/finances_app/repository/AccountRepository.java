package br.com.victor.finances_app.repository;

import br.com.victor.finances_app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
