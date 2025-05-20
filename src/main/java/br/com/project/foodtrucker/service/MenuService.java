package br.com.project.foodtrucker.service;

import br.com.project.foodtrucker.model.Menu;
import br.com.project.foodtrucker.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MenuService {

    @Autowired
    private MenuRepository repository;

    public List<Menu> listAll() {
        return repository.findAll();
    }

    public Menu searchById(UUID id){
        return repository.findById(id).orElse(null);
    }

    public Menu save(Menu menu) {
        return repository.save(menu);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
