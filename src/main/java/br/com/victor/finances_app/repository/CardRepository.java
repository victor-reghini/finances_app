package br.com.victor.finances_app.repository;

import br.com.victor.finances_app.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    @Query(value = "select c from Card c where c.user.id = :userId")
    List<Card> findCardsByUserId(@Param("userId") Long userId);

    @Query(value = "select c from Card c where c.account.id = :accountId")
    List<Card> findCardsByAccountId(@Param("accountId") Long accountId);

    @Query(value = "select c from Card c where c.user.id = :userId and c.account.id = :accountId")
    List<Card> findCardsByUserAndAccountId(@Param("userId") Long userId, @Param("accountId") Long accountId);
}
