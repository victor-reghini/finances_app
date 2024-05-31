package br.com.victor.finances_app.repository;

import br.com.victor.finances_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
