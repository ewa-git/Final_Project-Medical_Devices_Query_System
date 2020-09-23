package pl.coderslab.medical_devices_query_system.user.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.medical_devices_query_system.user.model.CurrentUser;
import pl.coderslab.medical_devices_query_system.user.model.User;

@Controller
@RequestMapping("/manager")
public class ManagerDashboardController {

    @RequestMapping("/dashboard")

    public String showManagerDashboard(@AuthenticationPrincipal User user){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "dashboardes/managerdashboard";
    }
}
