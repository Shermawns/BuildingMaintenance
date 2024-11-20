package com.shermawn.BuildingMaintenance.repositories;

import com.shermawn.BuildingMaintenance.models.Provider;
import com.shermawn.BuildingMaintenance.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("select ticket from Ticket ticket where ticket.trilogger.username =: username")
    List<Ticket> findByUsername(@Param("username")String username);
}
