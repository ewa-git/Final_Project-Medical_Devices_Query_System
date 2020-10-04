package pl.coderslab.medical_devices_query_system.project;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.medical_devices_query_system.customization.exceptions.ElementNotFoundException;
import pl.coderslab.medical_devices_query_system.customization.exceptions.IdsAreNotTheSameException;
import pl.coderslab.medical_devices_query_system.hospital.Hospital;
import pl.coderslab.medical_devices_query_system.hospital.HospitalService;
import pl.coderslab.medical_devices_query_system.system.System;
import pl.coderslab.medical_devices_query_system.system.SystemService;
import pl.coderslab.medical_devices_query_system.user.model.User;
import pl.coderslab.medical_devices_query_system.user.services.UserService;


import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Controller
@RequestMapping("/project")
public class ProjectController {

    private final UserService userService;
    private final SystemService systemService;
    private final ProjectService projectService;
    private final HospitalService hospitalService;


    @ModelAttribute("loggedUser")
    public User showUser(Principal principal) {
        return userService.findUserByEmail(principal.getName());
    }

    @ModelAttribute("systems")
    public List<System> systemList() {
        return systemService.findAllByActive();
    }

    @ModelAttribute("hospitals")
    public List<Hospital> hospitalList(Principal principal) {
        User manager = userService.findUserByEmail(principal.getName());
        return hospitalService.findAllByActiveAndManagerId(manager.getId());
    }

    @GetMapping("/add")
    public String showAddFormProject(Model model) {
        model.addAttribute("project", new Project());
        return "project/addProject";
    }

    @PostMapping("/add")
    public String addFormProject(@Valid Project project, BindingResult result) {
        if (result.hasErrors()) {
            return "project/addProject";
        }
        projectService.save(project);
        return "redirect:/project/list";
    }

    @RequestMapping("/list")
    public String showProjectListActive(Principal principal, Model model) {
        User manager = userService.findUserByEmail(principal.getName());

        List<Project> projects = projectService.findAllByActiveAndManagerId(manager.getId());
        if (projects.isEmpty()) {
            model.addAttribute("message", "Nie dodano jeszcze projektów");
        }
        model.addAttribute("projects", projects);
        return "project/listProject";
    }

    @GetMapping("/edit/{id}")
    public String showEditFormProject(@PathVariable long id, Model model){
        Optional<Project> project = projectService.findProjectByActiveAndProjectId(id);
        if(!project.isPresent()){
            throw new ElementNotFoundException("Nie odnaleziono projektu o id" + id);
        }

        model.addAttribute("project", project.get());
        return "project/addProject";
    }

    @PostMapping("/edit/{id}")
    public String editProject(@PathVariable long id,
                              @Valid Project project,
                              BindingResult result){
        if(result.hasErrors()){
            return "project/addProject";
        }
        Optional<Project> projectFromDbOptional = projectService.findProjectByActiveAndProjectId(id);
        if(!projectFromDbOptional.isPresent()){
            throw new ElementNotFoundException("Nie odnaleziono projektu o id" + id);
        }
        Project projectFromDb = projectFromDbOptional.get();
        if(projectFromDb.getId() != project.getId()){
            throw new IdsAreNotTheSameException("Id podane w adresie nie zgadza się z tym z modelu");
        }

        projectService.updateProject(project, projectFromDb);
        return "redirect:/project/list";

    }

    @RequestMapping("/details/{id}")
    public String projectDetails(@PathVariable long id, Model model){
        Optional<Project> project = projectService.findProjectByActiveAndProjectId(id);
        if(!project.isPresent()){
            throw new ElementNotFoundException("Nie odnaleziono projektu o id" + id);
        }
        model.addAttribute("project", project.get());
        return "project/details";
    }

    @PostMapping("/remove")
    public String removeProject(@RequestParam long id){
        Optional<Project> project = projectService.findProjectByActiveAndProjectId(id);
        if(!project.isPresent()){
            throw new ElementNotFoundException("Nie odnaleziono projektu o id" + id);
        }
        projectService.deleteProject(project.get());
        return "redirect:/project/list";
    }

/*
    @RequestMapping("/list/done")
    public String showDoneProjectList(Model model){

    }
*/

}
