package pl.coderslab.medical_devices_query_system.controllers.fileResources;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.medical_devices_query_system.customization.exceptions.exception.ElementNotFoundException;
import pl.coderslab.medical_devices_query_system.model.dbFIle.DbFile;
import pl.coderslab.medical_devices_query_system.model.project.Project;
import pl.coderslab.medical_devices_query_system.services.DbFileService;
import pl.coderslab.medical_devices_query_system.services.ProjectService;

import java.io.IOException;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/files")
public class FileResourcesController {


    private final ProjectService projectService;
    private final DbFileService dbFileService;

    @PostMapping("/upload/mailAttachments")
    public String uploadAttachments(@RequestPart(name = "file") MultipartFile file,
                                    @RequestParam long idProject,
                                    Model model) throws IOException {
        Optional<Project> projectOptional = projectService.findProjectByActiveAndProjectId(idProject);
        if (!projectOptional.isPresent()) {
            throw new ElementNotFoundException("Nie odnaleziono projektu o id" + idProject);
        }
        Project project = projectOptional.get();
        if (!file.isEmpty()) {
            DbFile dbFile = dbFileService.saveFileFromWebsite(file);
            projectService.saveAttachment(project, dbFile);
            return "redirect:/engineer/project/details/" + project.getId();
        } else {
            model.addAttribute("emptyFile", "nie wybrano pliku");
            return "redirect:/engineer/project/details/" + project.getId();
        }
    }

    @PostMapping("/delete")
    public String deleteAttachment(@RequestParam long fileId, @RequestParam long projectFileId) {
        DbFile dbFile = dbFileService.findDbFileById(fileId);

        Project project = projectService.findProjectAndFilesById(projectFileId);
        projectService.deleteAttachment(project, dbFile);
        dbFileService.deleteFile(dbFile);
        return "redirect:/engineer/project/details/" + project.getId();
    }

}
