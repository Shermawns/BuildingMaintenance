package com.shermawn.BuildingMaintenance.models.PK;

import com.shermawn.BuildingMaintenance.models.Store;
import com.shermawn.BuildingMaintenance.models.Trilogger;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class TicketPK {
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "trilogger_id")
    private Trilogger trilogger;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketPK ticketPK = (TicketPK) o;
        return Objects.equals(store, ticketPK.store) && Objects.equals(trilogger, ticketPK.trilogger);
    }

    @Override
    public int hashCode() {
        return Objects.hash(store, trilogger);
    }
}
