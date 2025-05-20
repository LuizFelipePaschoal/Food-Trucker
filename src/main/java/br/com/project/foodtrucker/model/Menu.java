package br.com.project.foodtrucker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
public class Menu {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String description;
    private BigDecimal price;
}
