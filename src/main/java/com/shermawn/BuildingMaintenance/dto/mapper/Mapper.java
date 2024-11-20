package com.shermawn.BuildingMaintenance.dto.mapper;

import com.shermawn.BuildingMaintenance.dto.stores.RequestStoreDTO;
import com.shermawn.BuildingMaintenance.dto.stores.ResponseStoreDTO;
import com.shermawn.BuildingMaintenance.dto.tickets.RequestTicketDTO;
import com.shermawn.BuildingMaintenance.dto.tickets.ResponseTicketDTO;
import com.shermawn.BuildingMaintenance.models.Store;
import com.shermawn.BuildingMaintenance.models.Ticket;
import com.shermawn.BuildingMaintenance.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public static List<ResponseTicketDTO> toTicketDTO(List<Ticket> ticket){
        List<ResponseTicketDTO> dtos = new ArrayList<>();

        for (Ticket t : ticket){
            ResponseTicketDTO responseTicketDTO = new ResponseTicketDTO(t.getTicketId(),t.getStore(),
                    t.getTrilogger(), t.getProvider(), t.getTitle(),
                    t.getDescription(), t.getPriority(), t.getCreatedDate(), t.getDeadline());

            dtos.add(responseTicketDTO);
        }
        return dtos;
    }

    public static ResponseTicketDTO toResponseTicketDto(Ticket ticket){
        ResponseTicketDTO responseTicketDTO = new ResponseTicketDTO();

        responseTicketDTO.setStore(ticket.getStore());
        responseTicketDTO.setTitle(ticket.getTitle());
        responseTicketDTO.setDescription(ticket.getDescription());

        return responseTicketDTO;
    }


    public static Store toRequestStoreDTO(RequestStoreDTO requestStoreDTO){
        Store store = new Store();
        store.setUsername(requestStoreDTO.getUsername());
        store.setPassword(requestStoreDTO.getPassword());
        store.setCnpj(requestStoreDTO.getCnpj());

        return store;
    }

    public static List<ResponseStoreDTO> toStoreDTO(List<Store> stores){
        List<ResponseStoreDTO> x = new ArrayList<>();

        for (Store y : stores){
            ResponseStoreDTO responseStoreDTO = new ResponseStoreDTO(y.getUsername(), y.getCnpj(), LocalDate.now());
            x.add(responseStoreDTO);
        }
        return x;
    }

    public static ResponseStoreDTO toResponseStoreDTO(Store s){
        ResponseStoreDTO responseStoreDTO = new ResponseStoreDTO();

        responseStoreDTO.setUsername(s.getUsername());
        responseStoreDTO.setCnpj(s.getCnpj());

        return responseStoreDTO;
    }

}

