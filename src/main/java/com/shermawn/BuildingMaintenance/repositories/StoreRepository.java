package com.shermawn.BuildingMaintenance.repositories;
import com.shermawn.BuildingMaintenance.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
