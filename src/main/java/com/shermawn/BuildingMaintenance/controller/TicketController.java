package com.shermawn.BuildingMaintenance.controller;
import com.shermawn.BuildingMaintenance.dto.tickets.RequestTicketDTO;
import com.shermawn.BuildingMaintenance.dto.tickets.ResponseTicketDTO;
import com.shermawn.BuildingMaintenance.dto.mapper.Mapper;
import com.shermawn.BuildingMaintenance.models.Store;
import com.shermawn.BuildingMaintenance.models.Ticket;
import com.shermawn.BuildingMaintenance.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.shermawn.BuildingMaintenance.services.TicketService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/tickets")
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

    @GetMapping(value = "/{storeUsername}")
    public ResponseEntity<List<ResponseTicketDTO>> findByUsername(@PathVariable String storeUsername) {
        List<Ticket> tickets = ticketService.findByStoreUsername(storeUsername);
        return ResponseEntity.ok().body(Mapper.toTicketDTO(tickets));
    }

    @GetMapping(value = "/{TriUsername}")
    public ResponseEntity<List<ResponseTicketDTO>> findByTriUsername(@PathVariable String triUsername){
        List<Ticket> tickets = ticketService.findByTriUsername(triUsername);
        return ResponseEntity.ok().body(Mapper.toTicketDTO(tickets));
    }


    @PostMapping(value = "/create")
    public ResponseEntity<ResponseTicketDTO> createTicket(@RequestBody @Validated RequestTicketDTO requestTicketDTO) {
        Ticket ticket = ticketService.create(requestTicketDTO);
        ResponseTicketDTO response = new ResponseTicketDTO(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}



