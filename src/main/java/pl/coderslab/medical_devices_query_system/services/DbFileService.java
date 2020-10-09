package pl.coderslab.medical_devices_query_system.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.medical_devices_query_system.model.dbFIle.DbFile;
import pl.coderslab.medical_devices_query_system.repositories.DbFileRepository;

import javax.transaction.Transactional;
import java.io.IOException;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class DbFileService {

    private final DbFileRepository dbFileRepository;

    public DbFile saveFileFromWebsite(MultipartFile file) throws IOException {
        DbFile dbFile = new DbFile();
        dbFile.setContentType(file.getContentType());
        dbFile.setOriginalFileName(file.getOriginalFilename());
        dbFile.setSize(file.getSize());
        dbFile.setData(file.getBytes());
        dbFileRepository.save(dbFile);
        log.debug("Załącznik ze strony dodany do bazy danych", dbFile);
        return dbFile;
    }

    public DbFile findDbFileById(long id) {
        return dbFileRepository.findDbFileById(id);
    }

    public void deleteFile(DbFile dbFile) {
        dbFileRepository.deleteById(dbFile.getId());
        log.debug("Załącznik usunięty z bazy danych", dbFile);
    }

}
