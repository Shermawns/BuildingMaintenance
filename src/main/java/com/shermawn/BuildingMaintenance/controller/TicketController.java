package com.shermawn.BuildingMaintenance.controller;

import com.shermawn.BuildingMaintenance.dto.tickets.RequestTicketDTO;
import com.shermawn.BuildingMaintenance.dto.tickets.ResponseTicketDTO;
import com.shermawn.BuildingMaintenance.dto.mapper.Mapper;
import com.shermawn.BuildingMaintenance.models.Store;
import com.shermawn.BuildingMaintenance.models.Ticket;
import com.shermawn.BuildingMaintenance.models.enums.RolePriority;
import com.shermawn.BuildingMaintenance.repositories.StoreRepository;
import com.shermawn.BuildingMaintenance.repositories.TicketRepository;
import com.shermawn.BuildingMaintenance.services.StoreService;
import com.shermawn.BuildingMaintenance.services.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private StoreRepository repository;

    @GetMapping
    public ResponseEntity<List<ResponseTicketDTO>> findAll(){
        List<Ticket> tickets = ticketService.findAll();
        return ResponseEntity.ok().body(Mapper.toTicketDTO(tickets));
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<List<ResponseTicketDTO>> findByUsername(@PathVariable String username){
        List<Ticket> tickets = ticketService.findByUsername(username);
        return ResponseEntity.ok().body(Mapper.toTicketDTO(tickets));
    }

    


}
