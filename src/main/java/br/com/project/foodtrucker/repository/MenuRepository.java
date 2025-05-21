package br.com.project.foodtrucker.repository;

import br.com.project.foodtrucker.model.Menu;
import br.com.project.foodtrucker.model.enums.CategoryMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MenuRepository extends JpaRepository<Menu, UUID> {
    List<Menu> findByCategory(CategoryMenu category);
}
