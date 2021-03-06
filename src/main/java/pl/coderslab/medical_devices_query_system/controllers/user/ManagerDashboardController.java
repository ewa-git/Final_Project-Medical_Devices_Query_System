package pl.coderslab.medical_devices_query_system.controllers.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.medical_devices_query_system.services.UserService;


@Controller
@RequiredArgsConstructor
@RequestMapping("/manager")
public class ManagerDashboardController {

    @RequestMapping("/dashboard")
    public String showManagerDashboard() {
        return "dashboardes/managerDashboard";
    }
}
