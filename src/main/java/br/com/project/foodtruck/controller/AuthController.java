package br.com.project.foodtruck.controller;

import br.com.project.foodtruck.dto.LoginRequest;
import br.com.project.foodtruck.dto.LoginResponse;
import br.com.project.foodtruck.model.Users;
import br.com.project.foodtruck.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UsersRepository repository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        Optional<Users> user = repository.findByEmailAndPassword(request.getEmail(), request.getPassword());

        if (user.isPresent()) {
            String tokenFake = UUID.randomUUID().toString();
            return ResponseEntity.ok(new LoginResponse(tokenFake, user.get().getType()));
        }
        return ResponseEntity.status(401).body("Credenciais inválidas");
    }

}
