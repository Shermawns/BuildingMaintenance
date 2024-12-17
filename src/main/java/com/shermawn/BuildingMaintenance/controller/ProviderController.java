package com.shermawn.BuildingMaintenance.controller;

import com.shermawn.BuildingMaintenance.dto.mapper.Mapper;
import com.shermawn.BuildingMaintenance.dto.provider.RequestProviderDTO;
import com.shermawn.BuildingMaintenance.dto.provider.ResponseProviderDTO;
import com.shermawn.BuildingMaintenance.dto.stores.ResponseStoreDTO;
import com.shermawn.BuildingMaintenance.models.Provider;
import com.shermawn.BuildingMaintenance.models.Store;
import com.shermawn.BuildingMaintenance.services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/providers")
public class ProviderController {

    @Autowired
    private ProviderService providerService;


    @PostMapping(value = "/create")
    public ResponseEntity<ResponseProviderDTO> create(@RequestBody @Validated RequestProviderDTO requestProviderDTO){
        Provider provider = Mapper.toRequestProvider(requestProviderDTO);

        Provider result = providerService.create(provider);

        ResponseProviderDTO responseProviderDTO = Mapper.toResposeProvider(result);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseProviderDTO);

    }
    @GetMapping
    public ResponseEntity<List<ResponseProviderDTO>> findAll(){
        List<Provider> result = providerService.findAll();
        return ResponseEntity.ok().body(Mapper.listResponseProviderDTO(result));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ResponseProviderDTO> update(@PathVariable Long id, @RequestBody Provider provider){
        Provider result = providerService.updateProvider(id, provider);
        return ResponseEntity.status(HttpStatus.CREATED).body(Mapper.toResposeProvider(result));
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        providerService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("User "+id+ " deleted successfully");
    }

}
