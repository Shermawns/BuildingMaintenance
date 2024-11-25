package com.shermawn.BuildingMaintenance.services;

import com.shermawn.BuildingMaintenance.dto.tickets.RequestTicketDTO;
import com.shermawn.BuildingMaintenance.models.Store;
import com.shermawn.BuildingMaintenance.models.Ticket;
import com.shermawn.BuildingMaintenance.repositories.StoreRepository;
import com.shermawn.BuildingMaintenance.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository repository;
    @Autowired
    private StoreRepository storeRepository;

    public List<Ticket> findAll(){
        return repository.findAll();
    }

    public List<Ticket> findByStoreUsername(String username){
        return repository.findByStoreUsername(username);
    }
    public List<Ticket> findByTriUsername(String username){
        return repository.findByTriUsername(username);
    }

    public Ticket create(RequestTicketDTO requestTicketDTO) {
        Store store = storeRepository.findById(requestTicketDTO.getStoreId())
                .orElseThrow(() -> new RuntimeException("Store not found with ID: " + requestTicketDTO.getStoreId()));

        Ticket ticket = new Ticket();
        ticket.setStore(store);
        ticket.setTitle(requestTicketDTO.getTitle());
        ticket.setDescription(requestTicketDTO.getDescription());

        return repository.save(ticket);
    }
}
