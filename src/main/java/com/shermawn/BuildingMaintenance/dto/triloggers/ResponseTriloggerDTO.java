package com.shermawn.BuildingMaintenance.dto.triloggers;
import com.shermawn.BuildingMaintenance.models.Trilogger;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ResponseTriloggerDTO {
    private String username;
    private LocalDate createdDate;

    public ResponseTriloggerDTO(Trilogger trilogger) {
        username = trilogger.getUsername();
        createdDate = trilogger.getCreatedDate();
    }
}
