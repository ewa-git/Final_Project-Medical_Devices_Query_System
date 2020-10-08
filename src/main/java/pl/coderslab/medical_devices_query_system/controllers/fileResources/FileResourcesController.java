package pl.coderslab.medical_devices_query_system.controllers.fileResources;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.medical_devices_query_system.customization.exceptions.exception.ElementNotFoundException;
import pl.coderslab.medical_devices_query_system.model.dbFIle.DbFile;
import pl.coderslab.medical_devices_query_system.model.dbFIle.DbFileList;
import pl.coderslab.medical_devices_query_system.model.project.Project;
import pl.coderslab.medical_devices_query_system.repositories.DbFileRepository;
import pl.coderslab.medical_devices_query_system.services.ProjectService;

import java.io.IOException;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/files")
public class FileResourcesController {

    private final DbFileList dbFileList;
    private final ProjectService projectService;
    private final DbFileRepository dbFileRepository;

    @PostMapping("/upload/mailAttachments")
    public String uploadAttachments(@RequestPart(name = "file") MultipartFile file,
                                    @RequestParam long idProject) throws IOException {
        DbFile dbFile = new DbFile();
        dbFile.setContentType(file.getContentType());
        dbFile.setOriginalFileName(file.getOriginalFilename());
        dbFile.setSize(file.getSize());
        dbFile.setData(file.getBytes());
        Optional<Project> projectOptional = projectService.findProjectByActiveAndProjectId(idProject);
        if(!projectOptional.isPresent()){
            throw new ElementNotFoundException("Nie odnaleziono projektu o id" + idProject);
        }
        dbFile.setProject(projectOptional.get());
        dbFileRepository.save(dbFile);

//        dbFileList.addToFileList(dbFile);
        return "redirect:/engineer/project/details/" + projectOptional.get().getId();

    }

}
