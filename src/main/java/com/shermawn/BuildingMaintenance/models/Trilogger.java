package com.shermawn.BuildingMaintenance.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_trilogger")
public class Trilogger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    private String username;

    @Column(unique = false, nullable = false, length = 200)
    private String password;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @OneToMany(mappedBy = "trilogger")
    private List<Ticket> tickets = new ArrayList<>();
}
