package br.com.project.foodtruck.repository;

import br.com.project.foodtruck.model.BusinessStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BusinessStatusRepository extends JpaRepository<BusinessStatus, UUID> {
}
