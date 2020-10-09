package pl.coderslab.medical_devices_query_system.controllers.project.managerScope;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.medical_devices_query_system.exceptions.ElementNotFoundException;
import pl.coderslab.medical_devices_query_system.domain.model.project.Project;
import pl.coderslab.medical_devices_query_system.services.ProjectService;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/project")
public class ManagerRemoveProjectController {

    private final ProjectService projectService;

    @PostMapping("/remove")
    public String removeProject(@RequestParam long id) {
        Optional<Project> project = projectService.findProjectByActiveAndProjectId(id);
        if (!project.isPresent()) {
            throw new ElementNotFoundException("Nie odnaleziono projektu o id" + id);
        }
        projectService.deleteProject(project.get());
        return "redirect:/project/list";
    }
}
