package com.shermawn.BuildingMaintenance.dto.stores;

import com.shermawn.BuildingMaintenance.models.Store;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ResponseStoreDTO {
    private String username;
    private String cnpj;
    private LocalDate createdDate;

    public ResponseStoreDTO(String username, String cnpj, LocalDate createdDate) {
        this.username = username;
        this.cnpj = cnpj;
        this.createdDate = LocalDate.now();
    }
}
