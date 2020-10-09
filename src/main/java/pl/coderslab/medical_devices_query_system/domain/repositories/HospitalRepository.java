package pl.coderslab.medical_devices_query_system.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.medical_devices_query_system.domain.model.hospital.Hospital;

import java.util.List;
import java.util.Optional;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    @Query("SELECT h FROM Hospital h WHERE h.active = TRUE AND h.hospitalDetails.manager.id = ?1")
    List<Hospital> findAllByActiveAndManagerId(long id);

    Optional<Hospital> findHospitalById(long id);
}
