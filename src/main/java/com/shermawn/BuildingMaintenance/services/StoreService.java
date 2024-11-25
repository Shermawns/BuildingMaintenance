package com.shermawn.BuildingMaintenance.services;
import com.shermawn.BuildingMaintenance.models.Store;
import com.shermawn.BuildingMaintenance.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public List<Store> findAll(){
        return storeRepository.findAll();
    }

    public Store create(Store store){
        return storeRepository.save(store);
    }

    public Store findByUsername(String username) {
        return storeRepository.findByUsername(username);
    }
}
