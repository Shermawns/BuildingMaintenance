package com.shermawn.BuildingMaintenance.dto.tickets;

import com.shermawn.BuildingMaintenance.models.Store;
import com.shermawn.BuildingMaintenance.models.Ticket;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestTicketDTO {
    private Long storeId;
    private String title;
    private String description;

    public RequestTicketDTO(Ticket ticket) {
        storeId = ticket.getStore().getId();
        title = ticket.getTitle();
        description = ticket.getDescription();
    }
}
