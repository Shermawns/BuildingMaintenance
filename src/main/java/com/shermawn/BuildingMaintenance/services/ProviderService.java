package com.shermawn.BuildingMaintenance.services;

import com.shermawn.BuildingMaintenance.dto.provider.RequestProviderDTO;
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

    public void delete(Long id){
        providerRepository.deleteById(id);
    }

    public Provider updateProvider(Long id, Provider provider) {
        Provider existingProvider = providerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider com o ID " + id + " não foi encontrado."));

        if (provider.getUsername() != null) {
            existingProvider.setUsername(provider.getUsername());
        }
        if (provider.getPassword() != null) {
            existingProvider.setPassword(provider.getPassword());
        }
        if (provider.getCnpj() != null) {
            existingProvider.setCnpj(provider.getCnpj());
        }

        return providerRepository.save(existingProvider);
    }

}
