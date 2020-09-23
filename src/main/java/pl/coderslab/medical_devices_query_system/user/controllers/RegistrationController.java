package pl.coderslab.medical_devices_query_system.user.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.medical_devices_query_system.user.model.User;
import pl.coderslab.medical_devices_query_system.user.services.RegistrationService;

@Controller
@RequestMapping("/register")
@Slf4j
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @GetMapping
    public String showRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "registration/registration";
    }

    @PostMapping
    public String registerUser(@ModelAttribute User user){
        registrationService.registerManager(user);
        return "redirect:/login";
    }
}
