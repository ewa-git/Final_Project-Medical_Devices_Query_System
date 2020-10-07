package pl.coderslab.medical_devices_query_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.medical_devices_query_system.model.project.Project;

import java.util.List;
import java.util.Optional;


public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p FROM Project p WHERE p.active = true AND p.manager.id = ?1")
    List<Project> findAllByActiveAndManagerId(long id);

    @Query("SELECT p FROM Project p WHERE p.active = true AND p.id = ?1")
    Optional<Project> findProjectByActiveAndProjectId(long projectId);

    @Query("SELECT p FROM Project p WHERE p.status = ?1 AND p.manager.id = ?2")
    List<Project> findAllByStatusAndManagerId(String status, long id);

    @Query("SELECT p FROM Project p WHERE p.status = ?1")
    List<Project> findAllByStatus(String status);

}
