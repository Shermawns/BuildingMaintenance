package com.shermawn.BuildingMaintenance.dto.TicketTrilogger;

import com.shermawn.BuildingMaintenance.models.Provider;
import com.shermawn.BuildingMaintenance.models.Ticket;
import com.shermawn.BuildingMaintenance.models.Trilogger;
import com.shermawn.BuildingMaintenance.models.enums.RolePriority;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
public class TicketTriRequest {
    private Long ticketId;
    private String trilogger;
    private String provider;
    private LocalDate deadline;
    private RolePriority priority;

    public TicketTriRequest(Ticket ticketId, Trilogger trilogger, Provider provider, LocalDate deadline, RolePriority priority) {
        this.ticketId = ticketId.getTicketId();
        this.trilogger = trilogger.getUsername();
        this.provider = provider.getUsername();
        this.deadline = deadline;
        this.priority = priority = RolePriority.LOW;
    }
}
