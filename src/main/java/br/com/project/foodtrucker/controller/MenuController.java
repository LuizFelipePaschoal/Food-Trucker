package br.com.project.foodtrucker.controller;


import br.com.project.foodtrucker.model.Menu;
import br.com.project.foodtrucker.model.enums.CategoryMenu;
import br.com.project.foodtrucker.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public ResponseEntity<List<Menu>> list() {
        return ResponseEntity.ok(menuService.listAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Menu> search(@PathVariable UUID id) {
        Menu menu = menuService.searchById(id);
        return menu != null ? ResponseEntity.ok(menu) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public  ResponseEntity<Menu> create(@RequestBody Menu menu) {
        return ResponseEntity.ok(menuService.save(menu));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Menu> update(@PathVariable UUID id, @RequestBody Menu menu) {
        menu.setId(id);
        return  ResponseEntity.ok(menuService.save(menu));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        menuService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Menu>> listByCategory(@PathVariable CategoryMenu category) {
        return ResponseEntity.ok(menuService.searchByCategory(category));
    }

}
