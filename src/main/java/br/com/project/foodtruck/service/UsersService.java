package br.com.project.foodtruck.service;


import br.com.project.foodtruck.model.Users;
import br.com.project.foodtruck.model.enums.TypeUsers;
import br.com.project.foodtruck.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsersService {

    @Autowired
    private UsersRepository repository;

    public List<Users> listAll() {
        return repository.findAll();
    }

    public Users searchById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public Users save(Users users, TypeUsers typeCreate) {

        if (typeCreate == TypeUsers.ADMIN && users.getType() == TypeUsers.ADMIN) {
            throw new RuntimeException("ADMIN não pode criar outro ADMIN");
        }
        return repository.save(users);
    }

    public Users update(UUID id, Users UpdatedData) {
        Users existingUser = searchById(id);
        existingUser.setEmail(UpdatedData.getEmail());
        existingUser.setPassword(UpdatedData.getPassword());
        existingUser.setType(UpdatedData.getType());
        return  repository.save(existingUser);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
