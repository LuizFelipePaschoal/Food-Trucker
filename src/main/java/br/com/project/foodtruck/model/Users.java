package br.com.project.foodtruck.model;

import br.com.project.foodtruck.model.enums.TypeUsers;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Users {
    @Id
    @GeneratedValue
    private UUID id;

    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private TypeUsers type;
}
