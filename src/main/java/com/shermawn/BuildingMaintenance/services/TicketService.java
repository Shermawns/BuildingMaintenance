package com.shermawn.BuildingMaintenance.services;

import com.shermawn.BuildingMaintenance.dto.tickets.RequestTicketDTO;
import com.shermawn.BuildingMaintenance.models.Store;
import com.shermawn.BuildingMaintenance.models.Ticket;
import com.shermawn.BuildingMaintenance.models.Trilogger;
import com.shermawn.BuildingMaintenance.repositories.StoreRepository;
import com.shermawn.BuildingMaintenance.repositories.TicketRepository;
import com.shermawn.BuildingMaintenance.repositories.TriloggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository repository;
    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    TriloggerRepository triloggerRepository;

    public List<Ticket> findAll(){
        return repository.findAll();
    }

    public List<Ticket> findByUsername(String username){
        return repository.findByUsername(username);
    }

    public Ticket create(RequestTicketDTO requestTicketDTO){
        RequestTicketDTO dto = new RequestTicketDTO();
        Store store = storeRepository.findById(dto.getStoreId()).orElseThrow(() -> new RuntimeException("Store not found with ID: " + dto.getStoreId()));

        Ticket ticket = new Ticket();
        ticket.setStore(store);
        ticket.setTitle(dto.getTitle());
        ticket.setDescription(dto.getDescription());

        return repository.save(ticket);
    }
}
