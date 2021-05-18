package br.com.github.kalilventura.tdd.repository;

import br.com.github.kalilventura.tdd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
