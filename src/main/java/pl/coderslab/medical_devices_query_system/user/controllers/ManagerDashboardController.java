package pl.coderslab.medical_devices_query_system.user.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.medical_devices_query_system.user.model.User;
import pl.coderslab.medical_devices_query_system.user.services.UserService;

import java.security.Principal;


@Controller
@RequiredArgsConstructor
@RequestMapping("/manager")
public class ManagerDashboardController {
    private final UserService userService;

    @ModelAttribute("user")
    public User showUser(Principal principal) {
        return userService.findUserByEmail(principal.getName());
    }

    @RequestMapping("/dashboard")
    public String showManagerDashboard() {

        return "dashboardes/managerDashboard";
    }
}
