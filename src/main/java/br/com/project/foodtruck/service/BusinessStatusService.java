package br.com.project.foodtruck.service;

import br.com.project.foodtruck.model.BusinessStatus;
import br.com.project.foodtruck.repository.BusinessStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BusinessStatusService {

    @Autowired
    private BusinessStatusRepository repository;

    public BusinessStatus getStatusCurrent(){
        List<BusinessStatus> all = repository.findAll();
        return all.isEmpty() ? null : all.get(0);
    }

    public BusinessStatus updateStatus(UUID id, BusinessStatus newStatus){
        BusinessStatus statusExisting = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("status não encontrado"));
        statusExisting.setOpen(newStatus.isOpen());
        statusExisting.setDaysWeek(newStatus.getDaysWeek());
        statusExisting.setHoursOpening(newStatus.getHoursOpening());
        statusExisting.setHoursClosing(newStatus.getHoursClosing());

        return repository.save(statusExisting);
    }

}
