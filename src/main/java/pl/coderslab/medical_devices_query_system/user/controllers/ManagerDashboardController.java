package pl.coderslab.medical_devices_query_system.user.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ManagerDashboardController {

    @RequestMapping("/dashboard")
    public String showManagerDashboard(){
        return "dashboardes/managerdashboard";
    }
}
