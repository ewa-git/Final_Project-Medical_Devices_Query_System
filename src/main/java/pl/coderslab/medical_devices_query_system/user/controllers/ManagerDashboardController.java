package pl.coderslab.medical_devices_query_system.user.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.medical_devices_query_system.user.model.User;
import pl.coderslab.medical_devices_query_system.user.reposiories.UserRepository;

import java.security.Principal;


@Controller
@RequiredArgsConstructor
@RequestMapping("/manager")
public class ManagerDashboardController {
    private final UserRepository userRepository;

    @ModelAttribute("user")
    public User showUser(Principal principal) {
        return userRepository.findUserByEmail(principal.getName());
    }

    @RequestMapping("/dashboard")
    public String showManagerDashboard() {

        return "dashboardes/managerdashboard";
    }
}
