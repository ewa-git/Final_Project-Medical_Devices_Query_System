package pl.coderslab.medical_devices_query_system.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login/login";
    }

}
