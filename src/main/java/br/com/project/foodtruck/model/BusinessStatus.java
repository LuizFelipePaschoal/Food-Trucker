package br.com.project.foodtruck.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class BusinessStatus {

    @Id
    @GeneratedValue
    private UUID Id;

    private boolean open;
    private String hoursOpening;
    private String hoursClosing;
    private String daysWeek;
}
