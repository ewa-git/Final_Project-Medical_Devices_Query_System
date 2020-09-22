package pl.coderslab.medical_devices_query_system.user.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.medical_devices_query_system.user.model.Role;
import pl.coderslab.medical_devices_query_system.user.model.User;
import pl.coderslab.medical_devices_query_system.user.reposiories.UserRepository;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
@Slf4j
public class RegistrationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    @GetMapping
    public String showRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "registration/registration";
    }

    @PostMapping
    public String registerUser(@ModelAttribute User user){

        user.setRole(Role.MANAGER.toString());
        user.getUserData().setPassword(passwordEncoder.encode(user.getUserData().getPassword()));
        userRepository.save(user);
        log.debug("Użytkownik zarejestrowany:", user);
        return "redirect:/login";
    }
}
