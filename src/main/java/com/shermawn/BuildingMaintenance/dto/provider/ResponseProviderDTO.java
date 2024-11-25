package com.shermawn.BuildingMaintenance.dto.provider;

import com.shermawn.BuildingMaintenance.models.Provider;
import lombok.Data;

@Data
public class ResponseProviderDTO {
    private String username;
    private String cnpj;

    public ResponseProviderDTO(Provider provider) {
        username = provider.getUsername();
        cnpj = provider.getCnpj();
    }
}
