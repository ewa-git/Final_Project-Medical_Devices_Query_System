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
public class EngineerProjectDetailsController {

    private final ProjectService projectService;

    @RequestMapping("/project/details/{id}")
    public String showProjectDetails(@PathVariable long id, Model model) {
        Optional<Project> projectOptional = projectService.findProjectByActiveAndProjectId(id);

        if (!projectOptional.isPresent()) {
            throw new ElementNotFoundException("Nie odnaleziono projektu o id" + id);
        }
        Project project = projectOptional.get();

        if (project.getFiles().isEmpty()) {
            model.addAttribute("emptyList", "Nie dodano załączników");
        }
        model.addAttribute("project", project);
        return "project/engineerProjectDetails";
    }
}
