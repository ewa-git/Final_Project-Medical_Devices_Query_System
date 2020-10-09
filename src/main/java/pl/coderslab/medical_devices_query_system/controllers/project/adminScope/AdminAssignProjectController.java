package pl.coderslab.medical_devices_query_system.controllers.project.adminScope;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.medical_devices_query_system.domain.model.project.Project;
import pl.coderslab.medical_devices_query_system.domain.model.user.Role;
import pl.coderslab.medical_devices_query_system.domain.model.user.User;
import pl.coderslab.medical_devices_query_system.services.ProjectService;
import pl.coderslab.medical_devices_query_system.services.UserService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
@SessionAttributes("choose")
public class AdminAssignProjectController {

    private final ProjectService projectService;
    private final UserService userService;

    @PostMapping("/project/assign")
    public String assignProject(@RequestParam Long projectId,
                                @RequestParam Long userId, Model model) {
        if (userId == null) {
            model.addAttribute("choose", "Musisz wybrać użytkownika");
            return "redirect:/admin/project/queue";
        } else {
            model.addAttribute("choose", "");
            Project projectFromDb = projectService.findProjectByActiveAndProjectId(projectId).get();
            User engineerFromDb = userService.findUserById(userId).get();
            projectService.assignProject(projectFromDb, engineerFromDb);
            return "redirect:/admin/project/queue";
        }
    }
}
