package br.com.project.foodtruck.repository;

import br.com.project.foodtruck.model.Menu;
import br.com.project.foodtruck.model.enums.CategoryMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MenuRepository extends JpaRepository<Menu, UUID> {
    List<Menu> findByCategory(CategoryMenu category);
}
