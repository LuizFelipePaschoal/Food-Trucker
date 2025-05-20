package br.com.project.foodtrucker.controller;


import br.com.project.foodtrucker.model.Menu;
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
    private MenuService service;

    @GetMapping
    public ResponseEntity<List<Menu>> list() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> search(@PathVariable UUID id) {
        Menu menu = service.searchById(id);
        return menu != null ? ResponseEntity.ok(menu) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public  ResponseEntity<Menu> create(@RequestBody Menu menu) {
        return ResponseEntity.ok(service.save(menu));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Menu> update(@PathVariable UUID id, @RequestBody Menu menu) {
        menu.setId(id);
        return  ResponseEntity.ok(service.save(menu));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
