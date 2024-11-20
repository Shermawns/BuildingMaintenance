package com.shermawn.BuildingMaintenance.repositories;

import com.shermawn.BuildingMaintenance.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Store findByUsername(String username);
}
