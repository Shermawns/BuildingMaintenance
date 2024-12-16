package com.shermawn.BuildingMaintenance.controller;
import com.shermawn.BuildingMaintenance.dto.mapper.Mapper;
import com.shermawn.BuildingMaintenance.dto.triloggers.RequestTriloggerDTO;
import com.shermawn.BuildingMaintenance.dto.triloggers.ResponseTriloggerDTO;
import com.shermawn.BuildingMaintenance.models.Trilogger;
import com.shermawn.BuildingMaintenance.services.TriloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/triloggers")
public class TriloggerController {

    @Autowired
    private TriloggerService triloggerService;


    @PostMapping(value = "/create")
    public ResponseEntity<ResponseTriloggerDTO> create(@RequestBody RequestTriloggerDTO requestTriDTO){
        Trilogger trilogger = Mapper.toTriDTO(requestTriDTO);

        Trilogger result = triloggerService.create(trilogger);

        ResponseTriloggerDTO responseTriloggerDTO = Mapper.toResponseTriDTO(result);

        return ResponseEntity.ok().body(responseTriloggerDTO);

    }

    @GetMapping
    public ResponseEntity<List<Trilogger>> findAll(){
        List<Trilogger> users = triloggerService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @DeleteMapping
    public void deleteById(@PathVariable Long id){
        triloggerService.delete(id);
    }
}
