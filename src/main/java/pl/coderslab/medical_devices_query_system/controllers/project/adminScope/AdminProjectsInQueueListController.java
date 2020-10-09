package pl.coderslab.medical_devices_query_system.controllers.project.adminScope;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.medical_devices_query_system.domain.model.project.Project;
import pl.coderslab.medical_devices_query_system.domain.model.project.Status;
import pl.coderslab.medical_devices_query_system.domain.model.user.Role;
import pl.coderslab.medical_devices_query_system.domain.model.user.User;
import pl.coderslab.medical_devices_query_system.services.ProjectService;
import pl.coderslab.medical_devices_query_system.services.UserService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminProjectsInQueueListController {

    private final ProjectService projectService;
    private final UserService userService;

    @ModelAttribute("engineersList")
    List<User> showEngineetsList() {
        return userService.findUserByActiveAndRole(Role.ROLE_ENGINEER.toString());
    }

    @RequestMapping("/project/queue")
    public String showProjectsToAssign(Model model) {
        List<Project> listOfProjectsToAssign = projectService.findAllByStatus(Status.REQUESTED.toString());
        if (listOfProjectsToAssign.isEmpty()) {
            model.addAttribute("message", "Brak projektów w kolejece");
        }
        model.addAttribute("project", listOfProjectsToAssign);
        return "project/listProjectsToAssign";
    }
}
