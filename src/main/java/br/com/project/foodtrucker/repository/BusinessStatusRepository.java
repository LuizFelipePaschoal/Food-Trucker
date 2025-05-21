package br.com.project.foodtrucker.repository;

import br.com.project.foodtrucker.model.BusinessStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BusinessStatusRepository extends JpaRepository<BusinessStatus, UUID> {
}
