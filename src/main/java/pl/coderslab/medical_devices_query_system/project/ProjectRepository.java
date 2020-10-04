package pl.coderslab.medical_devices_query_system.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p FROM Project p WHERE p.active = true AND p.manager.id = ?1")
    List<Project> findAllByActiveAndManagerId(long id);

    @Query("SELECT p FROM Project p WHERE p.active = true AND p.id = ?1")
    Optional<Project> findProjectByActiveAndProjectId(long projectId);

   /* @Query("")
    List<Project> findAllByStatusAAndManagerIAnd*/
}
