package com.shermawn.BuildingMaintenance.repositories;
import com.shermawn.BuildingMaintenance.models.Ticket;
import com.shermawn.BuildingMaintenance.models.Trilogger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TriloggerRepository extends JpaRepository<Trilogger, Long> {
    Optional<Trilogger> findByUsername(String username);
}
