package pl.coderslab.medical_devices_query_system.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.medical_devices_query_system.domain.model.dbFIle.DbFile;

public interface DbFileRepository extends JpaRepository<DbFile, Long> {

    DbFile findDbFileById(long id);
}
