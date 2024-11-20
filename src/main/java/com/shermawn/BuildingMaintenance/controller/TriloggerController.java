package com.shermawn.BuildingMaintenance.controller;

import com.shermawn.BuildingMaintenance.dto.mapper.Mapper;
import com.shermawn.BuildingMaintenance.dto.tickets.ResponseTicketDTO;
import com.shermawn.BuildingMaintenance.models.Ticket;
import com.shermawn.BuildingMaintenance.models.Trilogger;
import com.shermawn.BuildingMaintenance.services.TriloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/triloggers")
public class TriloggerController {

    @Autowired
    private TriloggerService triloggerService;


    @PostMapping
    public ResponseEntity<Trilogger> create(@RequestBody Trilogger trilogger){
        Trilogger trilogger1 = triloggerService.create(trilogger);
        return ResponseEntity.ok().body(trilogger1);
    }

    @GetMapping
    public ResponseEntity<List<Trilogger>> findAll(){
        List<Trilogger> users = triloggerService.findAll();
        return ResponseEntity.ok().body(users);
    }
}
