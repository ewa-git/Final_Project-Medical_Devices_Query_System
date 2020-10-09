package pl.coderslab.medical_devices_query_system.controllers.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/engineer")
@RequiredArgsConstructor
public class EngineerDashboardController {

    @RequestMapping("/dashboard")
    public String showEngineerDashboard() {
        return "dashboardes/engineerDashboard";
    }
}
