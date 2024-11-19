package com.shermawn.BuildingMaintenance.repositories;

import com.shermawn.BuildingMaintenance.models.Provider;
import com.shermawn.BuildingMaintenance.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
