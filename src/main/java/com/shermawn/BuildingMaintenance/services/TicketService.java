package com.shermawn.BuildingMaintenance.services;

import com.shermawn.BuildingMaintenance.dto.TicketTrilogger.TicketTriRequest;
import com.shermawn.BuildingMaintenance.dto.tickets.RequestTicketDTO;
import com.shermawn.BuildingMaintenance.dto.tickets.ResponseTicketDTO;
import com.shermawn.BuildingMaintenance.models.Provider;
import com.shermawn.BuildingMaintenance.models.Store;
import com.shermawn.BuildingMaintenance.models.Ticket;
import com.shermawn.BuildingMaintenance.models.Trilogger;
import com.shermawn.BuildingMaintenance.models.enums.RolePriority;
import com.shermawn.BuildingMaintenance.models.enums.TicketStatus;
import com.shermawn.BuildingMaintenance.repositories.ProviderRepository;
import com.shermawn.BuildingMaintenance.repositories.StoreRepository;
import com.shermawn.BuildingMaintenance.repositories.TicketRepository;
import com.shermawn.BuildingMaintenance.repositories.TriloggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository repository;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private TriloggerRepository triloggerRepository;

    @Autowired
    private ProviderRepository providerRepository;


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
        ticket.setService(requestTicketDTO.getService());

        return repository.save(ticket);
    }


    //Ticket that only the trilloger can make changes
    public Ticket createTri(TicketTriRequest ticketTriRequest) {

        Ticket ticket = repository.findById(ticketTriRequest.getTicketId())
                .orElseThrow(() -> new RuntimeException("Ticket not found with ID: " + ticketTriRequest.getTicketId()));

        Trilogger trilogger = triloggerRepository.findByUsername(ticketTriRequest.getTrilogger())
                .orElseThrow(() -> new RuntimeException("Trilogger not found with username: " + ticketTriRequest.getTrilogger()));

        Provider provider = providerRepository.findByUsername(ticketTriRequest.getProvider())
                .orElseThrow(() -> new RuntimeException("Provider not found with username: " + ticketTriRequest.getProvider()));

        ticket.setTrilogger(trilogger);
        ticket.setProvider(provider);
        ticket.setDeadline(ticketTriRequest.getDeadline());
        ticket.setPriority(ticketTriRequest.getPriority() != null ? ticketTriRequest.getPriority() : RolePriority.LOW);
        ticket.setStatus(ticketTriRequest.getStatus() != null ? ticketTriRequest.getStatus() : TicketStatus.OPEN);
        ticket.setService(ticketTriRequest.getService());

        return repository.save(ticket);
    }



}
