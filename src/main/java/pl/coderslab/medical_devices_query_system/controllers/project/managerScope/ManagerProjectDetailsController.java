package pl.coderslab.medical_devices_query_system.controllers.project.managerScope;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.medical_devices_query_system.exceptions.ElementNotFoundException;
import pl.coderslab.medical_devices_query_system.domain.model.project.Project;
import pl.coderslab.medical_devices_query_system.services.ProjectService;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/project")
public class ManagerProjectDetailsController {

    private final ProjectService projectService;

    @RequestMapping("/details/{id}")
    public String projectDetails(@PathVariable long id, Model model) {
        Optional<Project> project = projectService.findProjectByActiveAndProjectId(id);
        if (!project.isPresent()) {
            throw new ElementNotFoundException("Nie odnaleziono projektu o id" + id);
        }
        model.addAttribute("project", project.get());
        return "project/details";
    }

}
