package br.com.victor.finances_app.repository;

import br.com.victor.finances_app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query(value = "select acc from Account acc WHERE acc.user.id = :userId")
    List<Account> findAccountsByUserId(@Param("userId") Long userId);
}
