package com.shermawn.BuildingMaintenance.dto.provider;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RequestProviderDTO {

    @NotBlank
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String username;

    @NotBlank
    private String password;

    @NotNull
    @Size(min = 14)
    private String cnpj;

    private LocalDate createdDate;

}
