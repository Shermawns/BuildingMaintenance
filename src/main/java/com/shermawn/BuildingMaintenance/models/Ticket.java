package com.shermawn.BuildingMaintenance.models;

import com.shermawn.BuildingMaintenance.dto.stores.ResponseStoreDTO;
import com.shermawn.BuildingMaintenance.models.enums.RolePriority;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "ticketId")
@Entity
@Table(name = "tb_ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long ticketId;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "trilogger_id")
    private Trilogger trilogger;

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
    private LocalDate createdDate = LocalDate.now();
    private LocalDate deadline;

}
