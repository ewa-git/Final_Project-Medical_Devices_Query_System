package pl.coderslab.medical_devices_query_system.controllers.project.managerScope;

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

@RequiredArgsConstructor
@Controller
@RequestMapping("/project")
public class ManagerProjectListController {

    private final UserService userService;

    private final ProjectService projectService;

    @RequestMapping("/list")
    public String showProjectListActive(Principal principal, Model model) {
        User manager = userService.findUserByEmail(principal.getName());

        List<Project> projects = projectService.findAllByTwoStatusAndManagerId(manager.getId(),
                Status.IN_PROGRESS.toString(),
                Status.REQUESTED.toString());
        if (projects.isEmpty()) {
            model.addAttribute("message", "Nie dodano jeszcze projektów");
        }
        model.addAttribute("projects", projects);
        return "project/listProject";
    }
}
