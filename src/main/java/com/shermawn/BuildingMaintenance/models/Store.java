package com.shermawn.BuildingMaintenance.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    private String username;

    @Column(unique = false, nullable = false, length = 200)
    private String password;

    @Column(unique = true, nullable = false, length = 100)
    private String cnpj;

    @Column(name = "created_date")
    private LocalDate createdDate;

}
