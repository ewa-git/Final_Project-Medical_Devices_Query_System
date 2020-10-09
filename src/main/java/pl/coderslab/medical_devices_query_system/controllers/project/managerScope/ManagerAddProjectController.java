package pl.coderslab.medical_devices_query_system.controllers.project.managerScope;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.medical_devices_query_system.domain.model.hospital.Hospital;
import pl.coderslab.medical_devices_query_system.domain.model.project.Project;
import pl.coderslab.medical_devices_query_system.domain.model.system.System;
import pl.coderslab.medical_devices_query_system.domain.model.user.User;
import pl.coderslab.medical_devices_query_system.services.HospitalService;
import pl.coderslab.medical_devices_query_system.services.ProjectService;
import pl.coderslab.medical_devices_query_system.services.SystemService;
import pl.coderslab.medical_devices_query_system.services.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/project")
public class ManagerAddProjectController {

    private final UserService userService;
    private final SystemService systemService;
    private final ProjectService projectService;
    private final HospitalService hospitalService;

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
}
