package pl.coderslab.medical_devices_query_system.project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.medical_devices_query_system.hospital.Hospital;
import pl.coderslab.medical_devices_query_system.hospital.HospitalService;
import pl.coderslab.medical_devices_query_system.system.System;
import pl.coderslab.medical_devices_query_system.system.SystemService;
import pl.coderslab.medical_devices_query_system.user.model.User;
import pl.coderslab.medical_devices_query_system.user.services.UserService;


import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/project")
public class ProjectController {

    private final UserService userService;
    private final SystemService systemService;
    private final  ProjectService projectService;
    private final HospitalService hospitalService;


    @ModelAttribute("loggedUser")
    public User showUser(Principal principal) {
        return userService.findUserByEmail(principal.getName());
    }

    @ModelAttribute("systems")
    public List<System> systemList(){
        return systemService.findAllByActive();
    }

    @ModelAttribute("hospitals")
    public List<Hospital> hospitalList(Principal principal){
        User manager = userService.findUserByEmail(principal.getName());
        return hospitalService.findAllByActiveAndManagerId(manager.getId());
    }

    @GetMapping("/add")
    public String showAddFormProject(Model model){
        model.addAttribute("project", new Project());
        return "project/addProject";
    }

    @PostMapping("/add")
    public String addFormProject(@Valid Project project, BindingResult result){
       if(result.hasErrors()){
           return "project/addProject";
       }
       projectService.save(project);
        return "redirect:/project/list";
    }

     @RequestMapping("/list")
    public String showProjectListActive(Model model){
        return "project/listProject";
     }




}
