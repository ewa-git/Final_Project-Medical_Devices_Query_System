package pl.coderslab.medical_devices_query_system.controllers.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.medical_devices_query_system.customization.exceptions.exception.ElementNotFoundException;
import pl.coderslab.medical_devices_query_system.model.project.Project;
import pl.coderslab.medical_devices_query_system.model.project.Status;
import pl.coderslab.medical_devices_query_system.model.user.User;
import pl.coderslab.medical_devices_query_system.services.ProjectService;
import pl.coderslab.medical_devices_query_system.services.UserService;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/engineer")
@RequiredArgsConstructor
public class EngineerController {

    private final ProjectService projectService;
    private final UserService userService;

    @RequestMapping("/dashboard")
    public String showEngineerDashboard(){
        return "dashboardes/engineerDashboard";
    }

    @RequestMapping("/inprogress")
    public String showProjetsInProgress(Principal principal, Model model){
        User engineer = userService.findUserByEmail(principal.getName());
        List<Project> listOfProjects = projectService.findAllByStatusAndEngineerId(Status.IN_PROGRESS.toString(), engineer.getId());
        if(listOfProjects.isEmpty()){
            model.addAttribute("message", "Nie masz projektow w kolejce");
            return "project/engineerListOfProjectInProgress";
        }
        model.addAttribute("projects", listOfProjects);
        return "project/engineerListOfProjectInProgress";
    }

    @RequestMapping("/project/details/{id}")
            public String showProjectDetails(@PathVariable long id,  Model model){
        Optional<Project> project = projectService.findProjectByActiveAndProjectId(id);
        if(!project.isPresent()){
            throw new ElementNotFoundException("Nie odnaleziono projektu o id" + id);
        }
        model.addAttribute("project", project.get());
        return "project/engineerProjectDetails";
    }




}
