package com.shermawn.BuildingMaintenance.repositories;

import com.shermawn.BuildingMaintenance.models.Provider;
import com.shermawn.BuildingMaintenance.models.Store;
import com.shermawn.BuildingMaintenance.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("SELECT t FROM Ticket t WHERE t.trilogger.username = :username")
    List<Ticket> findByTriUsername(@Param("username")String username);

    @Query("SELECT t FROM Ticket t WHERE t.store.username = :username")
    List<Ticket> findByStoreUsername(@Param("username") String username);


}
