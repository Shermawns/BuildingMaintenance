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
public class ResponseStoreDTO {
    private String username;
    private String cnpj;

}
