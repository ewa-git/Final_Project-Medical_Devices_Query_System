package pl.coderslab.medical_devices_query_system.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @GetMapping
    public String showRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "registration/registration";
    }
}
