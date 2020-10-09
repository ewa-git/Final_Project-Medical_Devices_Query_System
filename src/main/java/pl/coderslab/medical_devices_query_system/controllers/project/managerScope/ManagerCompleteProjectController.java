package pl.coderslab.medical_devices_query_system.controllers.project.managerScope;

import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.medical_devices_query_system.exceptions.ElementNotFoundException;
import pl.coderslab.medical_devices_query_system.domain.model.project.Project;
import pl.coderslab.medical_devices_query_system.domain.model.user.User;
import pl.coderslab.medical_devices_query_system.services.ProjectService;
import pl.coderslab.medical_devices_query_system.services.UserService;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/engineer")
@RequiredArgsConstructor
public class ManagerCompleteProjectController {

    private final ProjectService projectService;
    private final UserService userService;

    @PostMapping("/project/complete")
    public String completeProject(@RequestParam long id,
                                  @RequestParam String comments,
                                  @RequestParam long managerId)
            throws TemplateException, IOException, MessagingException {

        Optional<Project> project = projectService.findProjectByActiveAndProjectId(id);
        if (!project.isPresent()) {
            throw new ElementNotFoundException("Nie odnaleziono projektu o id" + id);
        }
        Optional<User> managerOptional = userService.findUserById(managerId);
        if (!managerOptional.isPresent()) {
            throw new ElementNotFoundException("Nie odnaleziono użytkownika o id" + managerId);
        }
        projectService.completeProject(project.get(), comments, managerOptional.get().getEmail());
        return "redirect:/engineer/inprogress";
    }
}
