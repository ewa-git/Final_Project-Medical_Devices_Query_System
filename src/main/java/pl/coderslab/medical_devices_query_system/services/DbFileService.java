package pl.coderslab.medical_devices_query_system.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.medical_devices_query_system.model.dbFIle.DbFile;
import pl.coderslab.medical_devices_query_system.repositories.DbFileRepository;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class DbFileService {

    private final DbFileRepository dbFileRepository;

    public DbFile findDbFileByProjectId(long id){
        return dbFileRepository.findDbFileByProjectId(id);
    }
}
