package pl.coderslab.medical_devices_query_system.user;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        user.getUserDetails().setPassword(passwordEncoder.encode(user.getUserDetails().getPassword()));
        userRepository.save(user);
        log.debug("Użytkownik zarejestrowany:", user);
        return "redirect:/login";
    }
}
