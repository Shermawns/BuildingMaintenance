package com.shermawn.BuildingMaintenance.dto.triloggers;

import com.shermawn.BuildingMaintenance.models.Store;
import com.shermawn.BuildingMaintenance.models.Trilogger;
import lombok.Getter;

@Getter
public class ResponseTriloggerDTO {
    private String username;

    public ResponseTriloggerDTO(Trilogger trilogger) {
        username = trilogger.getUsername();
    }
}
