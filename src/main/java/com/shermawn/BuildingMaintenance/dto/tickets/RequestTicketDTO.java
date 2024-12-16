package com.shermawn.BuildingMaintenance.dto.tickets;
import com.shermawn.BuildingMaintenance.models.enums.BuildingType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestTicketDTO {

    private Long storeId;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    private BuildingType service;
}
