package com.shermawn.BuildingMaintenance.dto.stores;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
@Data
public class RequestStoreDTO {

    @NotBlank
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String username;

    @NotBlank
    private String password;

    @NotNull
    @Size(min = 14)
    private String cnpj;

}
