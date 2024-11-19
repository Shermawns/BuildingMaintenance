package com.shermawn.BuildingMaintenance.models;

import com.shermawn.BuildingMaintenance.models.PK.TicketPK;
import com.shermawn.BuildingMaintenance.models.enums.RolePriority;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "ticket")
@Entity
@Table(name = "tb_ticket")
public class Ticket {

    @EmbeddedId
    private TicketPK ticket = new TicketPK();

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false, length = 200)
    private String description;
    @Enumerated(EnumType.STRING)
    private RolePriority priority = RolePriority.LOW;
    @Column(name = "created_date")
    private LocalDate createdDate;
    private LocalDate deadline;

}
