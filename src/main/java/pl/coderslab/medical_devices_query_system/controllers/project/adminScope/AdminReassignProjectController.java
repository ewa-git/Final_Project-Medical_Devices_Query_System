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
@SessionAttributes("change")
public class AdminReassignProjectController {

    private final ProjectService projectService;
    private final UserService userService;

    @PostMapping("/project/change")
    public String changeProjectOwner(@RequestParam Long projectId,
                                     @RequestParam Long userId,
                                     Model model) {
        if (userId == null) {
            model.addAttribute("change", "Musisz wybrać użytkownika");
            return "redirect:/admin/project/inprogress";
        } else {
            model.addAttribute("change", "");
            Project projectFromDb = projectService.findProjectByActiveAndProjectId(projectId).get();
            User engineerFromDb = userService.findUserById(userId).get();
            projectService.assignProject(projectFromDb, engineerFromDb);
            return "redirect:/admin/project/inprogress";
        }
    }
}
