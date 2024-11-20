package com.shermawn.BuildingMaintenance.dto.tickets;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestTicketDTO {
    @NotNull
    private String storeName;

    @NotNull
    private String title;

    @NotNull
    private String description;
}
