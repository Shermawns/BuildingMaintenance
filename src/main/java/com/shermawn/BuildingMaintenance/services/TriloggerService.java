package com.shermawn.BuildingMaintenance.services;

import com.shermawn.BuildingMaintenance.models.Trilogger;
import com.shermawn.BuildingMaintenance.repositories.TriloggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TriloggerService {

    @Autowired
    private TriloggerRepository triloggerRepository;

    public List<Trilogger> findAll(){
        return triloggerRepository.findAll();
    }

    public Trilogger create(Trilogger trilogger){
        return triloggerRepository.save(trilogger);
    }

    public void delete(Long id){
        triloggerRepository.deleteById(id);
    }

}
