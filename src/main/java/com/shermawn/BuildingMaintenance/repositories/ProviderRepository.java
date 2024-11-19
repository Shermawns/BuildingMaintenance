package com.shermawn.BuildingMaintenance.repositories;

import com.shermawn.BuildingMaintenance.models.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
}
