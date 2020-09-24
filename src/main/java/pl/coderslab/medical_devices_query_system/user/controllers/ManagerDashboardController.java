package pl.coderslab.medical_devices_query_system.user.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


@Controller
@RequestMapping("/manager")
public class ManagerDashboardController {

    @RequestMapping("/dashboard")
    public String showManagerDashboard(Principal principal, Model model) {
        if (principal != null) {
            model.addAttribute("userLogin", principal.getName());
        }
        return "dashboardes/managerdashboard";
    }
}
