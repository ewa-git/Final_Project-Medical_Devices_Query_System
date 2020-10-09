package pl.coderslab.medical_devices_query_system.controllers.project.adminScope;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
public class AdminProjectInProgressListController {

    private final ProjectService projectService;
    private final UserService userService;

    @ModelAttribute("engineersList")
    List<User> showEngineetsList() {
        return userService.findUserByActiveAndRole(Role.ROLE_ENGINEER.toString());
    }


    @GetMapping("/project/inprogress")
    public String showProjectsInProgress(Model model) {
        List<Project> listOfProjectsInProgress = projectService.findAllByStatus(Status.IN_PROGRESS.toString());
        if (listOfProjectsInProgress.isEmpty()) {
            model.addAttribute("message", "Nie ma projektów w realizacji");
            return "project/listProjectInProgress";
        }
        model.addAttribute("projects", listOfProjectsInProgress);
        return "project/listProjectInProgress";
    }

}
