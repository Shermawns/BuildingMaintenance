package com.shermawn.BuildingMaintenance.dto.stores;

import com.shermawn.BuildingMaintenance.models.Store;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestStoreDTO {
    private String username;
    private String password;
    private String cnpj;


    public RequestStoreDTO(Store store) {
        username = store.getUsername();
        password = store.getPassword();
        cnpj = store.getCnpj();
    }
}
