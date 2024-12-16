package com.shermawn.BuildingMaintenance.dto.provider;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ResponseProviderDTO {
    private String username;
    private String cnpj;
    private LocalDate createdDate;

    public ResponseProviderDTO(String username, String cnpj, LocalDate createdDate) {
        this.username = username;
        this.cnpj = cnpj;
        this.createdDate = createdDate;
    }

}
