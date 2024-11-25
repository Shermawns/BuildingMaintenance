package com.shermawn.BuildingMaintenance.dto.tickets;
import com.shermawn.BuildingMaintenance.models.Provider;
import com.shermawn.BuildingMaintenance.models.Store;
import com.shermawn.BuildingMaintenance.models.Ticket;
import com.shermawn.BuildingMaintenance.models.Trilogger;
import com.shermawn.BuildingMaintenance.models.enums.RolePriority;
import lombok.*;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTicketDTO {

    private Long ticketId;
    private Store store;
    private Trilogger trilogger;
    private Provider provider;
    private String title;
    private String description;
    private RolePriority priority;
    private LocalDate createdDate;
    private LocalDate deadline;

    public ResponseTicketDTO(Ticket ticket) {
        ticketId = ticket.getTicketId();
        store = ticket.getStore();
        trilogger = ticket.getTrilogger();
        provider = ticket.getProvider();
        title = ticket.getTitle();
        description = ticket.getDescription();
        priority = ticket.getPriority();
        createdDate = ticket.getCreatedDate();
        deadline = ticket.getDeadline();

    }

}
