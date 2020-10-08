package pl.coderslab.medical_devices_query_system.controllers.user;

import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.medical_devices_query_system.customization.exceptions.exception.ElementNotFoundException;
import pl.coderslab.medical_devices_query_system.model.dbFIle.DbFile;
import pl.coderslab.medical_devices_query_system.model.dbFIle.DbFileList;
import pl.coderslab.medical_devices_query_system.model.project.Project;
import pl.coderslab.medical_devices_query_system.model.project.Status;
import pl.coderslab.medical_devices_query_system.model.user.User;
import pl.coderslab.medical_devices_query_system.repositories.DbFileRepository;
import pl.coderslab.medical_devices_query_system.services.DbFileService;
import pl.coderslab.medical_devices_query_system.services.ProjectService;
import pl.coderslab.medical_devices_query_system.services.UserService;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/engineer")
@RequiredArgsConstructor
public class EngineerController {

    private final ProjectService projectService;
    private final UserService userService;
    private final DbFileList dbFileList;
    private final DbFileService dbFileService;

    @RequestMapping("/dashboard")
    public String showEngineerDashboard() {
        return "dashboardes/engineerDashboard";
    }

    @RequestMapping("/inprogress")
    public String showProjectsInProgress(Principal principal, Model model) {
        User engineer = userService.findUserByEmail(principal.getName());
        List<Project> listOfProjects = projectService.findAllByStatusAndEngineerId(Status.IN_PROGRESS.toString(), engineer.getId());
        if (listOfProjects.isEmpty()) {
            model.addAttribute("message", "Nie masz projektow w kolejce");
            return "project/engineerListOfProjectInProgress";
        }
        model.addAttribute("projects", listOfProjects);
        return "project/engineerListOfProjectInProgress";
    }

    @RequestMapping("/project/details/{id}")
    public String showProjectDetails(@PathVariable long id, Model model) {
        Optional<Project> project = projectService.findProjectByActiveAndProjectId(id);

        if (!project.isPresent()) {
            throw new ElementNotFoundException("Nie odnaleziono projektu o id" + id);
        }
        DbFile dbFile = dbFileService.findDbFileByProjectId(project.get().getId());


        model.addAttribute("file", dbFile);
        model.addAttribute("project", project.get());
        return "project/engineerProjectDetails";
    }

    @PostMapping("/project/complete")
    public String completeProject(@RequestParam long id,
                                  @RequestParam String comments,
                                  @RequestParam long managerId) throws TemplateException, IOException, MessagingException {


        Optional<Project> project = projectService.findProjectByActiveAndProjectId(id);
        if (!project.isPresent()) {
            throw new ElementNotFoundException("Nie odnaleziono projektu o id" + id);
        }
        DbFile dbFile = dbFileService.findDbFileByProjectId(project.get().getId());
        Optional<User> managerOptional = userService.findUserById(managerId);
        if(!managerOptional.isPresent()){
            throw new ElementNotFoundException("Nie odnaleziono użytkownika o id" + managerId);
        }
        projectService.completeProject(project.get(), dbFile, comments, managerOptional.get().getEmail());
        return "redirect:/engineer/inprogress";
    }

    @RequestMapping("/completed")
    public String showCompletedProjects(Principal principal, Model model){
        User engineer = userService.findUserByEmail(principal.getName());
        List<Project> listOfProjects = projectService.findAllByStatusAndEngineerId(Status.COMPLETED.toString(), engineer.getId());
        if (listOfProjects.isEmpty()) {
            model.addAttribute("message", "Nie ukończyłeś jeszcze żadnego projektu");
            return "project/engineerListOfProjectInProgress";
        }
        model.addAttribute("projects", listOfProjects);
        return "project/engineerCompletedProjects";
    }

    @RequestMapping("/project/completed/details/{id}")
    public String showCompletedProjectDetails(@PathVariable long id, Model model) {
        Optional<Project> project = projectService.findProjectByActiveAndProjectId(id);
        if (!project.isPresent()) {
            throw new ElementNotFoundException("Nie odnaleziono projektu o id" + id);
        }
        model.addAttribute("project", project.get());
        return "project/engineerCompletedProjectDetails";
    }






}
