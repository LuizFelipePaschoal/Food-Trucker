package br.com.project.foodtrucker.repository;

import br.com.project.foodtrucker.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MenuRepository extends JpaRepository<Menu, UUID> {
}
