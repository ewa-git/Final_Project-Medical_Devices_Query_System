package pl.coderslab.medical_devices_query_system.controllers.user;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.medical_devices_query_system.model.project.Project;
import pl.coderslab.medical_devices_query_system.model.user.Role;
import pl.coderslab.medical_devices_query_system.model.user.User;
import pl.coderslab.medical_devices_query_system.services.ProjectService;
import pl.coderslab.medical_devices_query_system.model.project.Status;

import pl.coderslab.medical_devices_query_system.services.UserService;

import java.util.List;


@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
@SessionAttributes({"choose",  "change"})
public class AdminAssignProjectController {

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

    @PostMapping("/project/assign")
    public String assignProject(@RequestParam Long projectId,
                               @RequestParam Long userId, Model model){

        if(userId == null){
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

    @GetMapping("/project/inprogress")
    public String showProjectsInProgress(Model model){
        List<Project> listOfProjectsInProgress = projectService.findAllByStatus(Status.IN_PROGRESS.toString());
        if(listOfProjectsInProgress.isEmpty()){
            model.addAttribute("message", "Nie ma projektów w realizacji");
            return "project/listProjectInProgress";
        }
        model.addAttribute("projects", listOfProjectsInProgress);
        return "project/listProjectInProgress";
    }

    @PostMapping("/project/change")
    public String changeProjectOwner(@RequestParam Long projectId,
                                     @RequestParam Long userId,
                                     Model model){
        if(userId == null){
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
