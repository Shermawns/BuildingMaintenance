package com.shermawn.BuildingMaintenance.dto.stores;

import com.shermawn.BuildingMaintenance.models.Store;
import lombok.*;

@Data
public class RequestStoreDTO {
    private String username;
    private String password;
    private String cnpj;
}
