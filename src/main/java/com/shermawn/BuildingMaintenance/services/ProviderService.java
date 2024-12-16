package com.shermawn.BuildingMaintenance.services;

import com.shermawn.BuildingMaintenance.models.Provider;
import com.shermawn.BuildingMaintenance.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    public Provider create(Provider provider){
        return providerRepository.save(provider);
    }

    public List<Provider> findAll(){
        return providerRepository.findAll();
    }

}
