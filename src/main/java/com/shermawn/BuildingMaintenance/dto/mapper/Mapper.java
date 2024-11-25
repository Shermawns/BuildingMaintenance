package com.shermawn.BuildingMaintenance.dto.mapper;
import com.shermawn.BuildingMaintenance.dto.stores.RequestStoreDTO;
import com.shermawn.BuildingMaintenance.dto.stores.ResponseStoreDTO;
import com.shermawn.BuildingMaintenance.dto.tickets.ResponseTicketDTO;
import com.shermawn.BuildingMaintenance.dto.triloggers.RequestTriloggerDTO;
import com.shermawn.BuildingMaintenance.dto.triloggers.ResponseTriloggerDTO;
import com.shermawn.BuildingMaintenance.models.Store;
import com.shermawn.BuildingMaintenance.models.Ticket;
import com.shermawn.BuildingMaintenance.models.Trilogger;

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
            ResponseStoreDTO responseStoreDTO = new ResponseStoreDTO(y.getUsername(), y.getCnpj(), y.getCreatedDate());
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

    public static Trilogger toTriDTO(RequestTriloggerDTO trilogger1) {
        Trilogger trilogger = new Trilogger();
        trilogger.setUsername(trilogger1.getUsername());
        trilogger.setPassword(trilogger1.getPassword());

        return trilogger;
    }

    public static ResponseTriloggerDTO toResponseTriDTO (Trilogger requestTriloggerDTO){
        ResponseTriloggerDTO responseTriloggerDTO = new ResponseTriloggerDTO();

        responseTriloggerDTO.setUsername(requestTriloggerDTO.getUsername());

        return responseTriloggerDTO;
    }
}

