package com.shermawn.BuildingMaintenance.dto.provider;

import com.shermawn.BuildingMaintenance.models.Provider;
import com.shermawn.BuildingMaintenance.models.Store;
import lombok.Data;
import lombok.Getter;

@Data
public class ResponseProviderDTO {
    private String username;
    private String cnpj;

    public ResponseProviderDTO(Provider provider) {
        username = provider.getUsername();
        cnpj = provider.getCnpj();
    }
}
