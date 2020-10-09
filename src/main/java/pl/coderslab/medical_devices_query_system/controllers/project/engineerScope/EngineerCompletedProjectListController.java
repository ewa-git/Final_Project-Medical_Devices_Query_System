package pl.coderslab.medical_devices_query_system.controllers.project.engineerScope;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.medical_devices_query_system.domain.model.project.Project;
import pl.coderslab.medical_devices_query_system.domain.model.project.Status;
import pl.coderslab.medical_devices_query_system.domain.model.user.User;
import pl.coderslab.medical_devices_query_system.services.ProjectService;
import pl.coderslab.medical_devices_query_system.services.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/engineer")
@RequiredArgsConstructor
public class EngineerCompletedProjectListController {

    private final ProjectService projectService;
    private final UserService userService;

    @RequestMapping("/completed")
    public String showCompletedProjects(Principal principal, Model model) {
        User engineer = userService.findUserByEmail(principal.getName());
        List<Project> listOfProjects = projectService.findAllByStatusAndEngineerId(Status.COMPLETED.toString(), engineer.getId());
        if (listOfProjects.isEmpty()) {
            model.addAttribute("message", "Nie ukończyłeś jeszcze żadnego projektu");
            return "project/engineerListOfProjectInProgress";
        }
        model.addAttribute("projects", listOfProjects);
        return "project/engineerCompletedProjects";
    }
}
