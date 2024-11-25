package com.shermawn.BuildingMaintenance.dto.triloggers;
import com.shermawn.BuildingMaintenance.models.Trilogger;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseTriloggerDTO {
    private String username;

    public ResponseTriloggerDTO(Trilogger trilogger) {
        username = trilogger.getUsername();
    }
}
