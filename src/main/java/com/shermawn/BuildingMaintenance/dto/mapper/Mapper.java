package com.shermawn.BuildingMaintenance.dto.mapper;
import com.shermawn.BuildingMaintenance.dto.provider.RequestProviderDTO;
import com.shermawn.BuildingMaintenance.dto.provider.ResponseProviderDTO;
import com.shermawn.BuildingMaintenance.dto.stores.RequestStoreDTO;
import com.shermawn.BuildingMaintenance.dto.stores.ResponseStoreDTO;
import com.shermawn.BuildingMaintenance.dto.tickets.ResponseTicketDTO;
import com.shermawn.BuildingMaintenance.dto.triloggers.RequestTriloggerDTO;
import com.shermawn.BuildingMaintenance.dto.triloggers.ResponseTriloggerDTO;
import com.shermawn.BuildingMaintenance.models.Provider;
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
                    t.getDescription(), t.getService() ,t.getStatus(),t.getPriority(),t.getCreatedDate(), t.getDeadline());

            dtos.add(responseTicketDTO);
        }
        return dtos;
    }

    public static ResponseTicketDTO toResponseTicketDto(Ticket ticket){
        ResponseTicketDTO responseTicketDTO = new ResponseTicketDTO();
        responseTicketDTO.setStore(ticket.getStore());
        responseTicketDTO.setTitle(ticket.getTitle());
        responseTicketDTO.setDescription(ticket.getDescription());
        responseTicketDTO.setCreatedDate(ticket.getCreatedDate());

        return responseTicketDTO;
    }


    public static Store toRequestStoreDTO(RequestStoreDTO requestStoreDTO){
        Store store = new Store();
        store.setUsername(requestStoreDTO.getUsername());
        store.setPassword(requestStoreDTO.getPassword());
        store.setCnpj(requestStoreDTO.getCnpj());
        store.setCreatedDate(requestStoreDTO.getCreatedDate());

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
        responseStoreDTO.setCreatedDate(s.getCreatedDate());

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

        responseTriloggerDTO.setCreatedDate(requestTriloggerDTO.getCreatedDate());

        return responseTriloggerDTO;
    }

    public static List<ResponseProviderDTO> listResponseProviderDTO(List<Provider> providers){
        List<ResponseProviderDTO> list = new ArrayList<>();

        for (Provider x : providers){
            ResponseProviderDTO responseProviderDTO = new ResponseProviderDTO(x.getUsername(), x.getCnpj(), x.getCreatedDate());
            list.add(responseProviderDTO);
        }
        return list;
    }

    public static Provider toRequestProvider(RequestProviderDTO requestProviderDTO){
        Provider provider = new Provider();
        provider.setUsername(requestProviderDTO.getUsername());
        provider.setPassword(requestProviderDTO.getPassword());
        provider.setCnpj(requestProviderDTO.getCnpj());

        return provider;
    }

    public static ResponseProviderDTO toResposeProvider(Provider s){
        ResponseProviderDTO responseProviderDTO = new ResponseProviderDTO();

        responseProviderDTO.setUsername(s.getUsername());
        responseProviderDTO.setCnpj(s.getCnpj());
        responseProviderDTO.setCreatedDate(s.getCreatedDate());

        return responseProviderDTO;
    }

}

