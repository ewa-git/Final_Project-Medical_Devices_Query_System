package pl.coderslab.medical_devices_query_system.controllers.project.engineerScope;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.medical_devices_query_system.exceptions.ElementNotFoundException;
import pl.coderslab.medical_devices_query_system.domain.model.project.Project;
import pl.coderslab.medical_devices_query_system.services.ProjectService;

import java.util.Optional;

@Controller
@RequestMapping("/engineer")
@RequiredArgsConstructor
public class EngineerCompletedProjectsListController {

    private final ProjectService projectService;

    @RequestMapping("/project/completed/details/{id}")
    public String showCompletedProjectDetails(@PathVariable long id, Model model) {
        Optional<Project> project = projectService.findProjectByActiveAndProjectId(id);
        if (!project.isPresent()) {
            throw new ElementNotFoundException("Nie odnaleziono projektu o id" + id);
        }
        model.addAttribute("project", project.get());
        return "project/engineerCompletedProjectDetails";
    }
}
