package com.shermawn.BuildingMaintenance.controller;
import com.shermawn.BuildingMaintenance.dto.mapper.Mapper;
import com.shermawn.BuildingMaintenance.dto.stores.ResponseStoreDTO;
import com.shermawn.BuildingMaintenance.dto.stores.RequestStoreDTO;
import com.shermawn.BuildingMaintenance.models.Store;
import com.shermawn.BuildingMaintenance.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping(value = "/create")
    public ResponseEntity<ResponseStoreDTO> create(@RequestBody @Validated RequestStoreDTO requestDTO){
        Store store = Mapper.toRequestStoreDTO(requestDTO);

        Store result = storeService.create(store);

        ResponseStoreDTO responseStoreDTO = Mapper.toResponseStoreDTO(result);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseStoreDTO);
    }
    @GetMapping(value = "/{username}")
    public ResponseEntity<ResponseStoreDTO> findByUsername(@PathVariable String username){
        Store store = storeService.findByUsername(username);
        return ResponseEntity.ok().body(Mapper.toResponseStoreDTO(store));
    }

    @GetMapping
    public ResponseEntity<List<ResponseStoreDTO>> findAll(){
        List<Store> result = storeService.findAll();
        return ResponseEntity.ok().body(Mapper.toStoreDTO(result));
    }
}
