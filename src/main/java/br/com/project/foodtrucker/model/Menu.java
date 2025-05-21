package br.com.project.foodtrucker.model;

import br.com.project.foodtrucker.model.enums.CategoryMenu;
import jakarta.persistence.*;
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

    @Enumerated(EnumType.STRING)
    private CategoryMenu category;

}
