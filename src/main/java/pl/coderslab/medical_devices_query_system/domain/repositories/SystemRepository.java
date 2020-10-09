package pl.coderslab.medical_devices_query_system.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.medical_devices_query_system.domain.model.system.System;

import java.util.List;

public interface SystemRepository extends JpaRepository<System, Long> {
    @Query("SELECT s FROM System s WHERE s.active = true")
    List<System> findAllByActive();

    @Query("SELECT s FROM System s WHERE s.active = false")
    List<System> findAllByNotActive();

}
