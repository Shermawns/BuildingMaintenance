package com.shermawn.BuildingMaintenance.dto.tickets;
import com.shermawn.BuildingMaintenance.models.Provider;
import com.shermawn.BuildingMaintenance.models.Store;
import com.shermawn.BuildingMaintenance.models.Ticket;
import com.shermawn.BuildingMaintenance.models.Trilogger;
import com.shermawn.BuildingMaintenance.models.enums.BuildingType;
import com.shermawn.BuildingMaintenance.models.enums.RolePriority;
import com.shermawn.BuildingMaintenance.models.enums.TicketStatus;
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
    private BuildingType service;
    private TicketStatus status;
    private RolePriority priority;
    private LocalDate createdDate;
    private LocalDate deadline;

    public ResponseTicketDTO(Ticket ticket) {
        this.ticketId = ticket.getTicketId();
        this.store = ticket.getStore();
        this.trilogger = ticket.getTrilogger();
        this.provider = ticket.getProvider();
        this.title = ticket.getTitle();
        this.description = ticket.getDescription();
        this.service = ticket.getService();
        this.status = ticket.getStatus();
        this.priority = ticket.getPriority();
        this.createdDate = ticket.getCreatedDate();
        this.deadline = ticket.getDeadline();
    }

}
