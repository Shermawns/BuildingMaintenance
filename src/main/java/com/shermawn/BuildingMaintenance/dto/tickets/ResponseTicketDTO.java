package com.shermawn.BuildingMaintenance.dto.tickets;

import com.shermawn.BuildingMaintenance.models.Provider;
import com.shermawn.BuildingMaintenance.models.Store;
import com.shermawn.BuildingMaintenance.models.Ticket;
import com.shermawn.BuildingMaintenance.models.Trilogger;
import com.shermawn.BuildingMaintenance.models.enums.RolePriority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
        BeanUtils.copyProperties(ticket, this);
    }

}
