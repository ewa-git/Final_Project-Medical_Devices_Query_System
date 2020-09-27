package pl.coderslab.medical_devices_query_system.user.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.medical_devices_query_system.user.model.User;
import pl.coderslab.medical_devices_query_system.user.services.UserService;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/engineer")
public class AdminEngineerController {

    private final UserService userService;

    @GetMapping("/add")
    public String showAddFormUser(Model model){
        model.addAttribute("engineer", new User());
        return "engineer/addEngineer";
    }

    @PostMapping("/add")
    public String addEngineer(@Valid User user, BindingResult result){
        if(result.hasErrors()){
            return "engineer/addEngineer";
        }
        userService.createEngineer(user);
        return "redirect:/admin/engineer/list";
    }
}
