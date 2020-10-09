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
public class ManagerDoneProjectsListController {

    private final ProjectService projectService;
    private final UserService userService;

    @RequestMapping("/list/done")
    public String showDoneProjectList(Model model, Principal principal) {
        User manager = userService.findUserByEmail(principal.getName());
        List<Project> listOfProjectsCompleted = projectService.findAllByStatusAndManagerId(Status.COMPLETED.toString(), manager.getId());
        if (listOfProjectsCompleted.isEmpty()) {
            model.addAttribute("message", "Lista ukończonych projektów jest pusta");
        }
        model.addAttribute("projects", listOfProjectsCompleted);
        return "project/listProjectCompleted";
    }
}
