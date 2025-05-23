package br.com.project.foodtruck.controller;

import br.com.project.foodtruck.model.Users;
import br.com.project.foodtruck.model.enums.TypeUsers;
import br.com.project.foodtruck.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService service;

    @GetMapping
    public ResponseEntity<List<Users>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> search(@PathVariable UUID id) {
        return ResponseEntity.ok(service.searchById(id));
    }

    @PostMapping
    public ResponseEntity<Users> create(@RequestBody Users users) {
        return ResponseEntity.ok(service.save(users, TypeUsers.ADMIN));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> update(@PathVariable UUID id, @RequestBody Users users) {
        return ResponseEntity.ok(service.update(id, users));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
