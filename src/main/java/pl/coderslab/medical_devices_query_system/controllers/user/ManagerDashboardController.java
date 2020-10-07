package pl.coderslab.medical_devices_query_system.controllers.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.medical_devices_query_system.model.user.User;
import pl.coderslab.medical_devices_query_system.services.UserService;

import java.security.Principal;


@Controller
@RequiredArgsConstructor
@RequestMapping("/manager")
public class ManagerDashboardController {
    private final UserService userService;


    @RequestMapping("/dashboard")
    public String showManagerDashboard() {

        return "dashboardes/managerDashboard";
    }
}
