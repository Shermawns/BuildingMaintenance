package com.shermawn.BuildingMaintenance.controller;

import com.shermawn.BuildingMaintenance.dto.mapper.Mapper;
import com.shermawn.BuildingMaintenance.dto.stores.ResponseStoreDTO;
import com.shermawn.BuildingMaintenance.dto.stores.RequestStoreDTO;
import com.shermawn.BuildingMaintenance.models.Store;
import com.shermawn.BuildingMaintenance.services.StoreService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping
    public ResponseEntity<ResponseStoreDTO> create(@RequestBody RequestStoreDTO requestDTO){
        Store store = Mapper.toRequestStoreDTO(requestDTO);

        Store result = storeService.create(store);

        ResponseStoreDTO responseStoreDTO = Mapper.toResponseStoreDTO(result);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseStoreDTO);
    }

    @GetMapping
    public ResponseEntity<List<ResponseStoreDTO>> findAll(){
        List<Store> result = storeService.findAll();
        return ResponseEntity.ok().body(Mapper.toStoreDTO(result));
    }
}
