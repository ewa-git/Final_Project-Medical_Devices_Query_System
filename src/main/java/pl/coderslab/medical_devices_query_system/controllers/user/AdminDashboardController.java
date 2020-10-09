package pl.coderslab.medical_devices_query_system.controllers.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminDashboardController {

    @RequestMapping("/dashboard")
    public String showAdminDashboard(){
        return "dashboardes/adminDashboard";
    }
}
