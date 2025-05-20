package br.com.project.foodtrucker.repository;

import br.com.project.foodtrucker.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, UUID> {

    Optional<Users> findByEmailAndPassword(String email, String password);

}
