package br.com.project.foodtruck.controller;

import br.com.project.foodtruck.model.BusinessStatus;
import br.com.project.foodtruck.service.BusinessStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/status")
public class BusinessStatusController {

    @Autowired
    private BusinessStatusService service;

    @GetMapping
    public ResponseEntity<BusinessStatus> getStatus() {
        BusinessStatus status = service.getStatusCurrent();
        if (status == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusinessStatus> update(@PathVariable UUID id, @RequestBody BusinessStatus newStatus) {
        return ResponseEntity.ok(service.updateStatus(id, newStatus));
    }

}
